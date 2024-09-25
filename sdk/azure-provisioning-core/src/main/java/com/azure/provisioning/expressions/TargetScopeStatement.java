package com.azure.provisioning.expressions;

public class TargetScopeStatement extends Statement {
    private final Expression scope;

    public TargetScopeStatement(Expression scope) {
        this.scope = scope;
    }

    public Expression getScope() {
        return scope;
    }

    @Override
    BicepWriter write(BicepWriter writer) {
        return writer.append("targetScope = ").append(scope).appendLine();
    }
}