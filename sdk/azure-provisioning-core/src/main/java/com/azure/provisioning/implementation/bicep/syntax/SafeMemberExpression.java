package com.azure.provisioning.implementation.bicep.syntax;

public class SafeMemberExpression extends Expression {
    private final Expression value;
    private final String member;

    public SafeMemberExpression(Expression value, String member) {
        this.value = value;
        this.member = member;
    }

    public Expression getValue() {
        return value;
    }

    public String getMember() {
        return member;
    }

    @Override
    BicepWriter write(BicepWriter writer) {
        return writer.append(value).append(".?").append(member);
    }
}