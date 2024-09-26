package com.azure.provisioning.primitives;

import com.azure.provisioning.ProvisioningContext;

import java.util.function.Supplier;

public class LocalProvisioningContextProvider extends ProvisioningContextProvider {
    private final ThreadLocal<ProvisioningContext> current;

    public LocalProvisioningContextProvider() {
        this(ProvisioningContext::new);
    }

    public LocalProvisioningContextProvider(Supplier<ProvisioningContext> contextFactory) {
        this.current = ThreadLocal.withInitial(contextFactory != null ? contextFactory : ProvisioningContext::new);
    }

    @Override
    public ProvisioningContext getProvisioningContext() {
        return current.get();
    }
}