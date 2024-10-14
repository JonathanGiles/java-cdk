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

    private final BicepValue<String> arg1;
    private final BicepValue<String> name;
    private final BicepValue<String> arg2;
    private final BicepValue<Integer> approximateMessageCount;
    private final BicepDictionary<String> metadata;
    private final BicepValue<String> type;
    private final BicepValue<String> arg0;
    private final BicepValue<String> id;

    public StorageQueueResource(String identifierName) {
        this(identifierName, null);
    }

    public StorageQueueResource(String identifierName, String resourceVersion) {
        super(identifierName, new ResourceType("Microsoft.Storage/storageAccounts/queueServices/queues"), resourceVersion);
        arg1 = BicepValue.defineProperty(this, "arg1", new String[] { "temp", "arg1" }, false, false, false, null);
        name = BicepValue.defineProperty(this, "name", new String[] { "temp", "name" }, false, false, false, null);
        arg2 = BicepValue.defineProperty(this, "arg2", new String[] { "temp", "arg2" }, false, false, false, null);
        approximateMessageCount = BicepValue.defineProperty(this, "approximateMessageCount", new String[] { "temp", "approximateMessageCount" }, false, false, false, null);
        metadata = BicepDictionary.defineProperty(this, "metadata", new String[] { "temp", "metadata" }, false, false);
        type = BicepValue.defineProperty(this, "type", new String[] { "temp", "type" }, false, false, false, null);
        arg0 = BicepValue.defineProperty(this, "arg0", new String[] { "temp", "arg0" }, false, false, false, null);
        id = BicepValue.defineProperty(this, "id", new String[] { "temp", "id" }, false, false, false, null);
    }

    public BicepValue<String> getArg1() {
        return this.arg1;
    }

    public StorageQueueResource setArg1(BicepValue<String> arg1) {
        this.arg1.assign(arg1);
        return this;
    }

    public StorageQueueResource setArg1(String arg1) {
        return this.setArg1(BicepValue.from(arg1));
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

    public BicepValue<String> getArg2() {
        return this.arg2;
    }

    public StorageQueueResource setArg2(BicepValue<String> arg2) {
        this.arg2.assign(arg2);
        return this;
    }

    public StorageQueueResource setArg2(String arg2) {
        return this.setArg2(BicepValue.from(arg2));
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

    public BicepValue<String> getArg0() {
        return this.arg0;
    }

    public StorageQueueResource setArg0(BicepValue<String> arg0) {
        this.arg0.assign(arg0);
        return this;
    }

    public StorageQueueResource setArg0(String arg0) {
        return this.setArg0(BicepValue.from(arg0));
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

}
