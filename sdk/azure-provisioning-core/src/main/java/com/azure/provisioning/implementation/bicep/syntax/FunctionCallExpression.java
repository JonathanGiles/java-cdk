package com.azure.provisioning.implementation.bicep.syntax;

import java.util.Arrays;
import java.util.List;

public class FunctionCallExpression extends Expression {
    private final Expression function;
    private final Expression[] arguments;

    public FunctionCallExpression(Expression function, Expression... arguments) {
        this.function = function;
        this.arguments = arguments;
    }

    public FunctionCallExpression(Expression function, List<Expression> arguments) {
        this.function = function;
        this.arguments = arguments.toArray(new Expression[0]);
    }

    public Expression getFunction() {
        return function;
    }

    public Expression[] getArguments() {
        return arguments;
    }

    @Override
    BicepWriter write(BicepWriter writer) {
        return writer.append(function).append('(').appendAll(Arrays.asList(arguments), BicepWriter::append, w -> w.append(", ")).append(')');
    }
}