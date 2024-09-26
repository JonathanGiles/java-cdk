package com.azure.provisioning;

import com.azure.provisioning.expressions.Expression;
import com.azure.provisioning.expressions.BicepSyntax;
import com.azure.provisioning.expressions.BicepTypeMapping;
import com.azure.provisioning.primitives.BicepValueReference;
import com.azure.provisioning.primitives.NamedProvisioningConstruct;
import com.azure.provisioning.primitives.ProvisioningConstruct;

/**
 * Represents a value or expression.
 *
 * @param <T> The type of the value.
 */
public class BicepValue<T> extends BicepValueBase {
    private T value;

    /**
     * Gets or sets the literal value. You can also rely on implicit conversions most of the time.
     *
     * @return the literal value
     */
    public T getValue() {
        // If someone is referencing an output of a named resource, rather than just return null, we'll return a reference expression
        if (isOutput() &&
            getKind() == BicepValueKind.UNSET &&
            ProvisioningConstruct.class.isAssignableFrom(value.getClass()) &&
            getSelf() != null &&
            getSelf().getConstruct() instanceof NamedProvisioningConstruct) {
                // TODO: This is obviously a hack but we need to decide if we'd rather have a separate type for outputs (kind of like we do with ResourceReference<T>) or whether we want to merge this concept into BicepValue<T>.
                try {
                    T val = (T) value.getClass().newInstance();
                    ((ProvisioningConstruct) val).overrideWithExpression(getSelf().getReference());
                    return val;
                } catch (InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
        }
        return value;
    }

    private void setValue(T value) {
        this.value = value;
    }

    @Override
    protected Object getLiteralValue() {
        return getValue();
    }

    @Override
    protected Expression getBicepType() {
        return BicepSyntax.Types.create(value.getClass());
    }

    /**
     * Creates a new BicepValue.
     *
     * @param literal the value
     */
    public BicepValue(T literal) {
        this(null, literal);
    }

    /**
     * Creates a new BicepValue.
     *
     * @param expression an expression that evaluates to the value
     */
    public BicepValue(Expression expression) {
        this(null, expression);
    }

    protected BicepValue(BicepValueReference self) {
        super(self);
    }

    protected BicepValue(BicepValueReference self, T literal) {
        super(self, literal);
        setValue(literal);
    }

    protected BicepValue(BicepValueReference self, Expression expression) {
        super(self, expression);
    }

    /**
     * Assigns a value to this property.
     *
     * @param source the source Bicep value to assign
     */
    public void assign(BicepValue<T> source) {
        assign((BicepValueBase) source);
    }

    @Override
    public void assign(BicepValueBase source) {
        if (source instanceof BicepValue) {
            BicepValue<T> typed = (BicepValue<T>) source;
            setValue(typed.getValue());
        }
        super.assign(source);
    }

    /**
     * Implicitly converts a value to a BicepValue.
     *
     * @param value the value to convert
     * @return the BicepValue
     */
    public static <T> BicepValue<T> from(T value) {
        if (value instanceof BicepValue) {
            BicepValue<?> e = (BicepValue<?>) value;
            if (e.getKind() == BicepValueKind.EXPRESSION) {
                return new BicepValue<>(e.getSelf(), e.getExpression());
            } else if (e.getKind() == BicepValueKind.UNSET && e.getSelf() != null) {
                return new BicepValue<>(e.getSelf(), e.getSelf().getReference());
            }
        }

        // If we're asking to convert BicepValue<Foo> to BicepValue<T> and Foo : T
        Class<?> type = value != null ? value.getClass() : Object.class;
        if (type.isAssignableFrom(BicepValue.class) && BicepValue.class.isAssignableFrom(type)) {
            BicepValue<?> bicep = (BicepValue<?>) value;
            return new BicepValue<>(bicep.getSelf(), (T) bicep.getLiteralValue());
        }

        // Otherwise just wrap the literal
        return new BicepValue<>(value);
    }

    /**
     * Implicitly converts an expression to a BicepValue.
     *
     * @param expression the expression to convert
     * @return the BicepValue
     */
    public static <T> BicepValue<T> from(Expression expression) {
        return new BicepValue<>(expression);
    }

    /**
     * Implicitly converts a BicepVariable to a BicepValue.
     *
     * @param reference the BicepVariable to convert
     * @return the BicepValue
     */
    public static <T> BicepValue<T> from(BicepVariable reference) {
        return new BicepValue<>(new BicepValueReference(reference, "<value>"), BicepSyntax.var(reference.getResourceName()));
    }

    /**
     * Special case conversions to string for things like Uri, AzureLocation, etc.
     *
     * @param value the BicepValue to convert
     * @return the BicepValue as a string
     */
    public static BicepValue<String> toString(BicepValue<?> value) {
        switch (value.getKind()) {
            case UNSET:
                return new BicepValue<>(value.getSelf());
            case EXPRESSION:
                return new BicepValue<>(value.getSelf(), value.getExpression());
            case LITERAL:
                return new BicepValue<>(value.getSelf(), BicepTypeMapping.toLiteralString(value.getLiteralValue()));
            default:
                throw new IllegalStateException("Unknown BicepValueKind!");
        }
    }

    /**
     * Defines a property for a provisioning construct.
     *
     * @param construct the provisioning construct
     * @param propertyName the property name
     * @param bicepPath the Bicep path
     * @param defaultValue the default value
     * @return the defined BicepValue
     */
    public static <T> BicepValue<T> defineProperty(ProvisioningConstruct construct,
                                                   String propertyName,
                                                   String[] bicepPath,
                                                   BicepValue<T> defaultValue) {
        return defineProperty(construct, propertyName, bicepPath, false, false, false, defaultValue);
    }

    /**
     * Defines a property for a provisioning construct.
     *
     * @param construct the provisioning construct
     * @param propertyName the property name
     * @param bicepPath the Bicep path
     * @param isOutput whether the property is an output
     * @param isRequired whether the property is required
     * @param isSecure whether the property is secure
     * @param defaultValue the default value
     * @return the defined BicepValue
     */
    public static <T> BicepValue<T> defineProperty(ProvisioningConstruct construct,
                                                   String propertyName,
                                                   String[] bicepPath,
                                                   boolean isOutput,
                                                   boolean isRequired,
                                                   boolean isSecure,
                                                   BicepValue<T> defaultValue) {
        BicepValue<T> val = new BicepValue<>(new BicepValueReference(construct, propertyName, bicepPath));
        val.setOutput(isOutput);
        val.setRequired(isRequired);
        val.setSecure(isSecure);
        if (defaultValue != null) {
            val.assign(defaultValue);
        }
        construct.getProvisioningProperties().put(propertyName, val);
        return val;
    }
}