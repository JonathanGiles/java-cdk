// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated.models;

import com.azure.provisioning.storage.generated.models.BlobInventoryPolicyRule;
import java.util.List;
import com.azure.provisioning.storage.generated.models.InventoryRuleType;
import com.azure.core.util.logging.ClientLogger;
import com.azure.provisioning.BicepList;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class BlobInventoryPolicySchema extends ProvisioningConstruct {

    private final BicepValue<boolean> enabled;
    private final BicepList<BlobInventoryPolicyRule> rules;
    private final BicepValue<InventoryRuleType> type;
    private final BicepValue<String> destination;
    private final BicepValue<ClientLogger> lOGGER;

    public BlobInventoryPolicySchema() {
        enabled = BicepValue.defineProperty(this, "enabled", new String[] { "temp", "enabled" }, null);
        rules = BicepList.defineProperty(this, "rules", new String[] { "temp", "rules" }, false, false);
        type = BicepValue.defineProperty(this, "type", new String[] { "temp", "type" }, null);
        destination = BicepValue.defineProperty(this, "destination", new String[] { "temp", "destination" }, null);
        lOGGER = BicepValue.defineProperty(this, "lOGGER", new String[] { "temp", "lOGGER" }, null);
    }

    public BicepValue<boolean> getEnabled() {
        return this.enabled;
    }

    public BlobInventoryPolicySchema setEnabled(BicepValue<boolean> enabled) {
        this.enabled.assign(enabled);
        return this;
    }
    public BicepValue<List<BlobInventoryPolicyRule>> getRules() {
        return this.rules;
    }

    public BlobInventoryPolicySchema setRules(BicepValue<List<BlobInventoryPolicyRule>> rules) {
        this.rules.assign(rules);
        return this;
    }
    public BicepValue<InventoryRuleType> getType() {
        return this.type;
    }

    public BlobInventoryPolicySchema setType(BicepValue<InventoryRuleType> type) {
        this.type.assign(type);
        return this;
    }
    public BicepValue<String> getDestination() {
        return this.destination;
    }

    public BlobInventoryPolicySchema setDestination(BicepValue<String> destination) {
        this.destination.assign(destination);
        return this;
    }
    public BicepValue<ClientLogger> getLOGGER() {
        return this.lOGGER;
    }

    public BlobInventoryPolicySchema setLOGGER(BicepValue<ClientLogger> lOGGER) {
        this.lOGGER.assign(lOGGER);
        return this;
    }
}
