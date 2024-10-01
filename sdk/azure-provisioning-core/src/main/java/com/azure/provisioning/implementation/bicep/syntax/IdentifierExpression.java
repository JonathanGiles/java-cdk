package com.azure.provisioning.implementation.bicep.syntax;

public class IdentifierExpression extends Expression {
    private final String name;

    public IdentifierExpression(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    BicepWriter write(BicepWriter writer) {
        return writer.append(name);
    }
}