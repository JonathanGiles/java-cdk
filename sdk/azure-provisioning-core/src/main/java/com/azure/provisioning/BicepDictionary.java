package com.azure.provisioning;

import com.azure.provisioning.implementation.bicep.syntax.BicepSyntax;
import com.azure.provisioning.implementation.bicep.syntax.Expression;
import com.azure.provisioning.primitives.BicepValueReference;
import com.azure.provisioning.primitives.ProvisioningConstruct;

import java.util.*;

public class BicepDictionary<T> extends BicepValueBase {
    private Map<String, BicepValueBase> values;

//    public static <T> BicepDictionary<T> from(ProvisioningVariable reference) {
//        // FIXME PROPERTY_NAME_BUG property name should not be "<value>"
////        return new BicepDictionary<>(new BicepValueReference(reference, "<value>"), BicepSyntax.var(reference.getResourceName()));
//        throw new RuntimeException("Not getting property name");
//    }

    public BicepDictionary() {
        this(null, (Map<String, BicepValue<T>>) null);
    }

//    public BicepDictionary(Map<String, BicepValue<T>> values) {
//        this(null, values);
//    }

    protected BicepDictionary(BicepValueReference self, Expression expression) {
        super(self, expression);
        this.values = new LinkedHashMap<>();
    }

    private BicepDictionary(BicepValueReference self) {
        this(self, (Map<String, BicepValue<T>>) null);
    }

    private BicepDictionary(BicepValueReference self, Map<String, BicepValue<T>> values) {
        super(self);
        setKind(BicepValueKind.LITERAL);
        this.values = values != null ? new LinkedHashMap<>(values) : new LinkedHashMap<>();
    }

    public static <T> BicepDictionary<T> from(ProvisioningVariable reference) {
        BicepDictionary<T> dictionary = new BicepDictionary<>(
            new BicepValueReference(reference, "<value>"),
            BicepSyntax.var(reference.getIdentifierName())
        );
        if (reference instanceof ProvisioningParameter) {
            dictionary.setSecure(((ProvisioningParameter) reference).isSecure());
        }
        return dictionary;
    }

    @Override
    public Map<String, BicepValueBase> getLiteralValue() {
        return values;
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty() || (getKind() == BicepValueKind.LITERAL && values.isEmpty());
    }

//    @EditorBrowsable(EditorBrowsableState.NEVER)
    public void assign(BicepDictionary<T> source) {
        assign((BicepValueBase) source);
    }

    @Override
    public void assign(BicepValueBase source) {
        if (source instanceof BicepDictionary) {
            BicepDictionary<T> typed = (BicepDictionary<T>) source;
            this.values = typed.values;
        }
        super.assign(source);
    }

    private BicepValue<T> wrapValue(String key, BicepValue<T> value) {
        return value;
    }

    public BicepValueBase get(String key) {
        return values.get(key);
    }

    public void put(String key, T value) {
//        values.put(key, BicepValue.from(value));
        if (value instanceof ProvisioningVariable) {
            BicepDictionary<T> dictionary = BicepDictionary.from((ProvisioningVariable) value);
            values.put(key, dictionary);
        } else {
            values.put(key, BicepValue.from(value));
        }
    }

    public void put(String key, BicepValue<T> value) {
        values.put(key, wrapValue(key, value));
    }
//
//    public void putAll(Map<? extends String, ? extends BicepValue<T>> m) {
//        for (Map.Entry<? extends String, ? extends BicepValue<T>> entry : m.entrySet()) {
//            put(entry.getKey(), entry.getValue());
//        }
//    }
//
//    public BicepValue<T> remove(Object key) {
//        return values.remove(key);
//    }
//
//    public void clear() {
//        values.clear();
//    }
//
    public Set<String> keySet() {
        return values.keySet();
    }
//
//    public Collection<BicepValue<T>> values() {
//        return values.values();
//    }
//
//    public Set<Map.Entry<String, BicepValue<T>>> entrySet() {
//        return values.entrySet();
//    }
//
//    public boolean containsKey(Object key) {
//        return values.containsKey(key);
//    }
//
//    public boolean containsValue(Object value) {
//        return values.containsValue(value);
//    }
//
//    public int size() {
//        return values.size();
//    }

//    public boolean isEmpty() {
//        return values.isEmpty();
//    }

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