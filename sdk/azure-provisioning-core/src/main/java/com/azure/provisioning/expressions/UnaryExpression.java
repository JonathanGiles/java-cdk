package com.azure.provisioning.expressions;

public class UnaryExpression extends Expression {
    private final UnaryOperator operator;
    private final Expression value;

    public UnaryExpression(UnaryOperator operator, Expression value) {
        this.operator = operator;
        this.value = value;
    }

    public UnaryOperator getOperator() {
        return operator;
    }

    public Expression getValue() {
        return value;
    }

    @Override
    BicepWriter write(BicepWriter writer) {
        switch (operator) {
            case NOT:
                return writer.append('!').append(value);
            case NEGATE:
                return writer.append('-').append(value);
            case SUPPRESS_NULL:
                return writer.append(value).append('!');
            default:
                throw new UnsupportedOperationException("Unknown UnaryOperator value " + operator);
        }
    }
}