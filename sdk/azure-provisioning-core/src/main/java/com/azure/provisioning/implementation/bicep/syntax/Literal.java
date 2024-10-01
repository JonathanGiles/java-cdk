package com.azure.provisioning.implementation.bicep.syntax;

public abstract class Literal extends Expression {
    private final Object literalValue;

    protected Literal(Object literalValue) {
        this.literalValue = literalValue;
    }

    public Object getLiteralValue() {
        return literalValue;
    }
}