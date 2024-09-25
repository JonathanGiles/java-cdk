package com.azure.provisioning.expressions;

public abstract class Statement {
    abstract BicepWriter write(BicepWriter writer);

    @Override
    public String toString() {
        return new BicepWriter().append(this).toString();
    }
}