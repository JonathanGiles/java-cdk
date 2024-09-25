package com.azure.provisioning.expressions;

import com.azure.core.util.ETag;
import com.azure.provisioning.BicepValueBase;
import com.azure.provisioning.BicepValueKind;
import com.azure.provisioning.primitives.*;
import java.net.*;
import java.time.*;
import java.util.*;
import java.util.stream.*;

public class BicepTypeMapping {

    public static String getBicepTypeName(Class<?> type) {
        if (type == Boolean.class) return "bool";
        if (type == Integer.class) return "int";
        if (type == String.class) return "string";
        if (type == Object.class) return "object";
        if (type == URI.class) return "string";
        if (type == OffsetDateTime.class) return "string";
        if (type == Duration.class) return "string";
        if (type == UUID.class) return "string";
        if (type == InetAddress.class) return "string";
        if (type == ETag.class) return "string";
//        if (type == ResourceIdentifier.class) return "string";
//        if (type == ResourceType.class) return "string";
//        if (type == AzureLocation.class) return "string";
        if (Enum.class.isAssignableFrom(type)) return "string";
        if (Iterable.class.isAssignableFrom(type)) return "array";
        if (Map.class.isAssignableFrom(type)) return "object";
        return null;
    }

    public static String toLiteralString(Object value) {
        if (value instanceof Boolean) return value.toString();
        if (value instanceof Integer) return value.toString();
        if (value instanceof String) return (String) value;
        if (value instanceof URI) return ((URI) value).toString();
        if (value instanceof OffsetDateTime) return ((OffsetDateTime) value).toString();
        if (value instanceof Duration) return value.toString();
        if (value instanceof UUID) return value.toString();
        if (value instanceof InetAddress) return value.toString();
        if (value instanceof ETag) return value.toString();
//        if (value instanceof ResourceIdentifier) return value.toString();
        if (value instanceof Enum) return getEnumValue((Enum<?>) value);
//        if (value instanceof ValueType) return value.toString();
        throw new UnsupportedOperationException("Cannot convert " + value + " to a literal Bicep string.");
    }

    public static Expression toBicep(Object value) {
        if (value == null) return BicepSyntax.nullValue();
        if (value instanceof Boolean) return BicepSyntax.value((Boolean) value);
        if (value instanceof Integer) return BicepSyntax.value((Integer) value);
        if (value instanceof String) return BicepSyntax.value((String) value);
        if (value instanceof URI) return BicepSyntax.value(toLiteralString(value));
        if (value instanceof OffsetDateTime) return BicepSyntax.value(toLiteralString(value));
        if (value instanceof Duration) return BicepSyntax.value(toLiteralString(value));
        if (value instanceof UUID) return BicepSyntax.value(toLiteralString(value));
        if (value instanceof InetAddress) return BicepSyntax.value(toLiteralString(value));
        if (value instanceof ETag) return BicepSyntax.value(toLiteralString(value));
//        if (value instanceof ResourceIdentifier) return BicepSyntax.value(toLiteralString(value));
        if (value instanceof Enum) return BicepSyntax.value(toLiteralString(value));
        if (value instanceof ProvisioningConstruct) return compileNestedConstruct((ProvisioningConstruct) value);
        if (value instanceof Map) return toObject((Map<String, BicepValueBase>) value);
        if (value instanceof Iterable) return toArray((Iterable<Object>) value);
//        if (value instanceof ValueType) return BicepSyntax.value(toLiteralString(value));
        if (value instanceof BicepValueBase) {
            BicepValueBase bicepValue = (BicepValueBase) value;
            if (bicepValue.getKind() == BicepValueKind.EXPRESSION) return bicepValue.getExpression();
            if (bicepValue.getSource() != null) return bicepValue.getSource().getReference();
            if (bicepValue.getKind() == BicepValueKind.LITERAL) return toBicep(bicepValue.getLiteralValue());
            if (bicepValue.getSelf() != null) return bicepValue.getSelf().getReference();
            if (bicepValue.getKind() == BicepValueKind.UNSET) return BicepSyntax.nullValue();
        }
        throw new UnsupportedOperationException("Cannot convert " + value + " to a Bicep expression.");
    }

    private static ArrayExpression toArray(Iterable<Object> seq) {
        return BicepSyntax.array(StreamSupport.stream(seq.spliterator(), false)
                .map(BicepTypeMapping::toBicep)
                .toArray(Expression[]::new));
    }

    private static ObjectExpression toObject(Map<String, BicepValueBase> dict) {
        Map<String, Expression> values = new HashMap<>();
        for (Map.Entry<String, BicepValueBase> entry : dict.entrySet()) {
            values.put(entry.getKey(), toBicep(entry.getValue()));
        }
        return BicepSyntax.objectExpression(values);
    }

    private static Expression compileNestedConstruct(ProvisioningConstruct construct) {
        List<Statement> statements = construct.compile();
        if (statements.size() != 1 || !(statements.get(0) instanceof ExprStatement)) {
            throw new UnsupportedOperationException("Cannot convert " + construct + " into a Bicep expression.");
        }
        return ((ExprStatement) statements.get(0)).getExpression();
    }

    private static String getEnumValue(Enum<?> value) {
//        try {
//            DataMember member = value.getClass().getField(value.name()).getAnnotation(DataMember.class);
//            return member != null ? member.name() : value.toString();
//        } catch (NoSuchFieldException e) {
//            return value.toString();
//        }
        throw new RuntimeException("Not implemented");
    }
}