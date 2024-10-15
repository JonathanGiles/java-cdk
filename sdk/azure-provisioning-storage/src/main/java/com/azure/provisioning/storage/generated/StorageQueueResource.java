// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated;

import com.azure.provisioning.BicepDictionary;
import java.util.Map;
import java.lang.String;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.Resource;
import com.azure.provisioning.tmp.ResourceType;

public class StorageQueueResource extends Resource {

    private final BicepValue<String> resourceGroupName;
    private final BicepValue<String> queueName;
    private final BicepValue<Integer> approximateMessageCount;
    private final BicepValue<String> id;
    private final BicepValue<String> type;
    private final BicepDictionary<String> metadata;
    private final BicepValue<String> name;
    private final BicepValue<String> accountName;

    public StorageQueueResource(String identifierName) {
        this(identifierName, null);
    }

    public StorageQueueResource(String identifierName, String resourceVersion) {
        super(identifierName, new ResourceType("Microsoft.Storage/storageAccounts/queueServices/queues"), resourceVersion);
        resourceGroupName = BicepValue.defineProperty(this, "resourceGroupName", new String[] { "temp", "resourceGroupName" }, false, false, false, null);
        queueName = BicepValue.defineProperty(this, "queueName", new String[] { "temp", "queueName" }, false, false, false, null);
        approximateMessageCount = BicepValue.defineProperty(this, "approximateMessageCount", new String[] { "temp", "approximateMessageCount" }, false, false, false, null);
        id = BicepValue.defineProperty(this, "id", new String[] { "temp", "id" }, false, false, false, null);
        type = BicepValue.defineProperty(this, "type", new String[] { "temp", "type" }, false, false, false, null);
        metadata = BicepDictionary.defineProperty(this, "metadata", new String[] { "temp", "metadata" }, false, false);
        name = BicepValue.defineProperty(this, "name", new String[] { "temp", "name" }, false, false, false, null);
        accountName = BicepValue.defineProperty(this, "accountName", new String[] { "temp", "accountName" }, false, false, false, null);
    }

    public BicepValue<String> getResourceGroupName() {
        return this.resourceGroupName;
    }

    public StorageQueueResource setResourceGroupName(BicepValue<String> resourceGroupName) {
        this.resourceGroupName.assign(resourceGroupName);
        return this;
    }

    public StorageQueueResource setResourceGroupName(String resourceGroupName) {
        return this.setResourceGroupName(BicepValue.from(resourceGroupName));
    }

    public BicepValue<String> getQueueName() {
        return this.queueName;
    }

    public StorageQueueResource setQueueName(BicepValue<String> queueName) {
        this.queueName.assign(queueName);
        return this;
    }

    public StorageQueueResource setQueueName(String queueName) {
        return this.setQueueName(BicepValue.from(queueName));
    }

    public BicepValue<Integer> getApproximateMessageCount() {
        return this.approximateMessageCount;
    }

    public StorageQueueResource setApproximateMessageCount(BicepValue<Integer> approximateMessageCount) {
        this.approximateMessageCount.assign(approximateMessageCount);
        return this;
    }

    public StorageQueueResource setApproximateMessageCount(Integer approximateMessageCount) {
        return this.setApproximateMessageCount(BicepValue.from(approximateMessageCount));
    }

    public BicepValue<String> getId() {
        return this.id;
    }

    public StorageQueueResource setId(BicepValue<String> id) {
        this.id.assign(id);
        return this;
    }

    public StorageQueueResource setId(String id) {
        return this.setId(BicepValue.from(id));
    }

    public BicepValue<String> getType() {
        return this.type;
    }

    public StorageQueueResource setType(BicepValue<String> type) {
        this.type.assign(type);
        return this;
    }

    public StorageQueueResource setType(String type) {
        return this.setType(BicepValue.from(type));
    }

    public BicepDictionary<String> getMetadata() {
        return this.metadata;
    }

    public StorageQueueResource setMetadata(BicepValue<Map<String,String>> metadata) {
        this.metadata.assign(metadata);
        return this;
    }

    public StorageQueueResource setMetadata(Map<String,String> metadata) {
        return this.setMetadata(BicepValue.from(metadata));
    }

    public BicepValue<String> getName() {
        return this.name;
    }

    public StorageQueueResource setName(BicepValue<String> name) {
        this.name.assign(name);
        return this;
    }

    public StorageQueueResource setName(String name) {
        return this.setName(BicepValue.from(name));
    }

    public BicepValue<String> getAccountName() {
        return this.accountName;
    }

    public StorageQueueResource setAccountName(BicepValue<String> accountName) {
        this.accountName.assign(accountName);
        return this;
    }

    public StorageQueueResource setAccountName(String accountName) {
        return this.setAccountName(BicepValue.from(accountName));
    }

}
