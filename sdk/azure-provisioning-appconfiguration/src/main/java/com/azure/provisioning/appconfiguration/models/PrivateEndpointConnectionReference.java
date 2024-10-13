// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.appconfiguration.models;

import com.azure.provisioning.appconfiguration.models.PrivateLinkServiceConnectionState;
import com.azure.provisioning.appconfiguration.models.ProvisioningState;
import com.azure.provisioning.appconfiguration.models.PrivateEndpoint;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class PrivateEndpointConnectionReference extends ProvisioningConstruct {

    private final BicepValue<String> id;
    private final BicepValue<String> name;
    private final BicepValue<String> type;
    private final BicepValue<ProvisioningState> provisioningState;
    private final BicepValue<PrivateEndpoint> privateEndpoint;
    private final BicepValue<PrivateLinkServiceConnectionState> privateLinkServiceConnectionState;

    public PrivateEndpointConnectionReference() {
        id = BicepValue.defineProperty(this, "id", new String[] { "temp", "id" }, null);
        name = BicepValue.defineProperty(this, "name", new String[] { "temp", "name" }, null);
        type = BicepValue.defineProperty(this, "type", new String[] { "temp", "type" }, null);
        provisioningState = BicepValue.defineProperty(this, "provisioningState", new String[] { "temp", "provisioningState" }, null);
        privateEndpoint = BicepValue.defineProperty(this, "privateEndpoint", new String[] { "temp", "privateEndpoint" }, null);
        privateLinkServiceConnectionState = BicepValue.defineProperty(this, "privateLinkServiceConnectionState", new String[] { "temp", "privateLinkServiceConnectionState" }, null);
    }

    public BicepValue<String> getId() {
        return this.id;
    }

    public PrivateEndpointConnectionReference setId(BicepValue<String> id) {
        this.id.assign(id);
        return this;
    }
    public BicepValue<String> getName() {
        return this.name;
    }

    public PrivateEndpointConnectionReference setName(BicepValue<String> name) {
        this.name.assign(name);
        return this;
    }
    public BicepValue<String> getType() {
        return this.type;
    }

    public PrivateEndpointConnectionReference setType(BicepValue<String> type) {
        this.type.assign(type);
        return this;
    }
    public BicepValue<ProvisioningState> getProvisioningState() {
        return this.provisioningState;
    }

    public PrivateEndpointConnectionReference setProvisioningState(BicepValue<ProvisioningState> provisioningState) {
        this.provisioningState.assign(provisioningState);
        return this;
    }
    public BicepValue<PrivateEndpoint> getPrivateEndpoint() {
        return this.privateEndpoint;
    }

    public PrivateEndpointConnectionReference setPrivateEndpoint(BicepValue<PrivateEndpoint> privateEndpoint) {
        this.privateEndpoint.assign(privateEndpoint);
        return this;
    }
    public BicepValue<PrivateLinkServiceConnectionState> getPrivateLinkServiceConnectionState() {
        return this.privateLinkServiceConnectionState;
    }

    public PrivateEndpointConnectionReference setPrivateLinkServiceConnectionState(BicepValue<PrivateLinkServiceConnectionState> privateLinkServiceConnectionState) {
        this.privateLinkServiceConnectionState.assign(privateLinkServiceConnectionState);
        return this;
    }
}
