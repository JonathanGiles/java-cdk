package com.azure.provisioning.primitives;

import com.azure.provisioning.BicepValueBase;
import com.azure.provisioning.ProvisioningContext;
import com.azure.provisioning.ProvisioningPlan;
import com.azure.provisioning.implementation.bicep.syntax.*;
import com.azure.provisioning.tmp.ResourceType;

import java.util.*;

public abstract class Resource extends NamedProvisioningConstruct {
    private final ResourceType resourceType;
    private String resourceVersion;
    private boolean isExistingResource = false;
    private final List<Resource> dependsOn = new ArrayList<>();

    public Resource(String resourceName, ResourceType resourceType) {
        this(resourceName, resourceType, null);
    }

    public Resource(String resourceName, ResourceType resourceType, String resourceVersion) {
        super(resourceName);
        this.resourceType = resourceType;
        this.resourceVersion = resourceVersion;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public String getResourceVersion() {
        return resourceVersion;
    }

    public void setResourceVersion(String resourceVersion) {
        this.resourceVersion = resourceVersion;
    }

    public boolean isExistingResource() {
        return isExistingResource;
    }

    protected void setExistingResource(boolean existingResource) {
        isExistingResource = existingResource;
    }

    public List<Resource> getDependsOn() {
        return dependsOn;
    }

    public ProvisioningPlan build(ProvisioningContext context) {
//        if (context == null) {
//            context = getDefaultProvisioningContext();
//        }
        return context.getDefaultInfrastructure().build(context);
    }

    @Override
    public void validate(ProvisioningContext context) {
        super.validate(context);

        if (resourceVersion == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " resource " + getIdentifierName() + " must have resourceVersion specified.");
        }

        if (!dependsOn.isEmpty() && (isExistingResource || getExpressionOverride() != null)) {
            throw new IllegalStateException(getClass().getSimpleName() + " resource " + getIdentifierName() + " cannot have dependencies if it's an existing resource or an expression override.");
        }

        if (isExistingResource) {
            BicepValueBase name = getProvisioningProperties().get("Name");
            if (name != null && name.isRequired()) {
                requireProperty(name);
            }
        } else {
            validateProperties();
        }
    }

    @Override
    public List<Statement> compile(ProvisioningContext context) {
        if (getExpressionOverride() != null) {
            return Collections.singletonList(new ExprStatement(getExpressionOverride()));
        }

        Expression body = compileProperties();

        if (!dependsOn.isEmpty()) {
            if (!(body instanceof ObjectExpression)) {
                throw new IllegalStateException(getClass().getSimpleName() + " resource " + getIdentifierName() + " cannot have dependencies if it's an existing resource or an expression override.");
            }

            ArrayExpression dependencies = new ArrayExpression(dependsOn.stream().map(r -> BicepSyntax.var(r.getIdentifierName())).toArray(Expression[]::new));

            // TODO review this - the original C# code was the following:
//            ArrayExpression dependencies = new(DependsOn.Select(r => BicepSyntax.Var(r.ResourceName)).ToArray());
//            body = new ObjectExpression([.. obj.Properties, new PropertyExpression("dependsOn", dependencies)]);
            // and I translated it to the following (which, adds the property to the existing instance):
            ((ObjectExpression) body).addProperty(new PropertyExpression("dependsOn", dependencies));
        }

        // FIXME I'm fairly certain that this code is expecting the C# string itnterpolation feature, and is using
        // the interpolation specified here: https://github.com/Azure/azure-sdk-for-net/blob/main/sdk/provisioning/Azure.Provisioning/src/Expressions/BicepFunction.cs#L302
        // but for now, I'm just commenting it out, as I'm not sure how to translate it to Java and want to get a full
        // compilation first.
        ResourceStatement resource = BicepSyntax.Declare.resource(getIdentifierName(), Expression.from(resourceType + "@" + resourceVersion), body);
        if (isExistingResource) {
            resource.setExisting(true);
        }
//        throw new RuntimeException("Not implemented");

        return Collections.singletonList(resource);
    }

//    @EditorBrowsable(EditorBrowsableState.NEVER)
    public ResourceNameRequirements getResourceNameRequirements() {
        return new ResourceNameRequirements(1, 24, ResourceNameCharacters.LOWERCASE_LETTERS);
    }
}