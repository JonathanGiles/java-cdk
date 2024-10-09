package com.azure.provisioning;

import com.azure.provisioning.implementation.bicep.syntax.BicepSyntax;
import com.azure.provisioning.implementation.bicep.syntax.Expression;
import com.azure.provisioning.primitives.BicepValueReference;
import com.azure.provisioning.primitives.ProvisioningConstruct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class BicepList<T> extends BicepValue { // implements List<BicepValue<T>> {
    private List<BicepValue<T>> values;
    private Function<Expression, T> referenceFactory = null;

    @Override
    public Object getLiteralValue() {
        return values;
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty() || (getKind() == BicepValueKind.LITERAL && values.isEmpty());
    }

//    public BicepList() {
//        this((BicepValueReference) null, (List<BicepValue<T>>) null);
//    }
//
//    public BicepList(List<BicepValue<T>> values) {
//        this(null, values);
//    }

    private BicepList(Expression expression) {
        this(null, expression);
    }

    private BicepList(BicepValueReference self, Expression expression) {
        super(self, expression);
        this.values = new ArrayList<>();
    }

    private BicepList(BicepValueReference self) {
        this(self, (Expression) null);
    }

    private BicepList(BicepValueReference self, List<BicepValue<T>> values) {
        super(self);
        setKind(BicepValueKind.LITERAL);
        this.values = values != null ? new ArrayList<>(values) : new ArrayList<>();
    }

//    @EditorBrowsable(EditorBrowsableState.NEVER)
//    public void assign(BicepList<T> source) {
//        assign((BicepValue) source);
//    }

    @Override
    public void assign(BicepValueBase source) {
        if (source instanceof BicepList<?>) {
            BicepList<T> typed = (BicepList<T>) source;
            this.values = typed.values;
        }
        super.assign(source);
    }

    public static <T> BicepList<T> fromProvisioningVariable(ProvisioningVariable reference) {
        BicepList<T> list = new BicepList<>(
            new BicepValueReference(reference, "<value>"),
            BicepSyntax.var(reference.getIdentifierName())
        );
        if (reference instanceof ProvisioningParameter) {
            list.setSecure(((ProvisioningParameter) reference).isSecure());
        }
        return list;
    }

    private BicepValue<T> wrapValue(BicepValue<T> value) {
        return value;
    }

    public BicepValue<T> get(int index) {
        throw new RuntimeException("Not implemented");
//        if (getKind() == BicepValueKind.EXPRESSION) {
//            return referenceFactory.apply(BicepSyntax.index(getExpression(), BicepSyntax.value(index)));
//        } else {
//            return values.get(index);
//        }
    }

    public void set(int index, BicepValue<T> value) {
        if (getKind() == BicepValueKind.EXPRESSION || isOutput()) {
            throw new IllegalStateException("Cannot assign to " + getSelf().getPropertyName());
        }
        values.set(index, wrapValue(value));
    }

    public void insert(int index, BicepValue<T> item) {
        values.add(index, wrapValue(item));
    }

    public void add(BicepValue<T> item) {
        values.add(wrapValue(item));
    }

    public void removeAt(int index) {
        values.remove(index);
    }

    public void clear() {
        values.clear();
    }

    public boolean remove(BicepValue<T> item) {
        return values.remove(item);
    }

    public int size() {
        return values.size();
    }

    public boolean isReadOnly() {
        return false;
    }

    public int indexOf(BicepValue<T> item) {
        return values.indexOf(item);
    }

    public boolean contains(BicepValue<T> item) {
        return values.contains(item);
    }

    public void copyTo(BicepValue<T>[] array, int arrayIndex) {
        for (int i = 0; i < values.size(); i++) {
            array[arrayIndex + i] = values.get(i);
        }
    }

    public Iterator<BicepValue<T>> iterator() {
        return values.iterator();
    }

    public static <T> BicepList<T> fromExpression(Function<Expression, T> referenceFactory, Expression expression) {
        BicepList<T> list = new BicepList<>(expression);
        list.referenceFactory = referenceFactory;
        return list;
    }

//    @EditorBrowsable(EditorBrowsableState.NEVER)
    public static <T> BicepList<T> defineProperty(
        ProvisioningConstruct construct,
        String propertyName,
        String[] bicepPath,
        boolean isOutput,
        boolean isRequired
    ) {
        BicepList<T> values = new BicepList<>(new BicepValueReference(construct, propertyName, bicepPath));
        values.setOutput(isOutput);
        values.setRequired(isRequired);
        construct.getProvisioningProperties().put(propertyName, values);
        return values;
    }
}