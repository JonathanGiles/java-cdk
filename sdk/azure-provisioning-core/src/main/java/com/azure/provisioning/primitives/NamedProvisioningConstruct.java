package com.azure.provisioning.primitives;

import com.azure.provisioning.Infrastructure;
import com.azure.provisioning.ProvisioningContext;

public abstract class NamedProvisioningConstruct extends ProvisioningConstruct {
    private String identifierName;

    /**
     * Gets the Bicep identifier name of the resource. This can be used to refer to the resource in expressions, but is not the Azure name of the resource. This value can contain letters, numbers, and underscores.
     *
     * @return The identifier name.
     */
    public String getIdentifierName() {
        return identifierName;
    }

    /**
     * Sets the Bicep identifier name of the resource. This can be used to refer to the resource in expressions, but is not the Azure name of the resource. This value can contain letters, numbers, and underscores.
     *
     * @param identifierName The identifier name.
     */
    public void setIdentifierName(String identifierName) {
        Infrastructure.validateIdentifierName(identifierName, "identifierName");
        this.identifierName = identifierName;
    }

    /**
     * Creates a named Bicep entity, like a resource or parameter.
     *
     * @param identifierName The Bicep identifier name of the resource. This can be used to refer to the resource in expressions, but is not the Azure name of the resource. This value can contain letters, numbers, and underscores.
     */
    protected NamedProvisioningConstruct(String identifierName) {
        Infrastructure.validateIdentifierName(identifierName, "identifierName");
        this.identifierName = identifierName;
    }
}