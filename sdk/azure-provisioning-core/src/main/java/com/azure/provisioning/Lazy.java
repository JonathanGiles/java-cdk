package com.azure.provisioning;

import java.util.function.Supplier;

public class Lazy<T> {
    private final Supplier<T> supplier;
    private T value;
    private boolean isInitialized = false;

    public Lazy(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    public T getValue() {
        if (!isInitialized) {
            value = supplier.get();
            isInitialized = true;
        }
        return value;
    }
}