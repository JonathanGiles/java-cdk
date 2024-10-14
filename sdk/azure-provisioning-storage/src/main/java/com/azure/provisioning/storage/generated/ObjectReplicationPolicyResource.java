// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated;

import java.util.List;
import com.azure.provisioning.storage.generated.models.ObjectReplicationPolicyRule;
import java.time.OffsetDateTime;
import com.azure.provisioning.BicepList;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.Resource;
import com.azure.provisioning.tmp.ResourceType;

public class ObjectReplicationPolicyResource extends Resource {

    private final BicepList<ObjectReplicationPolicyRule> rules;
    private final BicepValue<String> arg1;
    private final BicepValue<String> name;
    private final BicepValue<String> arg2;
    private final BicepValue<OffsetDateTime> enabledTime;
    private final BicepValue<String> policyId;
    private final BicepValue<String> type;
    private final BicepValue<String> arg0;
    private final BicepValue<String> destinationAccount;
    private final BicepValue<String> id;
    private final BicepValue<String> sourceAccount;

    public ObjectReplicationPolicyResource(String identifierName) {
        this(identifierName, null);
    }

    public ObjectReplicationPolicyResource(String identifierName, String resourceVersion) {
        super(identifierName, new ResourceType("Microsoft.Storage/storageAccounts/objectReplicationPolicies"), resourceVersion);
        rules = BicepList.defineProperty(this, "rules", new String[] { "temp", "rules" }, false, false);
        arg1 = BicepValue.defineProperty(this, "arg1", new String[] { "temp", "arg1" }, false, false, false, null);
        name = BicepValue.defineProperty(this, "name", new String[] { "temp", "name" }, false, false, false, null);
        arg2 = BicepValue.defineProperty(this, "arg2", new String[] { "temp", "arg2" }, false, false, false, null);
        enabledTime = BicepValue.defineProperty(this, "enabledTime", new String[] { "temp", "enabledTime" }, false, false, false, null);
        policyId = BicepValue.defineProperty(this, "policyId", new String[] { "temp", "policyId" }, false, false, false, null);
        type = BicepValue.defineProperty(this, "type", new String[] { "temp", "type" }, false, false, false, null);
        arg0 = BicepValue.defineProperty(this, "arg0", new String[] { "temp", "arg0" }, false, false, false, null);
        destinationAccount = BicepValue.defineProperty(this, "destinationAccount", new String[] { "temp", "destinationAccount" }, false, false, false, null);
        id = BicepValue.defineProperty(this, "id", new String[] { "temp", "id" }, false, false, false, null);
        sourceAccount = BicepValue.defineProperty(this, "sourceAccount", new String[] { "temp", "sourceAccount" }, false, false, false, null);
    }

    public BicepList<ObjectReplicationPolicyRule> getRules() {
        return this.rules;
    }

    public ObjectReplicationPolicyResource setRules(BicepValue<List<ObjectReplicationPolicyRule>> rules) {
        this.rules.assign(rules);
        return this;
    }

    public ObjectReplicationPolicyResource setRules(List<ObjectReplicationPolicyRule> rules) {
        return this.setRules(BicepValue.from(rules));
    }

    public BicepValue<String> getArg1() {
        return this.arg1;
    }

    public ObjectReplicationPolicyResource setArg1(BicepValue<String> arg1) {
        this.arg1.assign(arg1);
        return this;
    }

    public ObjectReplicationPolicyResource setArg1(String arg1) {
        return this.setArg1(BicepValue.from(arg1));
    }

    public BicepValue<String> getName() {
        return this.name;
    }

    public ObjectReplicationPolicyResource setName(BicepValue<String> name) {
        this.name.assign(name);
        return this;
    }

    public ObjectReplicationPolicyResource setName(String name) {
        return this.setName(BicepValue.from(name));
    }

    public BicepValue<String> getArg2() {
        return this.arg2;
    }

    public ObjectReplicationPolicyResource setArg2(BicepValue<String> arg2) {
        this.arg2.assign(arg2);
        return this;
    }

    public ObjectReplicationPolicyResource setArg2(String arg2) {
        return this.setArg2(BicepValue.from(arg2));
    }

    public BicepValue<OffsetDateTime> getEnabledTime() {
        return this.enabledTime;
    }

    public ObjectReplicationPolicyResource setEnabledTime(BicepValue<OffsetDateTime> enabledTime) {
        this.enabledTime.assign(enabledTime);
        return this;
    }

    public ObjectReplicationPolicyResource setEnabledTime(OffsetDateTime enabledTime) {
        return this.setEnabledTime(BicepValue.from(enabledTime));
    }

    public BicepValue<String> getPolicyId() {
        return this.policyId;
    }

    public ObjectReplicationPolicyResource setPolicyId(BicepValue<String> policyId) {
        this.policyId.assign(policyId);
        return this;
    }

    public ObjectReplicationPolicyResource setPolicyId(String policyId) {
        return this.setPolicyId(BicepValue.from(policyId));
    }

    public BicepValue<String> getType() {
        return this.type;
    }

    public ObjectReplicationPolicyResource setType(BicepValue<String> type) {
        this.type.assign(type);
        return this;
    }

    public ObjectReplicationPolicyResource setType(String type) {
        return this.setType(BicepValue.from(type));
    }

    public BicepValue<String> getArg0() {
        return this.arg0;
    }

    public ObjectReplicationPolicyResource setArg0(BicepValue<String> arg0) {
        this.arg0.assign(arg0);
        return this;
    }

    public ObjectReplicationPolicyResource setArg0(String arg0) {
        return this.setArg0(BicepValue.from(arg0));
    }

    public BicepValue<String> getDestinationAccount() {
        return this.destinationAccount;
    }

    public ObjectReplicationPolicyResource setDestinationAccount(BicepValue<String> destinationAccount) {
        this.destinationAccount.assign(destinationAccount);
        return this;
    }

    public ObjectReplicationPolicyResource setDestinationAccount(String destinationAccount) {
        return this.setDestinationAccount(BicepValue.from(destinationAccount));
    }

    public BicepValue<String> getId() {
        return this.id;
    }

    public ObjectReplicationPolicyResource setId(BicepValue<String> id) {
        this.id.assign(id);
        return this;
    }

    public ObjectReplicationPolicyResource setId(String id) {
        return this.setId(BicepValue.from(id));
    }

    public BicepValue<String> getSourceAccount() {
        return this.sourceAccount;
    }

    public ObjectReplicationPolicyResource setSourceAccount(BicepValue<String> sourceAccount) {
        this.sourceAccount.assign(sourceAccount);
        return this;
    }

    public ObjectReplicationPolicyResource setSourceAccount(String sourceAccount) {
        return this.setSourceAccount(BicepValue.from(sourceAccount));
    }

}
