// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.appconfiguration.models;

import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class EncryptionProperties extends ProvisioningConstruct {

    private final BicepValue<String> keyIdentifier;
    private final BicepValue<String> identityClientId;

    public EncryptionProperties() {
        keyIdentifier = BicepValue.defineProperty(this, "keyIdentifier", new String[] { "temp", "keyIdentifier" }, null);
        identityClientId = BicepValue.defineProperty(this, "identityClientId", new String[] { "temp", "identityClientId" }, null);
    }

    public BicepValue<String> getKeyIdentifier() {
        return this.keyIdentifier;
    }

    public EncryptionProperties setKeyIdentifier(BicepValue<String> keyIdentifier) {
        this.keyIdentifier.assign(keyIdentifier);
        return this;
    }
    public BicepValue<String> getIdentityClientId() {
        return this.identityClientId;
    }

    public EncryptionProperties setIdentityClientId(BicepValue<String> identityClientId) {
        this.identityClientId.assign(identityClientId);
        return this;
    }
}
