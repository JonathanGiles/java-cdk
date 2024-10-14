// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.appconfiguration.generated;

import com.azure.provisioning.appconfiguration.generated.models.ReplicaProvisioningState;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.Resource;
import com.azure.provisioning.tmp.ResourceType;

public class ReplicaResource extends Resource {

    private final BicepValue<String> resourceGroupName;
    private final BicepValue<String> configStoreName;
    private final BicepValue<String> replicaName;
    private final BicepValue<String> location;
    private final BicepValue<String> endpoint;
    private final BicepValue<ReplicaProvisioningState> provisioningState;

    public ReplicaResource(String identifierName) {
        this(identifierName, null);
    }

    public ReplicaResource(String identifierName, String resourceVersion) {
        super(identifierName, new ResourceType("Microsoft.AppConfiguration/configurationStores/replicas"), resourceVersion);
        resourceGroupName = BicepValue.defineProperty(this, "resourceGroupName", new String[] { "temp", "resourceGroupName" }, false, false, false, null);
        configStoreName = BicepValue.defineProperty(this, "configStoreName", new String[] { "temp", "configStoreName" }, false, false, false, null);
        replicaName = BicepValue.defineProperty(this, "replicaName", new String[] { "temp", "replicaName" }, false, false, false, null);
        location = BicepValue.defineProperty(this, "location", new String[] { "temp", "location" }, false, false, false, null);
        endpoint = BicepValue.defineProperty(this, "endpoint", new String[] { "temp", "endpoint" }, false, false, false, null);
        provisioningState = BicepValue.defineProperty(this, "provisioningState", new String[] { "temp", "provisioningState" }, false, false, false, null);
    }

    public BicepValue<String> getResourceGroupName() {
        return this.resourceGroupName;
    }

    public ReplicaResource setResourceGroupName(BicepValue<String> resourceGroupName) {
        this.resourceGroupName.assign(resourceGroupName);
        return this;
    }

    public ReplicaResource setResourceGroupName(String resourceGroupName) {
        return this.setResourceGroupName(BicepValue.from(resourceGroupName));
    }

    public BicepValue<String> getConfigStoreName() {
        return this.configStoreName;
    }

    public ReplicaResource setConfigStoreName(BicepValue<String> configStoreName) {
        this.configStoreName.assign(configStoreName);
        return this;
    }

    public ReplicaResource setConfigStoreName(String configStoreName) {
        return this.setConfigStoreName(BicepValue.from(configStoreName));
    }

    public BicepValue<String> getReplicaName() {
        return this.replicaName;
    }

    public ReplicaResource setReplicaName(BicepValue<String> replicaName) {
        this.replicaName.assign(replicaName);
        return this;
    }

    public ReplicaResource setReplicaName(String replicaName) {
        return this.setReplicaName(BicepValue.from(replicaName));
    }

    public BicepValue<String> getLocation() {
        return this.location;
    }

    public ReplicaResource setLocation(BicepValue<String> location) {
        this.location.assign(location);
        return this;
    }

    public ReplicaResource setLocation(String location) {
        return this.setLocation(BicepValue.from(location));
    }

    public BicepValue<String> getEndpoint() {
        return this.endpoint;
    }

    public ReplicaResource setEndpoint(BicepValue<String> endpoint) {
        this.endpoint.assign(endpoint);
        return this;
    }

    public ReplicaResource setEndpoint(String endpoint) {
        return this.setEndpoint(BicepValue.from(endpoint));
    }

    public BicepValue<ReplicaProvisioningState> getProvisioningState() {
        return this.provisioningState;
    }

    public ReplicaResource setProvisioningState(BicepValue<ReplicaProvisioningState> provisioningState) {
        this.provisioningState.assign(provisioningState);
        return this;
    }

    public ReplicaResource setProvisioningState(ReplicaProvisioningState provisioningState) {
        return this.setProvisioningState(BicepValue.from(provisioningState));
    }


    public static class ResourceVersions {

        public static final String V2024_05_01 = "2024-05-01";

        public static final String V2023_03_01 = "2023-03-01";

    }
}
