package com.azure.provisioning.implementation.bicep.syntax;

public class IndexExpression extends Expression {
    private final Expression value;
    private final Expression index;

    public IndexExpression(Expression value, Expression index) {
        this.value = value;
        this.index = index;
    }

    public Expression getValue() {
        return value;
    }

    public Expression getIndex() {
        return index;
    }

    @Override
    BicepWriter write(BicepWriter writer) {
        return writer.append(value).append('[').append(index).append(']');
    }
}