package com.azure.provisioning.implementation.bicep.syntax;

import java.util.Arrays;

public class ArrayExpression extends Expression {
    private final Expression[] values;

    public ArrayExpression(Expression... values) {
        this.values = values;
    }

    public Expression[] getValues() {
        return values;
    }

    @Override
    BicepWriter write(BicepWriter writer) {
        return writer.append('[')
            .indent(w -> w.appendLine().appendAll(Arrays.asList(values), BicepWriter::append, BicepWriter::appendLine))
            .appendLine().append(']');
    }
}