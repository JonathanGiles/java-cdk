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

    private final BicepValue<ClientLogger> lOGGER;
    private final BicepList<ManagementPolicyRule> rules;

    public ManagementPolicySchema() {
        lOGGER = BicepValue.defineProperty(this, "lOGGER", new String[] { "temp", "lOGGER" }, null);
        rules = BicepList.defineProperty(this, "rules", new String[] { "temp", "rules" }, false, false);
    }

    public BicepValue<ClientLogger> getLOGGER() {
        return this.lOGGER;
    }

    public ManagementPolicySchema setLOGGER(BicepValue<ClientLogger> lOGGER) {
        this.lOGGER.assign(lOGGER);
        return this;
    }
    public BicepValue<List<ManagementPolicyRule>> getRules() {
        return this.rules;
    }

    public ManagementPolicySchema setRules(BicepValue<List<ManagementPolicyRule>> rules) {
        this.rules.assign(rules);
        return this;
    }
}
