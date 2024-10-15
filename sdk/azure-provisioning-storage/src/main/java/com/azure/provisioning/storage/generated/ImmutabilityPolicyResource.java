// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated;

import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.Resource;
import com.azure.provisioning.tmp.ResourceType;

public class ImmutabilityPolicyResource extends Resource {

    private final BicepValue<String> resourceGroupName;
    private final BicepValue<String> containerName;
    private final BicepValue<String> accountName;

    public ImmutabilityPolicyResource(String identifierName) {
        this(identifierName, null);
    }

    public ImmutabilityPolicyResource(String identifierName, String resourceVersion) {
        super(identifierName, new ResourceType("Microsoft.Storage/storageAccounts/blobServices/containers/immutabilityPolicies"), resourceVersion);
        resourceGroupName = BicepValue.defineProperty(this, "resourceGroupName", new String[] { "temp", "resourceGroupName" }, false, false, false, null);
        containerName = BicepValue.defineProperty(this, "containerName", new String[] { "temp", "containerName" }, false, false, false, null);
        accountName = BicepValue.defineProperty(this, "accountName", new String[] { "temp", "accountName" }, false, false, false, null);
    }

    public BicepValue<String> getResourceGroupName() {
        return this.resourceGroupName;
    }

    public ImmutabilityPolicyResource setResourceGroupName(BicepValue<String> resourceGroupName) {
        this.resourceGroupName.assign(resourceGroupName);
        return this;
    }

    public ImmutabilityPolicyResource setResourceGroupName(String resourceGroupName) {
        return this.setResourceGroupName(BicepValue.from(resourceGroupName));
    }

    public BicepValue<String> getContainerName() {
        return this.containerName;
    }

    public ImmutabilityPolicyResource setContainerName(BicepValue<String> containerName) {
        this.containerName.assign(containerName);
        return this;
    }

    public ImmutabilityPolicyResource setContainerName(String containerName) {
        return this.setContainerName(BicepValue.from(containerName));
    }

    public BicepValue<String> getAccountName() {
        return this.accountName;
    }

    public ImmutabilityPolicyResource setAccountName(BicepValue<String> accountName) {
        this.accountName.assign(accountName);
        return this;
    }

    public ImmutabilityPolicyResource setAccountName(String accountName) {
        return this.setAccountName(BicepValue.from(accountName));
    }

}
