package com.azure.provisioning.expressions;

import com.azure.provisioning.BicepDictionary;
import com.azure.provisioning.BicepValueBase;
import com.azure.provisioning.BicepDictionary;

import java.util.*;

public class BicepSyntax {

    public static BicepProgram program(Statement... body) {
        return new BicepProgram(body);
    }

    public static IdentifierExpression var(String name) {
        return new IdentifierExpression(name);
    }

    public static NullLiteral nullValue() {
        return new NullLiteral();
    }

    public static BoolLiteral value(boolean value) {
        return new BoolLiteral(value);
    }

    public static IntLiteral value(int value) {
        return new IntLiteral(value);
    }

    public static StringLiteral value(String value) {
        return new StringLiteral(value);
    }

    public static ArrayExpression array(Expression... values) {
        return new ArrayExpression(values);
    }

    // FIXME was called `object` in the original code
    public static ObjectExpression objectExpression(Map<String, Expression> properties) {
        return new ObjectExpression(properties.entrySet().stream()
                .map(e -> new PropertyExpression(e.getKey(), e.getValue()))
                .toArray(PropertyExpression[]::new));
    }

    // FIXME was called `object` in the original code
    public static ObjectExpression objectBicepValue(Map<String, BicepValueBase> properties) {
        return new ObjectExpression(properties.entrySet().stream()
                .map(e -> new PropertyExpression(e.getKey(), e.getValue().compile()))
                .toArray(PropertyExpression[]::new));
    }

    public static <T> ObjectExpression object(BicepDictionary<T> properties) {
        return new ObjectExpression(properties.keySet().stream()
                .map(k -> new PropertyExpression(k, properties.get(k).compile()))
                .toArray(PropertyExpression[]::new));
    }

    public static UnaryExpression not(Expression value) {
        return new UnaryExpression(UnaryOperator.NOT, value);
    }

    public static UnaryExpression negate(Expression value) {
        return new UnaryExpression(UnaryOperator.NEGATE, value);
    }

    public static UnaryExpression suppressNull(Expression value) {
        return new UnaryExpression(UnaryOperator.SUPPRESS_NULL, value);
    }

    public static BinaryExpression and(Expression left, Expression right) {
        return new BinaryExpression(left, BinaryOperator.AND, right);
    }

    public static BinaryExpression or(Expression left, Expression right) {
        return new BinaryExpression(left, BinaryOperator.OR, right);
    }

    public static BinaryExpression coalesce(Expression left, Expression right) {
        return new BinaryExpression(left, BinaryOperator.COALESCE, right);
    }

    public static BinaryExpression equal(Expression left, Expression right) {
        return new BinaryExpression(left, BinaryOperator.EQUAL, right);
    }

    public static BinaryExpression equalIgnoreCase(Expression left, Expression right) {
        return new BinaryExpression(left, BinaryOperator.EQUAL_IGNORE_CASE, right);
    }

    public static BinaryExpression notEqual(Expression left, Expression right) {
        return new BinaryExpression(left, BinaryOperator.NOT_EQUAL, right);
    }

    public static BinaryExpression notEqualIgnoreCase(Expression left, Expression right) {
        return new BinaryExpression(left, BinaryOperator.NOT_EQUAL_IGNORE_CASE, right);
    }

    public static BinaryExpression greater(Expression left, Expression right) {
        return new BinaryExpression(left, BinaryOperator.GREATER, right);
    }

    public static BinaryExpression greaterOrEqual(Expression left, Expression right) {
        return new BinaryExpression(left, BinaryOperator.GREATER_OR_EQUAL, right);
    }

    public static BinaryExpression less(Expression left, Expression right) {
        return new BinaryExpression(left, BinaryOperator.LESS, right);
    }

    public static BinaryExpression lessOrEqual(Expression left, Expression right) {
        return new BinaryExpression(left, BinaryOperator.LESS_OR_EQUAL, right);
    }

    public static BinaryExpression add(Expression left, Expression right) {
        return new BinaryExpression(left, BinaryOperator.ADD, right);
    }

    public static BinaryExpression subtract(Expression left, Expression right) {
        return new BinaryExpression(left, BinaryOperator.SUBTRACT, right);
    }

    public static BinaryExpression multiply(Expression left, Expression right) {
        return new BinaryExpression(left, BinaryOperator.MULTIPLY, right);
    }

    public static BinaryExpression divide(Expression left, Expression right) {
        return new BinaryExpression(left, BinaryOperator.DIVIDE, right);
    }

    public static BinaryExpression modulo(Expression left, Expression right) {
        return new BinaryExpression(left, BinaryOperator.MODULO, right);
    }

    public static ConditionalExpression conditional(Expression condition, Expression consequent, Expression alternate) {
        return new ConditionalExpression(condition, consequent, alternate);
    }

    public static FunctionCallExpression call(Expression func, Expression... args) {
        return new FunctionCallExpression(func, args);
    }

    public static FunctionCallExpression call(String func, Expression... args) {
        return call(var(func), args);
    }

    public static InterpolatedString interpolate(String format, Expression... values) {
        return new InterpolatedString(format, values);
    }

    public static MemberExpression get(Expression value, String name) {
        return new MemberExpression(value, name);
    }

    public static IndexExpression index(Expression value, Expression index) {
        return new IndexExpression(value, index);
    }

    public static class Types {
        public static TypeExpression create(Class<?> type) {
            return new TypeExpression(type);
        }

        public static final TypeExpression BOOL = create(boolean.class);
        public static final TypeExpression INT = create(int.class);
        public static final TypeExpression STRING = create(String.class);
        public static final TypeExpression OBJECT = create(Object.class);
        public static final TypeExpression ARRAY = create(Object[].class);
    }

    public static class Declare {
        public static ParameterStatement param(String name, Expression type, Expression defaultValue) {
            return new ParameterStatement(name, type, defaultValue);
        }

//        public static ParameterStatement param(String name, Expression type) {
//            return param(name, type, null);
//        }

        public static <T> ParameterStatement param(String name, Expression defaultValue) {
            return param(name, Types.create(defaultValue.getClass()), defaultValue);
        }

        public static <T> ParameterStatement param(String name) {
            return param(name, Types.create(Object.class), null);
        }

        public static VariableStatement var(String name, Expression value) {
            return new VariableStatement(name, value);
        }

        public static OutputStatement output(String name, Expression type, Expression value) {
            return new OutputStatement(name, type, value);
        }

        public static <T> OutputStatement output(String name, Expression value) {
            return output(name, Types.create(value.getClass()), value);
        }

        public static ResourceStatement resource(String name, Expression type, Expression body) {
            return new ResourceStatement(name, type, body);
        }

        public static ModuleStatement module(String name, Expression type, Expression body) {
            return new ModuleStatement(name, type, body);
        }
    }

    public static CommentStatement comment(String comment) {
        return new CommentStatement(comment);
    }

    public static DecoratorExpression decorator(String name, Expression... values) {
        return new DecoratorExpression(call(var(name), values));
    }

    public static ParameterStatement decorate(ParameterStatement target, String name, Expression... values) {
        target.getDecorators().add(decorator(name, values));
        return target;
    }

    public static VariableStatement decorate(VariableStatement target, String name, Expression... values) {
        target.getDecorators().add(decorator(name, values));
        return target;
    }

    public static OutputStatement decorate(OutputStatement target, String name, Expression... values) {
        target.getDecorators().add(decorator(name, values));
        return target;
    }

    public static ResourceStatement decorate(ResourceStatement target, String name, Expression... values) {
        target.getDecorators().add(decorator(name, values));
        return target;
    }

    public static ModuleStatement decorate(ModuleStatement target, String name, Expression... values) {
        target.getDecorators().add(decorator(name, values));
        return target;
    }
}