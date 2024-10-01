package com.azure.provisioning.implementation.bicep.syntax;

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