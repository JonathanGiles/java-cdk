package com.azure.provisioning.implementation.bicep.syntax;

import java.util.ArrayList;
import java.util.List;

public class OutputStatement extends Statement {
    private final String name;
    private final Expression type;
    private final Expression value;
    private final List<DecoratorExpression> decorators = new ArrayList<>();

    public OutputStatement(String name, Expression type, Expression value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Expression getType() {
        return type;
    }

    public Expression getValue() {
        return value;
    }

    public List<DecoratorExpression> getDecorators() {
        return decorators;
    }

    @Override
    BicepWriter write(BicepWriter writer) {
        return writer.appendAll(decorators, (w, d) -> w.append(d).appendLine(), w -> w)
            .append("output ").append(name).append(' ').append(type).append(" = ").append(value).appendLine();
    }
}