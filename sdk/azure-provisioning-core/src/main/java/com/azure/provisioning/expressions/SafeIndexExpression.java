package com.azure.provisioning.expressions;

public class SafeIndexExpression extends Expression {
    private final Expression value;
    private final Expression index;

    public SafeIndexExpression(Expression value, Expression index) {
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
        return writer.append(value).append("[?").append(index).append(']');
    }
}