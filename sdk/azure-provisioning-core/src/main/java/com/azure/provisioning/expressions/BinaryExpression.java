package com.azure.provisioning.expressions;

public class BinaryExpression extends Expression {
    private final Expression left;
    private final BinaryOperator operator;
    private final Expression right;

    public BinaryExpression(Expression left, BinaryOperator operator, Expression right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public BinaryOperator getOperator() {
        return operator;
    }

    public Expression getRight() {
        return right;
    }

    @Override
    BicepWriter write(BicepWriter writer) {
        return writer.append('(').append(left).append(' ')
            .append(operator.getSymbol())
            .append(' ').append(right).append(')');
    }
}