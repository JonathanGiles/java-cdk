package com.azure.provisioning;

import com.azure.provisioning.bicep.BicepProvisioningPlan;
import com.azure.provisioning.implementation.bicep.syntax.Expression;
import com.azure.provisioning.implementation.bicep.syntax.Statement;
import com.azure.provisioning.implementation.bicep.syntax.TargetScopeStatement;
import com.azure.provisioning.implementation.resolvers.InfrastructureResolver;
import com.azure.provisioning.primitives.Provisionable;
import com.azure.provisioning.primitives.ProvisioningConstruct;

import java.util.*;

public class Infrastructure implements Provisionable {
    static final String DEFAULT_INFRASTRUCTURE_NAME = "main";

    private final String name;
    private String targetScope;
    private Infrastructure parent;
    private final List<Provisionable> resources = new ArrayList<>();

    public Infrastructure() {
        this(DEFAULT_INFRASTRUCTURE_NAME);
    }

    public Infrastructure(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getTargetScope() {
        return targetScope;
    }

    public void setTargetScope(String targetScope) {
        this.targetScope = targetScope;
    }

    @Override
    public List<Provisionable> getResources() {
        return resources;
    }

    public void add(Provisionable resource) {
        if (resource instanceof ProvisioningConstruct) {
            ProvisioningConstruct construct = (ProvisioningConstruct) resource;
            Infrastructure parent = construct.getParentInfrastructure().orElse(null);
            if (!this.equals(parent)) {
                if (construct.getExpressionOverride() != null) {
                    return;
                }
                if (parent != null) {
                    parent.remove(this);
                }
                resources.add(construct);
                construct.setParentInfrastructure(this);
            }
        } else if (resource instanceof Infrastructure) {
            Infrastructure nested = (Infrastructure) resource;
            if (nested.parent != this) {
                if (nested.parent != null) {
                    nested.parent.remove(this);
                }
                resources.add(nested);
                nested.parent = this;
            }
        }
    }

    public void remove(Provisionable resource) {
        if (resource instanceof ProvisioningConstruct) {
            ProvisioningConstruct construct = (ProvisioningConstruct) resource;
            Infrastructure parent = construct.getParentInfrastructure().orElse(null);
            if (this.equals(parent)) {
                construct.setParentInfrastructure(null);
                resources.remove(construct);
            }
        } else if (resource instanceof Infrastructure) {
            Infrastructure nested = (Infrastructure) resource;
            if (nested.parent == this) {
                nested.parent = null;
                resources.remove(nested);
            }
        }
    }

    private static boolean isAsciiLetterOrDigit(char ch) {
        return ('a' <= ch && ch <= 'z') ||
            ('A' <= ch && ch <= 'Z') ||
            ('0' <= ch && ch <= '9');
    }

    /**
     * Checks whether a name is a valid Bicep identifier name comprised of
     * letters, digits, and underscores.
     *
     * @param identifierName The proposed identifier name.
     * @return Whether the name is a valid Bicep identifier name.
     */
    public static boolean isValidIdentifierName(String identifierName) {
        if (identifierName == null || identifierName.isEmpty()) {
            return false;
        }
        if (Character.isDigit(identifierName.charAt(0))) {
            return false;
        }
        for (char ch : identifierName.toCharArray()) {
            if (!isAsciiLetterOrDigit(ch) && ch != '_') {
                return false;
            }
        }
        return true;
    }

    /**
     * Validates whether a given Bicep identifier name is correctly formed of
     * letters, numbers, and underscores.
     *
     * @param identifierName The proposed Bicep identifier name.
     * @param paramName Optional parameter name to use for exceptions.
     * @throws NullPointerException if identifierName is null.
     * @throws IllegalArgumentException if identifierName is empty or invalid.
     */
    public static void validateIdentifierName(String identifierName, String paramName) {
        paramName = Objects.requireNonNullElse(paramName, "identifierName");
        if (identifierName == null) {
            throw new NullPointerException(paramName + " cannot be null.");
        } else if (identifierName.isEmpty()) {
            throw new IllegalArgumentException(paramName + " cannot be empty.");
        } else if (Character.isDigit(identifierName.charAt(0))) {
            throw new IllegalArgumentException(paramName + " cannot start with a number: \"" + identifierName + "\"");
        }
        for (char ch : identifierName.toCharArray()) {
            if (!isAsciiLetterOrDigit(ch) && ch != '_') {
                throw new IllegalArgumentException(paramName + " should only contain letters, numbers, and underscores: \"" + identifierName + "\"");
            }
        }
    }

    /**
     * Normalizes a proposed Bicep identifier name. Any invalid characters
     * will be replaced with underscores.
     *
     * @param identifierName The proposed Bicep identifier name.
     * @return A valid Bicep identifier name.
     * @throws NullPointerException if identifierName is null.
     * @throws IllegalArgumentException if identifierName is empty.
     */
    public static String normalizeIdentifierName(String identifierName) {
        if (isValidIdentifierName(identifierName)) {
            return identifierName;
        }
        if (identifierName == null) {
            throw new NullPointerException("identifierName cannot be null.");
        } else if (identifierName.isEmpty()) {
            throw new IllegalArgumentException("identifierName cannot be empty.");
        }
        StringBuilder builder = new StringBuilder(identifierName.length());
        if (Character.isDigit(identifierName.charAt(0))) {
            builder.append('_');
        }
        for (char ch : identifierName.toCharArray()) {
            builder.append(isAsciiLetterOrDigit(ch) ? ch : '_');
        }
        return builder.toString();
    }

    @Override
    public void validate(ProvisioningContext context) {
        if (context == null) {
            context = ProvisioningContext.getProvider().getProvisioningContext();
        }
        for (Provisionable resource : getResources()) {
            resource.validate(context);
        }
    }

    @Override
    public void resolve(ProvisioningContext context) {
        if (context == null) {
            context = ProvisioningContext.getProvider().getProvisioningContext();
        }

        List<Provisionable> cached = new ArrayList<>(getResources());
        for (Provisionable resource : cached) {
            resource.resolve(context);
        }

        for (InfrastructureResolver resolver : context.getInfrastructureResolvers()) {
            resolver.resolveInfrastructure(context, this);
        }
    }

    @Override
    public List<Statement> compile(ProvisioningContext context) {
        if (context == null) {
            context = ProvisioningContext.getProvider().getProvisioningContext();
        }
        List<Statement> statements = new ArrayList<>();
        if (targetScope != null) {
            statements.add(new TargetScopeStatement(Expression.from(targetScope)));
        }

        List<Provisionable> resources = getResources();
        for (InfrastructureResolver resolver : context.getInfrastructureResolvers()) {
            resources = resolver.resolveResources(context, resources);
        }

        for (Provisionable resource : resources) {
            if (resource instanceof ProvisioningConstruct) {
                ProvisioningConstruct construct = (ProvisioningConstruct) resource;
                statements.addAll(construct.compile(context));
            } else if (resource instanceof Infrastructure) {
                throw new UnsupportedOperationException("Nested Infrastructure is not currently supported. Please build them separately and use ModuleImport to link them together.");
            }
        }
        return statements;
    }

    public Map<String, List<Statement>> compileModules(ProvisioningContext context) {
        if (context == null) {
            context = ProvisioningContext.getProvider().getProvisioningContext();
        }
        Map<String, List<Statement>> modules = new HashMap<>();
        modules.put(name, compile(context));

        List<Infrastructure> nested = new ArrayList<>();
        for (InfrastructureResolver resolver : context.getInfrastructureResolvers()) {
            nested.addAll(resolver.getNestedInfrastructure(context, this));
        }
        for (Infrastructure infra : nested) {
            modules.put(infra.getName(), infra.compile(context));
        }

        return modules;
    }

    public ProvisioningPlan build() {
        return build(null);
    }

    public ProvisioningPlan build(ProvisioningContext context) {
        if (context == null) {
            context = ProvisioningContext.getProvider().getProvisioningContext();
        }
        resolve(context);
        validate(context);

        context.setDefaultInfrastructure(context.getDefaultInfrastructureProvider().get());

        return new BicepProvisioningPlan(this, context);
    }
}