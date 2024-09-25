package com.azure.provisioning.expressions;

public abstract class Expression {
    protected Expression() { }

    public static Expression from(boolean value) {
        return new BoolLiteral(value);
    }

    public static Expression from(int value) {
        return new IntLiteral(value);
    }

    public static Expression from(String value) {
        return new StringLiteral(value);
    }

    @Override
    public String toString() {
        return new BicepWriter().append(this).toString();
    }

    abstract BicepWriter write(BicepWriter writer);
}