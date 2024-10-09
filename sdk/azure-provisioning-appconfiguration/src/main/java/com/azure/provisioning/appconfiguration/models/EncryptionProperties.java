// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.appconfiguration.models;

import com.azure.provisioning.appconfiguration.models.KeyVaultProperties;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class EncryptionProperties extends ProvisioningConstruct {

    private final BicepValue<KeyVaultProperties> keyVaultProperties;

    public EncryptionProperties() {
        keyVaultProperties = BicepValue.defineProperty(this, "keyVaultProperties", new String[] { "temp", "keyVaultProperties" }, null);
    }

    public BicepValue<KeyVaultProperties> getKeyVaultProperties() {
        return this.keyVaultProperties;
    }

    public EncryptionProperties setKeyVaultProperties(BicepValue<KeyVaultProperties> keyVaultProperties) {
        this.keyVaultProperties.assign(keyVaultProperties);
        return this;
    }
}
