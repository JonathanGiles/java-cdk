// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.appconfiguration.models;

import com.azure.provisioning.appconfiguration.models.ActionsRequired;
import com.azure.provisioning.appconfiguration.models.ConnectionStatus;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class PrivateLinkServiceConnectionState extends ProvisioningConstruct {

    private final BicepValue<ConnectionStatus> status;
    private final BicepValue<String> description;
    private final BicepValue<ActionsRequired> actionsRequired;

    public PrivateLinkServiceConnectionState() {
        status = BicepValue.defineProperty(this, "status", new String[] { "temp", "status" }, null);
        description = BicepValue.defineProperty(this, "description", new String[] { "temp", "description" }, null);
        actionsRequired = BicepValue.defineProperty(this, "actionsRequired", new String[] { "temp", "actionsRequired" }, null);
    }

    public BicepValue<ConnectionStatus> getStatus() {
        return this.status;
    }

    public PrivateLinkServiceConnectionState setStatus(BicepValue<ConnectionStatus> status) {
        this.status.assign(status);
        return this;
    }
    public BicepValue<String> getDescription() {
        return this.description;
    }

    public PrivateLinkServiceConnectionState setDescription(BicepValue<String> description) {
        this.description.assign(description);
        return this;
    }
    public BicepValue<ActionsRequired> getActionsRequired() {
        return this.actionsRequired;
    }

    public PrivateLinkServiceConnectionState setActionsRequired(BicepValue<ActionsRequired> actionsRequired) {
        this.actionsRequired.assign(actionsRequired);
        return this;
    }
}
