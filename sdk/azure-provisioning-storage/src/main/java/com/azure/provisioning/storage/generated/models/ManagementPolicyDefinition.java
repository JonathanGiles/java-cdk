// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated.models;

import com.azure.provisioning.storage.generated.models.ManagementPolicyFilter;
import com.azure.core.util.logging.ClientLogger;
import com.azure.provisioning.storage.generated.models.ManagementPolicyAction;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class ManagementPolicyDefinition extends ProvisioningConstruct {

    private final BicepValue<ManagementPolicyFilter> filters;
    private final BicepValue<ManagementPolicyAction> actions;
    private final BicepValue<ClientLogger> lOGGER;

    public ManagementPolicyDefinition() {
        filters = BicepValue.defineProperty(this, "filters", new String[] { "temp", "filters" }, null);
        actions = BicepValue.defineProperty(this, "actions", new String[] { "temp", "actions" }, null);
        lOGGER = BicepValue.defineProperty(this, "lOGGER", new String[] { "temp", "lOGGER" }, null);
    }

    public BicepValue<ManagementPolicyFilter> getFilters() {
        return this.filters;
    }

    public ManagementPolicyDefinition setFilters(BicepValue<ManagementPolicyFilter> filters) {
        this.filters.assign(filters);
        return this;
    }
    public BicepValue<ManagementPolicyAction> getActions() {
        return this.actions;
    }

    public ManagementPolicyDefinition setActions(BicepValue<ManagementPolicyAction> actions) {
        this.actions.assign(actions);
        return this;
    }
    public BicepValue<ClientLogger> getLOGGER() {
        return this.lOGGER;
    }

    public ManagementPolicyDefinition setLOGGER(BicepValue<ClientLogger> lOGGER) {
        this.lOGGER.assign(lOGGER);
        return this;
    }
}
