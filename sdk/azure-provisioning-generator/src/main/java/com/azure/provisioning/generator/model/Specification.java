package com.azure.provisioning.generator.model;

import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.Response;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.util.Context;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.provisioning.generator.Main;
import com.azure.provisioning.generator.utils.ReflectionUtils;
import com.azure.provisioning.generator.utils.ResourceNamespaceMapper;
import com.azure.resourcemanager.AzureResourceManager;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;


public abstract class Specification extends ModelBase {
    /**
     * ArmClient used for talking to the service so it can fetch lists of
     * supported versions for resources.
     */
    private static final AzureResourceManager AZURE_RESOURCE_MANAGER = AzureResourceManager
            .authenticate(new DefaultAzureCredentialBuilder().build(), new AzureProfile(AzureEnvironment.AZURE))
            .withSubscription("faa080af-c1d8-40ad-9cce-e1a450ca5b57");


//    static final AzureResourceManager arm = AzureResourceManager.authenticate(
//                    HttpPipelineProvider.buildHttpPipeline(new DefaultAzureCredentialBuilder().build(),
//                            new AzureProfile(AzureEnvironment.AZURE), null, new HttpLogOptions().setLogLevel(HttpLogDetailLevel.BODY_AND_HEADERS), null, null,
//                            List.of((callContext, nextPolicy) -> {
//                                callContext.getHttpRequest().setUrl(callContext.getHttpRequest().getUrl().toString().replace("2024-03-01", "2024-05-01"));
//                                return nextPolicy.process();
//                            }), null),
//                    new AzureProfile(AzureEnvironment.AZURE))
//            .withSubscription("faa080af-c1d8-40ad-9cce-e1a450ca5b57");

    // Flag indicating we don't need to clean the output directory
    // because it's merged with another spec that'll handle that for us

    private String providerName;

    private boolean skipCleaning = false;
    private List<Resource> resources = new ArrayList<>();

    private List<Role> roles = new ArrayList<>();

    private String docComments;

    private Map<String, ModelBase> modelNameMapping = new HashMap<>();

    private Map<Type, ModelBase> modelArmTypeMapping = new HashMap<>();

    public boolean isSkipCleaning() {
        return skipCleaning;
    }

    public void setSkipCleaning(boolean skipCleaning) {
        this.skipCleaning = skipCleaning;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public String getDocComments() {
        return docComments;
    }

    public Map<String, ModelBase> getModelNameMapping() {
        return modelNameMapping;
    }

    public Map<Type, ModelBase> getModelArmTypeMapping() {
        return modelArmTypeMapping;
    }

    public Specification(String name, String provisioningPackage) {
        super(name, provisioningPackage, null, null);
        TypeRegistry.register(this);
    }

    public Specification(String name, String provisioningPackage, Type armType, String description, String providerName) {
        super(name, provisioningPackage, armType, description);
        this.providerName = providerName;
        TypeRegistry.register(this);
    }

    public Reflections getReflections() {
        if (getArmType() instanceof Class<?>) {
            Class<?> clazz = (Class<?>) getArmType();
            ConfigurationBuilder configurationBuilder = new ConfigurationBuilder()
                    .forPackages(clazz.getPackageName())
                    .addScanners(Scanners.MethodsAnnotated, Scanners.FieldsAnnotated, Scanners.MethodsParameter, Scanners.MethodsReturn, Scanners.MethodsSignature);
            return new Reflections(configurationBuilder);
        }
        return null;
    }

    @Override
    public String toString() {
        return "<Specification " + getName() + ">";
    }

    public void build() {
        analyze();
        customize();
        lint();
        modelNameMapping.forEach((key, value) -> {
            value.generate();
        });

//        roles.forEach(role -> {generateBuiltInRoles();});
    }

    // Placeholder methods for analyze, customize, lint, and getGenerationPath
    public void analyze() {
        Map<Type, Method> resources = findConstructibleResources();
        this.resources = resources.keySet().stream().map(type -> new Resource(this, type)).toList();
        this.resources.forEach(resource -> {
            this.modelNameMapping.put(resource.getName(), resource);
            this.modelArmTypeMapping.put(resource.getArmType(), resource);
            resource.setProvisioningPackage(this.getProvisioningPackage());

            Field type = null;
            try {
                type = getType(resource);
                if (type != null) {
                    resource.setResourceType(type.getName());
                    resource.setResourceNamespace(ResourceNamespaceMapper.getNamespace(resource.getArmType()));
                }
            } catch (NoSuchFieldException e) {
                // do nothing - the field doesn't exist
            }
            Method creatorMethod = resources.get(resource.getArmType());
            resource.setProperties(findProperties(resource, creatorMethod, type));
        });

        AZURE_RESOURCE_MANAGER.providers()
                .getByName(this.providerName)
                .resourceTypes()
                .forEach(resourceType -> {
                    this.resources.forEach(resource -> {
                        if (resource.getResourceNamespace().equals(providerName + "/" + resourceType.resourceType())) {
                            List<String> stableVersions = resourceType.apiVersions()
                                    .stream()
                                    .filter(apiVersion -> !apiVersion.contains("preview"))
                                    .collect(Collectors.toUnmodifiableList());
                            resource.setResourceVersions(stableVersions);
                            if (stableVersions.isEmpty()) {
                                resource.setResourceVersions(List.of(resourceType.apiVersions().stream().sorted().collect(Collectors.toList()).getLast()));
                            }
                            resource.setDefaultResourceVersion(resource.getResourceVersions().getLast());
                        }
                    });
                });
    }

    private static Field getType(Resource resource) throws NoSuchFieldException {
        Class<?> currentClass = ((Class<?>) resource.getArmType());
        while (currentClass != null) {
            try {
                Field type = currentClass.getDeclaredField("type");
                if (type != null) {
                    return type;
                }
            } catch (NoSuchFieldException e) {
                // Do nothing
            }
            currentClass = currentClass.getSuperclass();
        }
        return null;
    }

    private List<Property> findProperties(Resource resource, Method creatorMethod, Field type) {
        List<Property> properties = new ArrayList<>();
        Arrays.stream(creatorMethod.getParameters())
                .forEach(param -> {
                    if (param.getType().equals(Context.class)) {
                        return;
                    }
                    if (ReflectionUtils.isSimpleType(param.getType())) {
                        Property property = new Property(resource, getOrCreateModelType(param.getType(), resource), type, param);
                        property.setRequired(true);
                        properties.add(property);
                    }
                });

        return properties;
    }

    private ModelBase getOrCreateModelType(Class<?> type, Resource resource) {
        if (TypeRegistry.get(type) != null) {
            return TypeRegistry.get(type);
        }
        ExternalModel externalModel = new ExternalModel(type);
        TypeRegistry.register(externalModel);
        return externalModel;
    }

    private Map<Type, Method> findConstructibleResources() {
        Map<Type, Method> resources = new HashMap<>();
        Reflections reflections = getReflections();
        Set<Method> methodsAnnotatedWith = reflections.getMethodsAnnotatedWith(ServiceMethod.class);
        methodsAnnotatedWith.stream()
                .filter(method -> method.getName().startsWith("create"))
                .filter(method -> method.getReturnType() != Mono.class)
                .forEach(method -> {
                    if (method.getReturnType() == Response.class) {
                        // with response method overwrites the convenience overloads
                        resources.put(((ParameterizedType) method.getGenericReturnType()).getActualTypeArguments()[0], method);
                    } else {
                        // add this only if the resource doesn't already exist
                        resources.putIfAbsent(method.getReturnType(), method);
                    }
                });

        return resources;
    }

    protected abstract void customize();

    @Override
    public void lint() {
        super.lint();
        modelNameMapping.values().forEach(model -> {
            model.lint();
        });
    }

    public void writeToFile(String name, String code) {
        File file = new File(Main.BASE_DIR, name + ".java");
        System.out.println("Writing to " + file.getAbsolutePath());
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(code);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    protected abstract String getGenerationPath();
//
//
//    protected <T> void customizeEnum(Consumer<EnumModel> action) {
//        action.accept(getEnum());
//    }
//
//    protected <T> void customizeModel(Consumer<ModelBase> action) {
//        action.accept(getModel());
//    }
//
//    protected void customizeModel(String modelName, Consumer<ModelBase> action) {
//        ModelBase model = Optional.ofNullable(getModelNameMapping().get(modelName))
//                .orElseThrow(() -> new IllegalStateException("Failed to find " + modelName + " to customize!"));
//        action.accept(model);
//    }
//
//    protected <T> void customizeProperty(String propertyName, Consumer<Property> action) {
//        customizeProperty(getModel(), propertyName, action);
//    }
//
//    protected void customizeProperty(String modelName, String propertyName, Consumer<Property> action) {
//        ModelBase model = Optional.ofNullable(getModelNameMapping().get(modelName))
//                .orElseThrow(() -> new IllegalStateException("Failed to find " + modelName + " to customize!"));
//        customizeProperty(model, propertyName, action);
//    }
//
//    private static void customizeProperty(ModelBase model, String propertyName, Consumer<Property> action) {
//        TypeModel typeModel = Optional.ofNullable((TypeModel) model)
//                .orElseThrow(() -> new IllegalStateException("Failed to find " + model.getName() + " to customize property!"));
//        Property property = typeModel.getProperties().stream()
//                .filter(p -> p.getName().equals(propertyName))
//                .findFirst()
//                .orElseThrow(() -> new IllegalStateException("Failed to find " + model.getName() + "." + propertyName + " to customize!"));
//        action.accept(property);
//    }
//
//    public <T> void removeProperty(String propertyName) {
//        TypeModel model = Optional.ofNullable((TypeModel) getModel())
//                .orElseThrow(() -> new IllegalStateException("Failed to find " + getModel().getClass().getName() + " to remove property!"));
//        Property property = model.getProperties().stream()
//                .filter(p -> p.getName().equals(propertyName))
//                .findFirst()
//                .orElseThrow(() -> new IllegalStateException("Failed to find property " + propertyName + " on type " + getModel().getClass().getName() + " to remove!"));
//        model.getProperties().remove(property);
//    }
//
//    public <T> void addNameRequirements(int max, int min, boolean lower, boolean upper, boolean digits, boolean hyphen, boolean underscore, boolean period, boolean parens) {
//        getResource().setNameRequirements(new NameRequirements(max, min, lower, upper, digits, hyphen, underscore, period, parens));
//    }
//
//    private String namespacePath = null;
//    private String generationPath = null;
//
//    /**
//     * Gets the namespace path, calculating it if it hasn't been set yet.
//     *
//     * @return the namespace path.
//     */
//    private String getNamespacePath() {
//        if (namespacePath != null) {
//            return namespacePath;
//        }
//
//        // TODO: This assumes we're always running in place, in the repo
//        String path = System.getProperty("user.dir");
//        while (path != null && !new File(path, ".git").exists()) {
//            // Walk up a level
//            path = new File(path).getParent();
//        }
//
//        // If all else fails, just use the current directory
//        if (path == null) {
//            path = System.getProperty("user.dir");
//        }
//
//        // Walk from the root of the repo into the provisioning folder
//        path = Paths.get(path, "sdk", "provisioning").toString();
//        if (!new File(path).exists()) {
//            throw new IllegalStateException("Directory " + path + " must exist to write " + getNamespace() + "!");
//        }
//
//        // Special case namespaces we're collapsing into the main Azure.Provisioning
//        String ns = switch (getNamespace()) {
//            case "Azure.Provisioning.Authorization", "Azure.Provisioning.Resources", "Azure.Provisioning.Roles" -> "Azure.Provisioning";
//            default -> getNamespace();
//        };
//
//        // Add on our namespace
//        if (ns != null) {
//            path = Paths.get(path, ns).toString();
//        }
//
//        namespacePath = path;
//        return namespacePath;
//    }
//
//    /**
//     * Gets the generation path, calculating it if it hasn't been set yet.
//     *
//     * @return the generation path.
//     */
//    private String getGenerationPath() {
//        if (generationPath != null) {
//            return generationPath;
//        }
//        // Implementation continues...
//        return null; // Placeholder return statement
//    }
}
