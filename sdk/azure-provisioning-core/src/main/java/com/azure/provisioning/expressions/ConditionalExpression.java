package com.azure.provisioning.expressions;

public class ConditionalExpression extends Expression {
    private final Expression condition;
    private final Expression consequent;
    private final Expression alternate;

    public ConditionalExpression(Expression condition, Expression consequent, Expression alternate) {
        this.condition = condition;
        this.consequent = consequent;
        this.alternate = alternate;
    }

    public Expression getCondition() {
        return condition;
    }

    public Expression getConsequent() {
        return consequent;
    }

    public Expression getAlternate() {
        return alternate;
    }

    @Override
    BicepWriter write(BicepWriter writer) {
        return writer.append(condition).append(" ? ").append(consequent).append(" : ").append(alternate);
    }
}