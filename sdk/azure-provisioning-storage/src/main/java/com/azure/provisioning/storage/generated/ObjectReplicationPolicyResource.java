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

    private final BicepValue<String> resourceGroupName;
    private final BicepValue<String> id;
    private final BicepValue<String> objectReplicationPolicyId;
    private final BicepValue<String> type;
    private final BicepValue<OffsetDateTime> enabledTime;
    private final BicepValue<String> destinationAccount;
    private final BicepList<ObjectReplicationPolicyRule> rules;
    private final BicepValue<String> sourceAccount;
    private final BicepValue<String> name;
    private final BicepValue<String> policyId;
    private final BicepValue<String> accountName;

    public ObjectReplicationPolicyResource(String identifierName) {
        this(identifierName, null);
    }

    public ObjectReplicationPolicyResource(String identifierName, String resourceVersion) {
        super(identifierName, new ResourceType("Microsoft.Storage/storageAccounts/objectReplicationPolicies"), resourceVersion);
        resourceGroupName = BicepValue.defineProperty(this, "resourceGroupName", new String[] { "temp", "resourceGroupName" }, false, false, false, null);
        id = BicepValue.defineProperty(this, "id", new String[] { "temp", "id" }, false, false, false, null);
        objectReplicationPolicyId = BicepValue.defineProperty(this, "objectReplicationPolicyId", new String[] { "temp", "objectReplicationPolicyId" }, false, false, false, null);
        type = BicepValue.defineProperty(this, "type", new String[] { "temp", "type" }, false, false, false, null);
        enabledTime = BicepValue.defineProperty(this, "enabledTime", new String[] { "temp", "enabledTime" }, false, false, false, null);
        destinationAccount = BicepValue.defineProperty(this, "destinationAccount", new String[] { "temp", "destinationAccount" }, false, false, false, null);
        rules = BicepList.defineProperty(this, "rules", new String[] { "temp", "rules" }, false, false);
        sourceAccount = BicepValue.defineProperty(this, "sourceAccount", new String[] { "temp", "sourceAccount" }, false, false, false, null);
        name = BicepValue.defineProperty(this, "name", new String[] { "temp", "name" }, false, false, false, null);
        policyId = BicepValue.defineProperty(this, "policyId", new String[] { "temp", "policyId" }, false, false, false, null);
        accountName = BicepValue.defineProperty(this, "accountName", new String[] { "temp", "accountName" }, false, false, false, null);
    }

    public BicepValue<String> getResourceGroupName() {
        return this.resourceGroupName;
    }

    public ObjectReplicationPolicyResource setResourceGroupName(BicepValue<String> resourceGroupName) {
        this.resourceGroupName.assign(resourceGroupName);
        return this;
    }

    public ObjectReplicationPolicyResource setResourceGroupName(String resourceGroupName) {
        return this.setResourceGroupName(BicepValue.from(resourceGroupName));
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

    public BicepValue<String> getObjectReplicationPolicyId() {
        return this.objectReplicationPolicyId;
    }

    public ObjectReplicationPolicyResource setObjectReplicationPolicyId(BicepValue<String> objectReplicationPolicyId) {
        this.objectReplicationPolicyId.assign(objectReplicationPolicyId);
        return this;
    }

    public ObjectReplicationPolicyResource setObjectReplicationPolicyId(String objectReplicationPolicyId) {
        return this.setObjectReplicationPolicyId(BicepValue.from(objectReplicationPolicyId));
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

    public BicepValue<String> getAccountName() {
        return this.accountName;
    }

    public ObjectReplicationPolicyResource setAccountName(BicepValue<String> accountName) {
        this.accountName.assign(accountName);
        return this;
    }

    public ObjectReplicationPolicyResource setAccountName(String accountName) {
        return this.setAccountName(BicepValue.from(accountName));
    }

}
