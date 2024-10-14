// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated.models;

import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class SshPublicKey extends ProvisioningConstruct {

    private final BicepValue<String> key;
    private final BicepValue<String> description;

    public SshPublicKey() {
        key = BicepValue.defineProperty(this, "key", new String[] { "temp", "key" }, null);
        description = BicepValue.defineProperty(this, "description", new String[] { "temp", "description" }, null);
    }

    public BicepValue<String> getKey() {
        return this.key;
    }

    public SshPublicKey setKey(BicepValue<String> key) {
        this.key.assign(key);
        return this;
    }
    public BicepValue<String> getDescription() {
        return this.description;
    }

    public SshPublicKey setDescription(BicepValue<String> description) {
        this.description.assign(description);
        return this;
    }
}
