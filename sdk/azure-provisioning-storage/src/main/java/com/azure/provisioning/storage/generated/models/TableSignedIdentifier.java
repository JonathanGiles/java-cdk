// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated.models;

import com.azure.provisioning.storage.generated.models.TableAccessPolicy;
import com.azure.core.util.logging.ClientLogger;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class TableSignedIdentifier extends ProvisioningConstruct {

    private final BicepValue<ClientLogger> lOGGER;
    private final BicepValue<String> id;
    private final BicepValue<TableAccessPolicy> accessPolicy;

    public TableSignedIdentifier() {
        lOGGER = BicepValue.defineProperty(this, "lOGGER", new String[] { "temp", "lOGGER" }, null);
        id = BicepValue.defineProperty(this, "id", new String[] { "temp", "id" }, null);
        accessPolicy = BicepValue.defineProperty(this, "accessPolicy", new String[] { "temp", "accessPolicy" }, null);
    }

    public BicepValue<ClientLogger> getLOGGER() {
        return this.lOGGER;
    }

    public TableSignedIdentifier setLOGGER(BicepValue<ClientLogger> lOGGER) {
        this.lOGGER.assign(lOGGER);
        return this;
    }
    public BicepValue<String> getId() {
        return this.id;
    }

    public TableSignedIdentifier setId(BicepValue<String> id) {
        this.id.assign(id);
        return this;
    }
    public BicepValue<TableAccessPolicy> getAccessPolicy() {
        return this.accessPolicy;
    }

    public TableSignedIdentifier setAccessPolicy(BicepValue<TableAccessPolicy> accessPolicy) {
        this.accessPolicy.assign(accessPolicy);
        return this;
    }
}
