package com.azure.provisioning.primitives;

import com.azure.provisioning.ProvisioningContext;

public class NoImplicitProvisioningContextProvider extends ProvisioningContextProvider {
    @Override
    public ProvisioningContext getProvisioningContext() {
        throw new UnsupportedOperationException("ProvisioningContext must be explicitly passed to all operations.");
    }
}