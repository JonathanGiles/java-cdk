package com.azure.provisioning;

import com.azure.provisioning.expressions.BicepSyntax;
import com.azure.provisioning.expressions.Expression;
import com.azure.provisioning.primitives.BicepValueReference;
import com.azure.provisioning.primitives.NamedProvisioningConstruct;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class BicepValue<T> extends BicepValueBase {
    private T value;

    public T getValue() {
        if (isOutput() && getKind() == BicepValueKind.UNSET && ProvisioningConstruct.class.isAssignableFrom(getType()) && getSelf() != null && getSelf().getConstruct() instanceof NamedProvisioningConstruct) {
            try {
                T val = getType().getDeclaredConstructor().newInstance();
                ((ProvisioningConstruct) val).overrideWithExpression(getSelf().getReference());
                return val;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return value;
    }

    protected void setValue(T value) {
        this.value = value;
    }

    @Override
    protected Object getLiteralValue() {
        return getValue();
    }

    @Override
    protected Expression getBicepType() {
        return BicepSyntax.Types.create(getType());
    }

    public BicepValue(T literal) {
        this(null, literal);
    }

    public BicepValue(Expression expression) {
        this(null, expression);
    }

    protected BicepValue(BicepValueReference self) {
        super(self);
    }

    protected BicepValue(BicepValueReference self, T literal) {
        super(self, literal);
        this.value = literal;
    }

    protected BicepValue(BicepValueReference self, Expression expression) {
        super(self, expression);
    }

    public void assign(BicepValue<T> source) {
        assign((BicepValueBase) source);
    }

    @Override
    protected void assign(BicepValueBase source) {
        if (source instanceof BicepValue) {
            BicepValue<T> typed = (BicepValue<T>) source;
            setValue(typed.getValue());
        }
        super.assign(source);
    }

    public static <T> BicepValue<T> defineProperty(ProvisioningConstruct construct, String propertyName, String[] bicepPath, boolean isOutput, boolean isRequired, boolean isSecure, BicepValue<T> defaultValue) {
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

    public static <T> BicepValue<T> defineProperty(ProvisioningConstruct construct, String propertyName, String[] bicepPath) {
        return defineProperty(construct, propertyName, bicepPath, false, false, false, null);
    }

    public static <T> BicepValue<T> defineProperty(ProvisioningConstruct construct, String propertyName, String[] bicepPath, BicepValue<T> defaultValue) {
        return defineProperty(construct, propertyName, bicepPath, false, false, false, defaultValue);
    }

    public static <T> BicepValue<T> defineProperty(ProvisioningConstruct construct, String propertyName, String[] bicepPath, boolean isOutput, boolean isRequired, boolean isSecure) {
        return defineProperty(construct, propertyName, bicepPath, isOutput, isRequired, isSecure, null);
    }

    public static <T> BicepValue<T> defineProperty(ProvisioningConstruct construct, String propertyName, String[] bicepPath, boolean isOutput, boolean isRequired) {
        return defineProperty(construct, propertyName, bicepPath, isOutput, isRequired, false, null);
    }

    public static <T> BicepValue<T> defineProperty(ProvisioningConstruct construct, String propertyName, String[] bicepPath, boolean isOutput) {
        return defineProperty(construct, propertyName, bicepPath, isOutput, false, false, null);
    }

    public static <T> BicepValue<T> defineProperty(ProvisioningConstruct construct, String propertyName, String[] bicepPath, boolean isOutput, BicepValue<T> defaultValue) {
        return defineProperty(construct, propertyName, bicepPath, isOutput, false, false, defaultValue);
    }
}