package com.azure.provisioning.expressions;

public class DecoratorExpression extends Expression {
    private final FunctionCallExpression call;

    public DecoratorExpression(FunctionCallExpression call) {
        this.call = call;
    }

    public FunctionCallExpression getCall() {
        return call;
    }

    @Override
    BicepWriter write(BicepWriter writer) {
        return writer.append("[").append(call).append("]");
    }
}