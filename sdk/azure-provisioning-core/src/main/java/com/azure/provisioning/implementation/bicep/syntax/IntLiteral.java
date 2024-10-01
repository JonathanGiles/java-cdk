package com.azure.provisioning.implementation.bicep.syntax;

public class IntLiteral extends Literal {
    private final int value;

    public IntLiteral(int value) {
        super(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    BicepWriter write(BicepWriter writer) {
        return writer.append(Integer.toString(value));
    }
}