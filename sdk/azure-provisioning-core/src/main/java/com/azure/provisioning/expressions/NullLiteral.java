package com.azure.provisioning.expressions;

public class NullLiteral extends Literal {
    public NullLiteral() {
        super(null);
    }

    @Override
    BicepWriter write(BicepWriter writer) {
        return writer.append("null");
    }
}