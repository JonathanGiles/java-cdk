package com.azure.provisioning.expressions;

import java.util.Arrays;

public class ObjectExpression extends Expression {
    private final PropertyExpression[] properties;

    public ObjectExpression(PropertyExpression... properties) {
        this.properties = properties;
    }

    public PropertyExpression[] getProperties() {
        return properties;
    }

    private static boolean isIdentifierChar(char c) {
        return Character.isLetterOrDigit(c) || c == '_';
    }

    @Override
    BicepWriter write(BicepWriter writer) {
        if (properties.length == 0) {
            return writer.append("{ }");
        } else {
            return writer.append('{')
                .indent(w -> w.appendLine().appendAll(Arrays.asList(properties),
                    (w1, p) -> {
                        boolean quote = p.getName().charAt(0) != '\'' && !p.getName().chars().allMatch(ch -> isIdentifierChar((char) ch));
                        if (quote) {
                            w1.append('\'');
                        }
                        w1.append(p.getName());
                        if (quote) {
                            w1.append('\'');
                        }
                        return w1.append(": ").append(p.getValue());
                    },
                    BicepWriter::appendLine))
                .appendLine().append('}');
        }
    }
}