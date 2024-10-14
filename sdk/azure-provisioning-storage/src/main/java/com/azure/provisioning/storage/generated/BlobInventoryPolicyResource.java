// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated;

import java.time.OffsetDateTime;
import com.azure.provisioning.storage.generated.models.BlobInventoryPolicySchema;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.Resource;
import com.azure.provisioning.tmp.ResourceType;

public class BlobInventoryPolicyResource extends Resource {

    private final BicepValue<String> id;
    private final BicepValue<String> type;
    private final BicepValue<String> arg0;
    private final BicepValue<String> arg1;
    private final BicepValue<String> name;
    private final BicepValue<BlobInventoryPolicySchema> policy;
    private final BicepValue<OffsetDateTime> lastModifiedTime;

    public BlobInventoryPolicyResource(String identifierName) {
        this(identifierName, null);
    }

    public BlobInventoryPolicyResource(String identifierName, String resourceVersion) {
        super(identifierName, new ResourceType("Microsoft.Storage/storageAccounts/inventoryPolicies"), resourceVersion);
        id = BicepValue.defineProperty(this, "id", new String[] { "temp", "id" }, false, false, false, null);
        type = BicepValue.defineProperty(this, "type", new String[] { "temp", "type" }, false, false, false, null);
        arg0 = BicepValue.defineProperty(this, "arg0", new String[] { "temp", "arg0" }, false, false, false, null);
        arg1 = BicepValue.defineProperty(this, "arg1", new String[] { "temp", "arg1" }, false, false, false, null);
        name = BicepValue.defineProperty(this, "name", new String[] { "temp", "name" }, false, false, false, null);
        policy = BicepValue.defineProperty(this, "policy", new String[] { "temp", "policy" }, false, false, false, null);
        lastModifiedTime = BicepValue.defineProperty(this, "lastModifiedTime", new String[] { "temp", "lastModifiedTime" }, false, false, false, null);
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

    public BicepValue<String> getArg0() {
        return this.arg0;
    }

    public BlobInventoryPolicyResource setArg0(BicepValue<String> arg0) {
        this.arg0.assign(arg0);
        return this;
    }

    public BlobInventoryPolicyResource setArg0(String arg0) {
        return this.setArg0(BicepValue.from(arg0));
    }

    public BicepValue<String> getArg1() {
        return this.arg1;
    }

    public BlobInventoryPolicyResource setArg1(BicepValue<String> arg1) {
        this.arg1.assign(arg1);
        return this;
    }

    public BlobInventoryPolicyResource setArg1(String arg1) {
        return this.setArg1(BicepValue.from(arg1));
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

}
