package com.azure.provisioning.primitives;

import com.azure.provisioning.ProvisioningContext;

public class SharedProvisioningContextProvider extends ProvisioningContextProvider {
    private final ProvisioningContext context;

    public SharedProvisioningContextProvider(ProvisioningContext context) {
        this.context = context != null ? context : new ProvisioningContext();
    }

    @Override
    public ProvisioningContext getProvisioningContext() {
        return context;
    }
}