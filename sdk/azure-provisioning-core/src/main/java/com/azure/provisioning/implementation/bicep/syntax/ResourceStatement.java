package com.azure.provisioning.implementation.bicep.syntax;

import java.util.ArrayList;
import java.util.List;

public class ResourceStatement extends Statement {
    private final String name;
    private final Expression type;
    private final Expression body;
    private boolean existing;
    private final List<DecoratorExpression> decorators = new ArrayList<>();

    public ResourceStatement(String name, Expression type, Expression body) {
        this.name = name;
        this.type = type;
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public Expression getType() {
        return type;
    }

    public Expression getBody() {
        return body;
    }

    public boolean isExisting() {
        return existing;
    }

    public void setExisting(boolean existing) {
        this.existing = existing;
    }

    public List<DecoratorExpression> getDecorators() {
        return decorators;
    }

    @Override
    BicepWriter write(BicepWriter writer) {
        return writer.appendAll(decorators, (w, d) -> w.append(d).appendLine(), w -> w)
            .append("resource ").append(name).append(' ').append(type)
            .appendIf(existing, w -> w.append(" existing"))
            .append(" = ").append(body).appendLine();
    }
}