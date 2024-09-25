package com.azure.provisioning.expressions;

public class StringLiteral extends Literal {
    private final String value;

    public StringLiteral(String value) {
        super(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    BicepWriter write(BicepWriter writer) {
        if (value == null) {
            return writer.append("null");
        } else {
            return writer.append('\'').appendEscaped(value).append('\'');
        }
    }
}