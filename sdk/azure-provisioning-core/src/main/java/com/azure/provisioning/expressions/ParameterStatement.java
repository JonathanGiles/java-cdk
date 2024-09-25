package com.azure.provisioning.expressions;

import java.util.ArrayList;
import java.util.List;

public class ParameterStatement extends Statement {
    private final String name;
    private final Expression type;
    private final Expression defaultValue;
    private final List<DecoratorExpression> decorators = new ArrayList<>();

    public ParameterStatement(String name, Expression type, Expression defaultValue) {
        this.name = name;
        this.type = type;
        this.defaultValue = defaultValue;
    }

    public String getName() {
        return name;
    }

    public Expression getType() {
        return type;
    }

    public Expression getDefaultValue() {
        return defaultValue;
    }

    public List<DecoratorExpression> getDecorators() {
        return decorators;
    }

    @Override
    BicepWriter write(BicepWriter writer) {
        return writer.appendAll(decorators, (w, d) -> w.append(d).appendLine(), w -> w)
            .append("param ").append(name).append(' ').append(type)
            .appendIf(defaultValue != null, w -> w.append(" = ").append(defaultValue))
            .appendLine();
    }
}