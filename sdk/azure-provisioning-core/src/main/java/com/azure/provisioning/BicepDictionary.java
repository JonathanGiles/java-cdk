package com.azure.provisioning;

import com.azure.provisioning.expressions.BicepSyntax;
import com.azure.provisioning.expressions.Expression;
import com.azure.provisioning.primitives.BicepValueReference;
import com.azure.provisioning.primitives.ProvisioningConstruct;

import java.util.*;

public class BicepDictionary<T> extends BicepValue<Map<String, BicepValue<T>>> {
    private Map<String, BicepValue<T>> values;

    Object getLiteralValue() {
        return values;
    }

    boolean isEmpty() {
        return super.isEmpty() || (getKind() == BicepValueKind.LITERAL && values.isEmpty());
    }

    public BicepDictionary() {
        this(null, (Map<String, BicepValue<T>>) null);
    }

    public BicepDictionary(Map<String, BicepValue<T>> values) {
        this(null, values);
    }

    protected BicepDictionary(BicepValueReference self, Expression expression) {
        super(self, expression);
        this.values = new HashMap<>();
    }

    private BicepDictionary(BicepValueReference self, Map<String, BicepValue<T>> values) {
        super(self);
        setKind(BicepValueKind.LITERAL);
        this.values = values != null ? new HashMap<>(values) : new HashMap<>();
    }

//    @EditorBrowsable(EditorBrowsableState.NEVER)
    public void assign(BicepDictionary<T> source) {
        assign((BicepValue) source);
    }

    @Override
    void assign(BicepValue source) {
        if (source instanceof BicepDictionary) {
            BicepDictionary<T> typed = (BicepDictionary<T>) source;
            this.values = typed.values;
        }
        super.assign(source);
    }

    public static <T> BicepDictionary<T> from(BicepVariable reference) {
        return new BicepDictionary<>(new BicepValueReference(reference, "<value>"), BicepSyntax.var(reference.getResourceName()));
    }

    private BicepValue<T> wrapValue(String key, BicepValue<T> value) {
        return value;
    }

    public BicepValue<T> get(String key) {
        return values.get(key);
    }

    public void put(String key, BicepValue<T> value) {
        values.put(key, wrapValue(key, value));
    }

    public void putAll(Map<? extends String, ? extends BicepValue<T>> m) {
        for (Map.Entry<? extends String, ? extends BicepValue<T>> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public BicepValue<T> remove(Object key) {
        return values.remove(key);
    }

    public void clear() {
        values.clear();
    }

    public Set<String> keySet() {
        return values.keySet();
    }

    public Collection<BicepValue<T>> values() {
        return values.values();
    }

    public Set<Map.Entry<String, BicepValue<T>>> entrySet() {
        return values.entrySet();
    }

    public boolean containsKey(Object key) {
        return values.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return values.containsValue(value);
    }

    public int size() {
        return values.size();
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }

//    @EditorBrowsable(EditorBrowsableState.NEVER)
    public static <T> BicepDictionary<T> defineProperty(
            ProvisioningConstruct construct,
            String propertyName,
            String[] bicepPath,
            boolean isOutput,
            boolean isRequired) {
        BicepDictionary<T> values = new BicepDictionary<>(new BicepValueReference(construct, propertyName, bicepPath));
        values.setOutput(isOutput);
        values.setRequired(isRequired);
        construct.getProvisioningProperties().put(propertyName, values);
        return values;
    }
}