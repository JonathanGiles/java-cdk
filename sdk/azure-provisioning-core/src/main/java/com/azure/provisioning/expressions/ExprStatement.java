package com.azure.provisioning.expressions;

public class ExprStatement extends Statement {
    private final Expression expr;

    public ExprStatement(Expression expr) {
        this.expr = expr;
    }

    public Expression getExpression() {
        return expr;
    }

    @Override
    BicepWriter write(BicepWriter writer) {
        return writer.append(expr);
    }
}