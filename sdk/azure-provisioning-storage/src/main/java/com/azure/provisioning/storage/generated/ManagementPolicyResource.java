// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated;

import java.time.OffsetDateTime;
import com.azure.provisioning.storage.generated.models.ManagementPolicySchema;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.Resource;
import com.azure.provisioning.tmp.ResourceType;

public class ManagementPolicyResource extends Resource {

    private final BicepValue<ManagementPolicySchema> policy;
    private final BicepValue<OffsetDateTime> lastModifiedTime;
    private final BicepValue<String> arg1;
    private final BicepValue<String> name;
    private final BicepValue<String> type;
    private final BicepValue<String> arg0;
    private final BicepValue<String> id;

    public ManagementPolicyResource(String identifierName) {
        this(identifierName, null);
    }

    public ManagementPolicyResource(String identifierName, String resourceVersion) {
        super(identifierName, new ResourceType("Microsoft.Storage/storageAccounts/managementPolicies"), resourceVersion);
        policy = BicepValue.defineProperty(this, "policy", new String[] { "temp", "policy" }, false, false, false, null);
        lastModifiedTime = BicepValue.defineProperty(this, "lastModifiedTime", new String[] { "temp", "lastModifiedTime" }, false, false, false, null);
        arg1 = BicepValue.defineProperty(this, "arg1", new String[] { "temp", "arg1" }, false, false, false, null);
        name = BicepValue.defineProperty(this, "name", new String[] { "temp", "name" }, false, false, false, null);
        type = BicepValue.defineProperty(this, "type", new String[] { "temp", "type" }, false, false, false, null);
        arg0 = BicepValue.defineProperty(this, "arg0", new String[] { "temp", "arg0" }, false, false, false, null);
        id = BicepValue.defineProperty(this, "id", new String[] { "temp", "id" }, false, false, false, null);
    }

    public BicepValue<ManagementPolicySchema> getPolicy() {
        return this.policy;
    }

    public ManagementPolicyResource setPolicy(BicepValue<ManagementPolicySchema> policy) {
        this.policy.assign(policy);
        return this;
    }

    public ManagementPolicyResource setPolicy(ManagementPolicySchema policy) {
        return this.setPolicy(BicepValue.from(policy));
    }

    public BicepValue<OffsetDateTime> getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public ManagementPolicyResource setLastModifiedTime(BicepValue<OffsetDateTime> lastModifiedTime) {
        this.lastModifiedTime.assign(lastModifiedTime);
        return this;
    }

    public ManagementPolicyResource setLastModifiedTime(OffsetDateTime lastModifiedTime) {
        return this.setLastModifiedTime(BicepValue.from(lastModifiedTime));
    }

    public BicepValue<String> getArg1() {
        return this.arg1;
    }

    public ManagementPolicyResource setArg1(BicepValue<String> arg1) {
        this.arg1.assign(arg1);
        return this;
    }

    public ManagementPolicyResource setArg1(String arg1) {
        return this.setArg1(BicepValue.from(arg1));
    }

    public BicepValue<String> getName() {
        return this.name;
    }

    public ManagementPolicyResource setName(BicepValue<String> name) {
        this.name.assign(name);
        return this;
    }

    public ManagementPolicyResource setName(String name) {
        return this.setName(BicepValue.from(name));
    }

    public BicepValue<String> getType() {
        return this.type;
    }

    public ManagementPolicyResource setType(BicepValue<String> type) {
        this.type.assign(type);
        return this;
    }

    public ManagementPolicyResource setType(String type) {
        return this.setType(BicepValue.from(type));
    }

    public BicepValue<String> getArg0() {
        return this.arg0;
    }

    public ManagementPolicyResource setArg0(BicepValue<String> arg0) {
        this.arg0.assign(arg0);
        return this;
    }

    public ManagementPolicyResource setArg0(String arg0) {
        return this.setArg0(BicepValue.from(arg0));
    }

    public BicepValue<String> getId() {
        return this.id;
    }

    public ManagementPolicyResource setId(BicepValue<String> id) {
        this.id.assign(id);
        return this;
    }

    public ManagementPolicyResource setId(String id) {
        return this.setId(BicepValue.from(id));
    }

}
