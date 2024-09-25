package com.azure.provisioning.primitives;

import com.azure.provisioning.ProvisioningContext;

public abstract class NamedProvisioningConstruct extends ProvisioningConstruct {
    private final String resourceName;

    public NamedProvisioningConstruct(String resourceName, ProvisioningContext context) {
        super(context);
        this.resourceName = resourceName;
        DefaultProvisioningContext.getDefaultInfrastructure().add(this);
    }

    public String getResourceName() {
        return resourceName;
    }
}