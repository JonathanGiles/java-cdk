// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.appconfiguration;

import com.azure.provisioning.appconfiguration.models.PrivateLinkServiceConnectionState;
import com.azure.provisioning.appconfiguration.models.ProvisioningState;
import com.azure.provisioning.appconfiguration.models.PrivateEndpoint;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.BicepList;
import com.azure.provisioning.BicepDictionary;
import com.azure.provisioning.primitives.Resource;
import com.azure.provisioning.tmp.ResourceType;

public class PrivateEndpointConnectionResource extends Resource {

    private final BicepValue<String> resourceGroupName;
    private final BicepValue<String> configStoreName;
    private final BicepValue<String> privateEndpointConnectionName;
    private final BicepValue<ProvisioningState> provisioningState;
    private final BicepValue<PrivateEndpoint> privateEndpoint;
    private final BicepValue<PrivateLinkServiceConnectionState> privateLinkServiceConnectionState;

    public PrivateEndpointConnectionResource(String identifierName) {
        this(identifierName, null);
    }

    public PrivateEndpointConnectionResource(String identifierName, String resourceVersion) {
        super(identifierName, new ResourceType("Microsoft.AppConfiguration/configurationStores/privateEndpointConnections"), resourceVersion);
        resourceGroupName = BicepValue.defineProperty(this, "resourceGroupName", new String[] {  }, false, true, false, null);;
        configStoreName = BicepValue.defineProperty(this, "configStoreName", new String[] {  }, false, true, false, null);;
        privateEndpointConnectionName = BicepValue.defineProperty(this, "privateEndpointConnectionName", new String[] {  }, false, true, false, null);;
        provisioningState = BicepValue.defineProperty(this, "provisioningState", new String[] {  }, false, false, false, null);;
        privateEndpoint = BicepValue.defineProperty(this, "privateEndpoint", new String[] {  }, false, false, false, null);;
        privateLinkServiceConnectionState = BicepValue.defineProperty(this, "privateLinkServiceConnectionState", new String[] {  }, false, false, false, null);;
    }

    public BicepValue<String> getResourceGroupName() {
        return this.resourceGroupName;
    }

    public PrivateEndpointConnectionResource setResourceGroupName(BicepValue<String> resourceGroupName) {
        this.resourceGroupName.assign(resourceGroupName);
        return this;
    }
    public BicepValue<String> getConfigStoreName() {
        return this.configStoreName;
    }

    public PrivateEndpointConnectionResource setConfigStoreName(BicepValue<String> configStoreName) {
        this.configStoreName.assign(configStoreName);
        return this;
    }
    public BicepValue<String> getPrivateEndpointConnectionName() {
        return this.privateEndpointConnectionName;
    }

    public PrivateEndpointConnectionResource setPrivateEndpointConnectionName(BicepValue<String> privateEndpointConnectionName) {
        this.privateEndpointConnectionName.assign(privateEndpointConnectionName);
        return this;
    }
    public BicepValue<ProvisioningState> getProvisioningState() {
        return this.provisioningState;
    }

    public PrivateEndpointConnectionResource setProvisioningState(BicepValue<ProvisioningState> provisioningState) {
        this.provisioningState.assign(provisioningState);
        return this;
    }
    public BicepValue<PrivateEndpoint> getPrivateEndpoint() {
        return this.privateEndpoint;
    }

    public PrivateEndpointConnectionResource setPrivateEndpoint(BicepValue<PrivateEndpoint> privateEndpoint) {
        this.privateEndpoint.assign(privateEndpoint);
        return this;
    }
    public BicepValue<PrivateLinkServiceConnectionState> getPrivateLinkServiceConnectionState() {
        return this.privateLinkServiceConnectionState;
    }

    public PrivateEndpointConnectionResource setPrivateLinkServiceConnectionState(BicepValue<PrivateLinkServiceConnectionState> privateLinkServiceConnectionState) {
        this.privateLinkServiceConnectionState.assign(privateLinkServiceConnectionState);
        return this;
    }
}
