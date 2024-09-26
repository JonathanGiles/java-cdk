package com.azure.provisioning.expressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ObjectExpression extends Expression {
    private final List<PropertyExpression> properties;

    public ObjectExpression(PropertyExpression... properties) {
        this.properties = new ArrayList<>(Arrays.asList(properties));
    }

    public List<PropertyExpression> getProperties() {
        return Collections.unmodifiableList(properties);
    }

    public ObjectExpression addProperty(PropertyExpression property) {
        properties.add(property);
        return this;
    }

    private static boolean isIdentifierChar(char c) {
        return Character.isLetterOrDigit(c) || c == '_';
    }

    @Override
    BicepWriter write(BicepWriter writer) {
        if (properties.isEmpty()) {
            return writer.append("{ }");
        } else {
            return writer.append('{')
                .indent(w -> w.appendLine().appendAll(properties,
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