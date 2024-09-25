package com.azure.provisioning.expressions;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BicepWriter {
    private final StringBuilder text = new StringBuilder();
    private int indent = 0;

    @Override
    public String toString() {
        return text.toString();
    }

    public BicepWriter append(char ch) {
        text.append(ch);
        return this;
    }

    public BicepWriter append(String text) {
        this.text.append(text);
        return this;
    }

    public BicepWriter indent(Function<BicepWriter, BicepWriter> write) {
        indent++;
        BicepWriter writer = write.apply(this);
        indent--;
        return writer;
    }

    public BicepWriter appendLine() {
        text.append(System.lineSeparator());
        int currentIndent = indent;
        while (currentIndent-- > 0) {
            text.append("  ");
        }
        return this;
    }

    public BicepWriter appendEscaped(String text) {
        for (char ch : text.toCharArray()) {
            switch (ch) {
                case '\\':
                    append("\\\\");
                    break;
                case '\'':
                    append("\\'");
                    break;
                case '\n':
                    append("\\n");
                    break;
                case '\r':
                    append("\\r");
                    break;
                case '\t':
                    append("\\t");
                    break;
                case '$':
                    append("\\$");
                    break;
                default:
                    append(ch);
                    break;
            }
        }
        return this;
    }

    public BicepWriter appendIf(boolean condition, Function<BicepWriter, BicepWriter> write) {
        return condition ? write.apply(this) : this;
    }

    public <T extends Expression> BicepWriter appendAll(Iterable<T> values, BiFunction<BicepWriter, T, BicepWriter> append, Function<BicepWriter, BicepWriter> separate) {
        boolean first = true;
        BicepWriter writer = this;
        if (values != null) {
            for (T value : values) {
                if (!first && separate != null) {
                    writer = separate.apply(writer);
                }
                first = false;
                writer = append.apply(writer, value);
            }
        }
        return writer;
    }

    public BicepWriter append(Expression expr) {
        return expr.write(this);
    }

    public BicepWriter append(Statement stmt) {
        return stmt.write(this);
    }
}