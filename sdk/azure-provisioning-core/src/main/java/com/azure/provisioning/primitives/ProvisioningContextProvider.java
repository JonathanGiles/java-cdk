package com.azure.provisioning.primitives;

import com.azure.provisioning.ProvisioningContext;

public abstract class ProvisioningContextProvider {
    /**
     * Get the ProvisioningContext instance to use for composing,
     * building, and deploying resources.
     *
     * @return The ProvisioningContext instance to use for composing,
     * building, and deploying resources.
     */
    public abstract ProvisioningContext getProvisioningContext();
}