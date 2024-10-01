package com.azure.provisioning.implementation.bicep.syntax;

public abstract class Statement {
    abstract BicepWriter write(BicepWriter writer);

    @Override
    public String toString() {
        return new BicepWriter().append(this).toString();
    }
}