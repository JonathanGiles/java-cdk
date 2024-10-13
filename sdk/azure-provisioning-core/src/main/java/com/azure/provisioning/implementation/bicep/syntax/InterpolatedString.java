package com.azure.provisioning.implementation.bicep.syntax;

import java.util.regex.Pattern;

public class InterpolatedString extends Expression {
    private final String format;
    private final Expression[] values;
    private static final Pattern FORMAT_ARGUMENT = Pattern.compile("(\\{\\d+\\})");

    public InterpolatedString(String format, Expression[] values) {
        this.format = format;
        this.values = values;
    }

//    public String getFormat() {
//        return format;
//    }
//
//    public Expression[] getValues() {
//        return values;
//    }

    @Override
    BicepWriter write(BicepWriter writer) {
        writer.append('\'');
        for (String segment : FORMAT_ARGUMENT.split(format)) {
            if (segment.isEmpty()) {
                continue;
            }

            if (FORMAT_ARGUMENT.matcher(segment).matches()) {
                Expression value = values[Integer.parseInt(segment.replaceAll("[{}]", ""))];
                if (value instanceof StringLiteral) {
                    writer.appendEscaped(((StringLiteral) value).getValue());
                } else {
                    writer.append("${").append(value).append('}');
                }
            } else {
                writer.appendEscaped(segment);
            }
        }
        writer.append('\'');
        return writer;
    }
}