package com.azure.provisioning.expressions;

public class TypeExpression extends Expression {
    private final Class<?> type;

    public TypeExpression(Class<?> type) {
        this.type = type;
    }

    public Class<?> getType() {
        return type;
    }

    @Override
    BicepWriter write(BicepWriter writer) {
        String bicepTypeName = BicepTypeMapping.getBicepTypeName(type);
        if (bicepTypeName == null) {
            throw new UnsupportedOperationException("Failed to automatically map " + type.getName() + " into a TypeExpression. Please explicitly choose a primitive type like bool, int, string, object, array, etc.");
        }
        return writer.append(bicepTypeName);
    }
}