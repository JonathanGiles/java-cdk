// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated;

import com.azure.provisioning.storage.generated.models.ImmutabilityPolicyState;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.Resource;
import com.azure.provisioning.tmp.ResourceType;

public class BlobContainersCreateOrUpdateImmutabilityPolicyResponseResource extends Resource {

    private final BicepValue<Boolean> allowProtectedAppendWritesAll;
    private final BicepValue<String> etag;
    private final BicepValue<String> arg1;
    private final BicepValue<String> name;
    private final BicepValue<String> arg2;
    private final BicepValue<String> arg3;
    private final BicepValue<ImmutabilityPolicyState> state;
    private final BicepValue<Boolean> allowProtectedAppendWrites;
    private final BicepValue<String> type;
    private final BicepValue<String> arg0;
    private final BicepValue<String> id;
    private final BicepValue<Integer> immutabilityPeriodSinceCreationInDays;

    public BlobContainersCreateOrUpdateImmutabilityPolicyResponseResource(String identifierName) {
        this(identifierName, null);
    }

    public BlobContainersCreateOrUpdateImmutabilityPolicyResponseResource(String identifierName, String resourceVersion) {
        super(identifierName, new ResourceType("null"), resourceVersion);
        allowProtectedAppendWritesAll = BicepValue.defineProperty(this, "allowProtectedAppendWritesAll", new String[] { "temp", "allowProtectedAppendWritesAll" }, false, false, false, null);
        etag = BicepValue.defineProperty(this, "etag", new String[] { "temp", "etag" }, false, false, false, null);
        arg1 = BicepValue.defineProperty(this, "arg1", new String[] { "temp", "arg1" }, false, false, false, null);
        name = BicepValue.defineProperty(this, "name", new String[] { "temp", "name" }, false, false, false, null);
        arg2 = BicepValue.defineProperty(this, "arg2", new String[] { "temp", "arg2" }, false, false, false, null);
        arg3 = BicepValue.defineProperty(this, "arg3", new String[] { "temp", "arg3" }, false, false, false, null);
        state = BicepValue.defineProperty(this, "state", new String[] { "temp", "state" }, false, false, false, null);
        allowProtectedAppendWrites = BicepValue.defineProperty(this, "allowProtectedAppendWrites", new String[] { "temp", "allowProtectedAppendWrites" }, false, false, false, null);
        type = BicepValue.defineProperty(this, "type", new String[] { "temp", "type" }, false, false, false, null);
        arg0 = BicepValue.defineProperty(this, "arg0", new String[] { "temp", "arg0" }, false, false, false, null);
        id = BicepValue.defineProperty(this, "id", new String[] { "temp", "id" }, false, false, false, null);
        immutabilityPeriodSinceCreationInDays = BicepValue.defineProperty(this, "immutabilityPeriodSinceCreationInDays", new String[] { "temp", "immutabilityPeriodSinceCreationInDays" }, false, false, false, null);
    }

    public BicepValue<Boolean> getAllowProtectedAppendWritesAll() {
        return this.allowProtectedAppendWritesAll;
    }

    public BlobContainersCreateOrUpdateImmutabilityPolicyResponseResource setAllowProtectedAppendWritesAll(BicepValue<Boolean> allowProtectedAppendWritesAll) {
        this.allowProtectedAppendWritesAll.assign(allowProtectedAppendWritesAll);
        return this;
    }

    public BlobContainersCreateOrUpdateImmutabilityPolicyResponseResource setAllowProtectedAppendWritesAll(Boolean allowProtectedAppendWritesAll) {
        return this.setAllowProtectedAppendWritesAll(BicepValue.from(allowProtectedAppendWritesAll));
    }

    public BicepValue<String> getEtag() {
        return this.etag;
    }

    public BlobContainersCreateOrUpdateImmutabilityPolicyResponseResource setEtag(BicepValue<String> etag) {
        this.etag.assign(etag);
        return this;
    }

    public BlobContainersCreateOrUpdateImmutabilityPolicyResponseResource setEtag(String etag) {
        return this.setEtag(BicepValue.from(etag));
    }

    public BicepValue<String> getArg1() {
        return this.arg1;
    }

    public BlobContainersCreateOrUpdateImmutabilityPolicyResponseResource setArg1(BicepValue<String> arg1) {
        this.arg1.assign(arg1);
        return this;
    }

    public BlobContainersCreateOrUpdateImmutabilityPolicyResponseResource setArg1(String arg1) {
        return this.setArg1(BicepValue.from(arg1));
    }

    public BicepValue<String> getName() {
        return this.name;
    }

    public BlobContainersCreateOrUpdateImmutabilityPolicyResponseResource setName(BicepValue<String> name) {
        this.name.assign(name);
        return this;
    }

    public BlobContainersCreateOrUpdateImmutabilityPolicyResponseResource setName(String name) {
        return this.setName(BicepValue.from(name));
    }

    public BicepValue<String> getArg2() {
        return this.arg2;
    }

    public BlobContainersCreateOrUpdateImmutabilityPolicyResponseResource setArg2(BicepValue<String> arg2) {
        this.arg2.assign(arg2);
        return this;
    }

    public BlobContainersCreateOrUpdateImmutabilityPolicyResponseResource setArg2(String arg2) {
        return this.setArg2(BicepValue.from(arg2));
    }

    public BicepValue<String> getArg3() {
        return this.arg3;
    }

    public BlobContainersCreateOrUpdateImmutabilityPolicyResponseResource setArg3(BicepValue<String> arg3) {
        this.arg3.assign(arg3);
        return this;
    }

    public BlobContainersCreateOrUpdateImmutabilityPolicyResponseResource setArg3(String arg3) {
        return this.setArg3(BicepValue.from(arg3));
    }

    public BicepValue<ImmutabilityPolicyState> getState() {
        return this.state;
    }

    public BlobContainersCreateOrUpdateImmutabilityPolicyResponseResource setState(BicepValue<ImmutabilityPolicyState> state) {
        this.state.assign(state);
        return this;
    }

    public BlobContainersCreateOrUpdateImmutabilityPolicyResponseResource setState(ImmutabilityPolicyState state) {
        return this.setState(BicepValue.from(state));
    }

    public BicepValue<Boolean> getAllowProtectedAppendWrites() {
        return this.allowProtectedAppendWrites;
    }

    public BlobContainersCreateOrUpdateImmutabilityPolicyResponseResource setAllowProtectedAppendWrites(BicepValue<Boolean> allowProtectedAppendWrites) {
        this.allowProtectedAppendWrites.assign(allowProtectedAppendWrites);
        return this;
    }

    public BlobContainersCreateOrUpdateImmutabilityPolicyResponseResource setAllowProtectedAppendWrites(Boolean allowProtectedAppendWrites) {
        return this.setAllowProtectedAppendWrites(BicepValue.from(allowProtectedAppendWrites));
    }

    public BicepValue<String> getType() {
        return this.type;
    }

    public BlobContainersCreateOrUpdateImmutabilityPolicyResponseResource setType(BicepValue<String> type) {
        this.type.assign(type);
        return this;
    }

    public BlobContainersCreateOrUpdateImmutabilityPolicyResponseResource setType(String type) {
        return this.setType(BicepValue.from(type));
    }

    public BicepValue<String> getArg0() {
        return this.arg0;
    }

    public BlobContainersCreateOrUpdateImmutabilityPolicyResponseResource setArg0(BicepValue<String> arg0) {
        this.arg0.assign(arg0);
        return this;
    }

    public BlobContainersCreateOrUpdateImmutabilityPolicyResponseResource setArg0(String arg0) {
        return this.setArg0(BicepValue.from(arg0));
    }

    public BicepValue<String> getId() {
        return this.id;
    }

    public BlobContainersCreateOrUpdateImmutabilityPolicyResponseResource setId(BicepValue<String> id) {
        this.id.assign(id);
        return this;
    }

    public BlobContainersCreateOrUpdateImmutabilityPolicyResponseResource setId(String id) {
        return this.setId(BicepValue.from(id));
    }

    public BicepValue<Integer> getImmutabilityPeriodSinceCreationInDays() {
        return this.immutabilityPeriodSinceCreationInDays;
    }

    public BlobContainersCreateOrUpdateImmutabilityPolicyResponseResource setImmutabilityPeriodSinceCreationInDays(BicepValue<Integer> immutabilityPeriodSinceCreationInDays) {
        this.immutabilityPeriodSinceCreationInDays.assign(immutabilityPeriodSinceCreationInDays);
        return this;
    }

    public BlobContainersCreateOrUpdateImmutabilityPolicyResponseResource setImmutabilityPeriodSinceCreationInDays(Integer immutabilityPeriodSinceCreationInDays) {
        return this.setImmutabilityPeriodSinceCreationInDays(BicepValue.from(immutabilityPeriodSinceCreationInDays));
    }

}
