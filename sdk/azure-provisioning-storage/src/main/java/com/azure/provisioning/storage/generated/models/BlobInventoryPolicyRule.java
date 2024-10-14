// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated.models;

import com.azure.core.util.logging.ClientLogger;
import com.azure.provisioning.storage.generated.models.BlobInventoryPolicyDefinition;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class BlobInventoryPolicyRule extends ProvisioningConstruct {

    private final BicepValue<boolean> enabled;
    private final BicepValue<String> name;
    private final BicepValue<BlobInventoryPolicyDefinition> definition;
    private final BicepValue<String> destination;
    private final BicepValue<ClientLogger> lOGGER;

    public BlobInventoryPolicyRule() {
        enabled = BicepValue.defineProperty(this, "enabled", new String[] { "temp", "enabled" }, null);
        name = BicepValue.defineProperty(this, "name", new String[] { "temp", "name" }, null);
        definition = BicepValue.defineProperty(this, "definition", new String[] { "temp", "definition" }, null);
        destination = BicepValue.defineProperty(this, "destination", new String[] { "temp", "destination" }, null);
        lOGGER = BicepValue.defineProperty(this, "lOGGER", new String[] { "temp", "lOGGER" }, null);
    }

    public BicepValue<boolean> getEnabled() {
        return this.enabled;
    }

    public BlobInventoryPolicyRule setEnabled(BicepValue<boolean> enabled) {
        this.enabled.assign(enabled);
        return this;
    }
    public BicepValue<String> getName() {
        return this.name;
    }

    public BlobInventoryPolicyRule setName(BicepValue<String> name) {
        this.name.assign(name);
        return this;
    }
    public BicepValue<BlobInventoryPolicyDefinition> getDefinition() {
        return this.definition;
    }

    public BlobInventoryPolicyRule setDefinition(BicepValue<BlobInventoryPolicyDefinition> definition) {
        this.definition.assign(definition);
        return this;
    }
    public BicepValue<String> getDestination() {
        return this.destination;
    }

    public BlobInventoryPolicyRule setDestination(BicepValue<String> destination) {
        this.destination.assign(destination);
        return this;
    }
    public BicepValue<ClientLogger> getLOGGER() {
        return this.lOGGER;
    }

    public BlobInventoryPolicyRule setLOGGER(BicepValue<ClientLogger> lOGGER) {
        this.lOGGER.assign(lOGGER);
        return this;
    }
}
