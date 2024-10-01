package com.azure.provisioning.implementation.bicep.syntax;

public class NestedExpression extends Expression {
    private final Expression value;
    private final String nestedMember;

    public NestedExpression(Expression value, String nestedMember) {
        this.value = value;
        this.nestedMember = nestedMember;
    }

    public Expression getValue() {
        return value;
    }

    public String getNestedMember() {
        return nestedMember;
    }

    @Override
    BicepWriter write(BicepWriter writer) {
        return writer.append(value).append("::").append(nestedMember);
    }
}