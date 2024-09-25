package com.azure.provisioning.expressions;

public class PropertyExpression extends Expression {
    private final String name;
    private final Expression value;

    public PropertyExpression(String name, Expression value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Expression getValue() {
        return value;
    }

    @Override
    BicepWriter write(BicepWriter writer) {
        throw new UnsupportedOperationException("Properties are only valid inside an object");
    }
}