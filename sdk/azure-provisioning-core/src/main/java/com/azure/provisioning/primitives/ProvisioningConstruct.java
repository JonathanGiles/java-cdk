package com.azure.provisioning.primitives;

import com.azure.provisioning.*;
import com.azure.provisioning.implementation.bicep.syntax.BicepSyntax;
import com.azure.provisioning.implementation.bicep.syntax.Expression;
import com.azure.provisioning.implementation.bicep.syntax.ObjectExpression;
import com.azure.provisioning.implementation.bicep.syntax.Statement;
import com.azure.provisioning.implementation.bicep.syntax.ExprStatement;
import com.azure.provisioning.implementation.resolvers.PropertyResolver;

import java.util.*;

public abstract class ProvisioningConstruct implements Provisionable {
//    protected ProvisioningContext defaultProvisioningContext;
    private Infrastructure parentInfrastructure;
    private final Map<String, BicepValueBase> provisioningProperties = new HashMap<>();
    private Expression expressionOverride;

//    public ProvisioningConstruct(ProvisioningContext context) {
//        this.defaultProvisioningContext = context != null ? context : ProvisioningContext.getProvider().getProvisioningContext();
//    }

    public Optional<Infrastructure> getParentInfrastructure() {
        return Optional.ofNullable(parentInfrastructure);
    }

    public void setParentInfrastructure(Infrastructure parentInfrastructure) {
        this.parentInfrastructure = parentInfrastructure;
    }

    public Map<String, BicepValueBase> getProvisioningProperties() {
        return provisioningProperties;
    }

    public Expression getExpressionOverride() {
        return expressionOverride;
    }

    // FIXME I made this public, rather than protected, to avoid a compilation error
    public void overrideWithExpression(Expression reference) {
        this.expressionOverride = reference;
        if (parentInfrastructure != null) {
            parentInfrastructure.remove(this);
        }
        for (BicepValueBase property : provisioningProperties.values()) {
            property.setKind(BicepValueKind.EXPRESSION);
//            property.setExpression(property.getSelf().getBicepPath().stream().reduce(reference, Expression::get, (a, b) -> b));
            property.setOutput(true);
            throw new RuntimeException("Not implemented");
        }
    }

    public void setProvisioningProperty(BicepValueBase property, BicepValueBase value) {
        if (provisioningProperties.containsKey(property.getSelf().getPropertyName()) && provisioningProperties.get(property.getSelf().getPropertyName()) != property) {
            throw new IllegalArgumentException("Property " + property.getSelf().getPropertyName() + " is not defined on construct " + getClass().getSimpleName());
        }
        property.assign(value);
    }

    @Override
    public void resolve(ProvisioningContext context) {
        context = context != null ? context : ProvisioningContext.getProvider().getProvisioningContext();
//        super.resolve(context);
        for (PropertyResolver resolver : context.getPropertyResolvers()) {
            resolver.resolveProperties(context, this);
        }
    }

    @Override
    public void validate(ProvisioningContext context) {
        context = context != null ? context : ProvisioningContext.getProvider().getProvisioningContext();
//        super.validate(context);
    }

    protected void validateProperties() {
        for (BicepValueBase property : provisioningProperties.values()) {
            requireProperty(property);
        }
    }

    protected void requireProperty(BicepValueBase value) {
        if (value.isRequired() && value.getKind() == BicepValueKind.UNSET) {
            throw new IllegalStateException(getClass().getSimpleName() + " definition is missing required property " + value.getSelf().getPropertyName());
        }
    }

    public List<Statement> compile() {
        return compile(null);
    }

    @Override
    public List<Statement> compile(ProvisioningContext context) {
        return Collections.singletonList(new ExprStatement(compileProperties(context)));
    }

    protected Expression compileProperties() {
        return compileProperties(null);
    }

    protected Expression compileProperties(ProvisioningContext context) {
        if (expressionOverride != null) {
            return expressionOverride;
        }
        context = context != null ? context : ProvisioningContext.getProvider().getProvisioningContext();
        Map<String, Object> body = new HashMap<>();
        for (BicepValueBase property : provisioningProperties.values()) {
            if (!property.isEmpty()) {
                Map<String, Object> obj = body;
                final int bicepPathSize = property.getSelf().getBicepPath().size();
                for (int i = 0; i < bicepPathSize - 1; i++) {
                    obj = (Map<String, Object>) obj.computeIfAbsent(property.getSelf().getBicepPath().get(i), k -> new HashMap<>());
                }
                obj.put(property.getSelf().getBicepPath().get(bicepPathSize - 1), property);
            }
        }
        return compileValues(body);
    }

    private ObjectExpression compileValues(Map<String, Object> dict) {
        Map<String, Expression> bicep = new HashMap<>();
        for (Map.Entry<String, Object> pair : dict.entrySet()) {
            if (pair.getValue() instanceof Map) {
                bicep.put(pair.getKey(), compileValues((Map<String, Object>) pair.getValue()));
            } else if (pair.getValue() instanceof BicepValueBase) {
                bicep.put(pair.getKey(), ((BicepValueBase) pair.getValue()).compile());
            } else if (pair.getValue() instanceof ProvisioningConstruct) {
                List<Statement> statements = ((ProvisioningConstruct) pair.getValue()).compile(ProvisioningContext.getProvider().getProvisioningContext());
                if (statements.size() != 1 || !(statements.get(0) instanceof ExprStatement)) {
                    throw new IllegalStateException("Expected a single expression statement for " + pair.getKey());
                }
                bicep.put(pair.getKey(), ((ExprStatement) statements.get(0)).getExpression());
            } else {
                throw new IllegalStateException("Unexpected property value " + pair.getValue() + " for " + pair.getKey());
            }
        }
        return BicepSyntax.objectExpression(bicep);
    }
}