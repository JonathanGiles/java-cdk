// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated;

import java.time.OffsetDateTime;
import com.azure.provisioning.storage.generated.models.BlobInventoryPolicySchema;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.Resource;
import com.azure.provisioning.tmp.ResourceType;

public class BlobInventoryPolicyResource extends Resource {

    private final BicepValue<String> resourceGroupName;
    private final BicepValue<String> id;
    private final BicepValue<String> type;
    private final BicepValue<String> name;
    private final BicepValue<BlobInventoryPolicySchema> policy;
    private final BicepValue<OffsetDateTime> lastModifiedTime;
    private final BicepValue<String> accountName;

    public BlobInventoryPolicyResource(String identifierName) {
        this(identifierName, null);
    }

    public BlobInventoryPolicyResource(String identifierName, String resourceVersion) {
        super(identifierName, new ResourceType("Microsoft.Storage/storageAccounts/inventoryPolicies"), resourceVersion);
        resourceGroupName = BicepValue.defineProperty(this, "resourceGroupName", new String[] { "temp", "resourceGroupName" }, false, false, false, null);
        id = BicepValue.defineProperty(this, "id", new String[] { "temp", "id" }, false, false, false, null);
        type = BicepValue.defineProperty(this, "type", new String[] { "temp", "type" }, false, false, false, null);
        name = BicepValue.defineProperty(this, "name", new String[] { "temp", "name" }, false, false, false, null);
        policy = BicepValue.defineProperty(this, "policy", new String[] { "temp", "policy" }, false, false, false, null);
        lastModifiedTime = BicepValue.defineProperty(this, "lastModifiedTime", new String[] { "temp", "lastModifiedTime" }, false, false, false, null);
        accountName = BicepValue.defineProperty(this, "accountName", new String[] { "temp", "accountName" }, false, false, false, null);
    }

    public BicepValue<String> getResourceGroupName() {
        return this.resourceGroupName;
    }

    public BlobInventoryPolicyResource setResourceGroupName(BicepValue<String> resourceGroupName) {
        this.resourceGroupName.assign(resourceGroupName);
        return this;
    }

    public BlobInventoryPolicyResource setResourceGroupName(String resourceGroupName) {
        return this.setResourceGroupName(BicepValue.from(resourceGroupName));
    }

    public BicepValue<String> getId() {
        return this.id;
    }

    public BlobInventoryPolicyResource setId(BicepValue<String> id) {
        this.id.assign(id);
        return this;
    }

    public BlobInventoryPolicyResource setId(String id) {
        return this.setId(BicepValue.from(id));
    }

    public BicepValue<String> getType() {
        return this.type;
    }

    public BlobInventoryPolicyResource setType(BicepValue<String> type) {
        this.type.assign(type);
        return this;
    }

    public BlobInventoryPolicyResource setType(String type) {
        return this.setType(BicepValue.from(type));
    }

    public BicepValue<String> getName() {
        return this.name;
    }

    public BlobInventoryPolicyResource setName(BicepValue<String> name) {
        this.name.assign(name);
        return this;
    }

    public BlobInventoryPolicyResource setName(String name) {
        return this.setName(BicepValue.from(name));
    }

    public BicepValue<BlobInventoryPolicySchema> getPolicy() {
        return this.policy;
    }

    public BlobInventoryPolicyResource setPolicy(BicepValue<BlobInventoryPolicySchema> policy) {
        this.policy.assign(policy);
        return this;
    }

    public BlobInventoryPolicyResource setPolicy(BlobInventoryPolicySchema policy) {
        return this.setPolicy(BicepValue.from(policy));
    }

    public BicepValue<OffsetDateTime> getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public BlobInventoryPolicyResource setLastModifiedTime(BicepValue<OffsetDateTime> lastModifiedTime) {
        this.lastModifiedTime.assign(lastModifiedTime);
        return this;
    }

    public BlobInventoryPolicyResource setLastModifiedTime(OffsetDateTime lastModifiedTime) {
        return this.setLastModifiedTime(BicepValue.from(lastModifiedTime));
    }

    public BicepValue<String> getAccountName() {
        return this.accountName;
    }

    public BlobInventoryPolicyResource setAccountName(BicepValue<String> accountName) {
        this.accountName.assign(accountName);
        return this;
    }

    public BlobInventoryPolicyResource setAccountName(String accountName) {
        return this.setAccountName(BicepValue.from(accountName));
    }

}
