package com.azure.provisioning.implementation.bicep.syntax;

public class BoolLiteral extends Literal {
    private final boolean value;

    public BoolLiteral(boolean value) {
        super(value);
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    BicepWriter write(BicepWriter writer) {
        return writer.append(value ? "true" : "false");
    }
}