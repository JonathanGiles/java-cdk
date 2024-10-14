// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated.models;

import com.azure.provisioning.storage.generated.models.ObjectReplicationPolicyFilter;
import com.azure.core.util.logging.ClientLogger;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class ObjectReplicationPolicyRule extends ProvisioningConstruct {

    private final BicepValue<String> destinationContainer;
    private final BicepValue<ClientLogger> lOGGER;
    private final BicepValue<ObjectReplicationPolicyFilter> filters;
    private final BicepValue<String> sourceContainer;
    private final BicepValue<String> ruleId;

    public ObjectReplicationPolicyRule() {
        destinationContainer = BicepValue.defineProperty(this, "destinationContainer", new String[] { "temp", "destinationContainer" }, null);
        lOGGER = BicepValue.defineProperty(this, "lOGGER", new String[] { "temp", "lOGGER" }, null);
        filters = BicepValue.defineProperty(this, "filters", new String[] { "temp", "filters" }, null);
        sourceContainer = BicepValue.defineProperty(this, "sourceContainer", new String[] { "temp", "sourceContainer" }, null);
        ruleId = BicepValue.defineProperty(this, "ruleId", new String[] { "temp", "ruleId" }, null);
    }

    public BicepValue<String> getDestinationContainer() {
        return this.destinationContainer;
    }

    public ObjectReplicationPolicyRule setDestinationContainer(BicepValue<String> destinationContainer) {
        this.destinationContainer.assign(destinationContainer);
        return this;
    }
    public BicepValue<ClientLogger> getLOGGER() {
        return this.lOGGER;
    }

    public ObjectReplicationPolicyRule setLOGGER(BicepValue<ClientLogger> lOGGER) {
        this.lOGGER.assign(lOGGER);
        return this;
    }
    public BicepValue<ObjectReplicationPolicyFilter> getFilters() {
        return this.filters;
    }

    public ObjectReplicationPolicyRule setFilters(BicepValue<ObjectReplicationPolicyFilter> filters) {
        this.filters.assign(filters);
        return this;
    }
    public BicepValue<String> getSourceContainer() {
        return this.sourceContainer;
    }

    public ObjectReplicationPolicyRule setSourceContainer(BicepValue<String> sourceContainer) {
        this.sourceContainer.assign(sourceContainer);
        return this;
    }
    public BicepValue<String> getRuleId() {
        return this.ruleId;
    }

    public ObjectReplicationPolicyRule setRuleId(BicepValue<String> ruleId) {
        this.ruleId.assign(ruleId);
        return this;
    }
}
