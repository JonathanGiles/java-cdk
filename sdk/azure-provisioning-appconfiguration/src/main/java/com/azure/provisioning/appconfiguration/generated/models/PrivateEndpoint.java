// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.appconfiguration.generated.models;

import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class PrivateEndpoint extends ProvisioningConstruct {

    private final BicepValue<String> id;

    public PrivateEndpoint() {
        id = BicepValue.defineProperty(this, "id", new String[] { "temp", "id" }, null);
    }

    public BicepValue<String> getId() {
        return this.id;
    }

    public PrivateEndpoint setId(BicepValue<String> id) {
        this.id.assign(id);
        return this;
    }
}
