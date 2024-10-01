package com.azure.provisioning;

import com.azure.provisioning.bicep.BicepProvisioningPlan;
import com.azure.provisioning.implementation.bicep.syntax.Expression;
import com.azure.provisioning.implementation.bicep.syntax.Statement;
import com.azure.provisioning.implementation.bicep.syntax.TargetScopeStatement;
import com.azure.provisioning.implementation.resolvers.InfrastructureResolver;
import com.azure.provisioning.primitives.Provisionable;
import com.azure.provisioning.primitives.ProvisioningConstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

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