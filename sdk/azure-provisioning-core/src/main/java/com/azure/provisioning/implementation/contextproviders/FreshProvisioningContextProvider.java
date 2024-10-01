package com.azure.provisioning.implementation.contextproviders;

import com.azure.provisioning.ProvisioningContext;

import java.util.function.Supplier;

public class FreshProvisioningContextProvider extends ProvisioningContextProvider {
    private final Supplier<ProvisioningContext> factory;

    public FreshProvisioningContextProvider(Supplier<ProvisioningContext> contextFactory) {
        this.factory = contextFactory != null ? contextFactory : ProvisioningContext::new;
    }

    @Override
    public ProvisioningContext getProvisioningContext() {
        return factory.get();
    }
}