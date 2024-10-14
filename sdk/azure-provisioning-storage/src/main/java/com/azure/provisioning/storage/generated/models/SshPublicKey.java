// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated.models;

import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class SshPublicKey extends ProvisioningConstruct {

    private final BicepValue<String> description;
    private final BicepValue<String> key;

    public SshPublicKey() {
        description = BicepValue.defineProperty(this, "description", new String[] { "temp", "description" }, null);
        key = BicepValue.defineProperty(this, "key", new String[] { "temp", "key" }, null);
    }

    public BicepValue<String> getDescription() {
        return this.description;
    }

    public SshPublicKey setDescription(BicepValue<String> description) {
        this.description.assign(description);
        return this;
    }
    public BicepValue<String> getKey() {
        return this.key;
    }

    public SshPublicKey setKey(BicepValue<String> key) {
        this.key.assign(key);
        return this;
    }
}
