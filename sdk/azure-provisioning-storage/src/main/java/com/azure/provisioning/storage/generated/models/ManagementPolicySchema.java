// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated.models;

import java.util.List;
import com.azure.core.util.logging.ClientLogger;
import com.azure.provisioning.storage.generated.models.ManagementPolicyRule;
import com.azure.provisioning.BicepList;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class ManagementPolicySchema extends ProvisioningConstruct {

    private final BicepList<ManagementPolicyRule> rules;
    private final BicepValue<ClientLogger> lOGGER;

    public ManagementPolicySchema() {
        rules = BicepList.defineProperty(this, "rules", new String[] { "temp", "rules" }, false, false);
        lOGGER = BicepValue.defineProperty(this, "lOGGER", new String[] { "temp", "lOGGER" }, null);
    }

    public BicepValue<List<ManagementPolicyRule>> getRules() {
        return this.rules;
    }

    public ManagementPolicySchema setRules(BicepValue<List<ManagementPolicyRule>> rules) {
        this.rules.assign(rules);
        return this;
    }
    public BicepValue<ClientLogger> getLOGGER() {
        return this.lOGGER;
    }

    public ManagementPolicySchema setLOGGER(BicepValue<ClientLogger> lOGGER) {
        this.lOGGER.assign(lOGGER);
        return this;
    }
}
