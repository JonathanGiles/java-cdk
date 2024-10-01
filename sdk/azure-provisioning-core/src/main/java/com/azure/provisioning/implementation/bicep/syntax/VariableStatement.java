package com.azure.provisioning.implementation.bicep.syntax;

import java.util.ArrayList;
import java.util.List;

public class VariableStatement extends Statement {
    private final String name;
    private final Expression value;
    private final List<DecoratorExpression> decorators = new ArrayList<>();

    public VariableStatement(String name, Expression value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
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
            .append("var ").append(name).append(" = ").append(value).appendLine();
    }
}