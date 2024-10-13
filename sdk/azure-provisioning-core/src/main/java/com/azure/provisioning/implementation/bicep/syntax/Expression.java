package com.azure.provisioning.implementation.bicep.syntax;

import com.azure.provisioning.BicepValue;

public abstract class Expression<T> {
    protected Expression() { }

    public static Expression<Boolean> from(boolean value) {
        return new BoolLiteral(value);
    }

    public static Expression<Integer> from(int value) {
        return new IntLiteral(value);
    }

    public static Expression<String> from(String value) {
        return new StringLiteral(value);
    }

    public BicepValue<?> toBicepValue() {
//        return new BicepValue<>(this);
        return BicepValue.from(this);
    }

    @Override
    public String toString() {
        return new BicepWriter().append(this).toString();
    }

    abstract BicepWriter write(BicepWriter writer);
}