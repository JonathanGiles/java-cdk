// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated;

import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.Resource;
import com.azure.provisioning.tmp.ResourceType;

public class ImmutabilityPolicyResource extends Resource {

    private final BicepValue<String> arg0;
    private final BicepValue<String> arg2;
    private final BicepValue<String> arg1;

    public ImmutabilityPolicyResource(String identifierName) {
        this(identifierName, null);
    }

    public ImmutabilityPolicyResource(String identifierName, String resourceVersion) {
        super(identifierName, new ResourceType("Microsoft.Storage/storageAccounts/blobServices/containers/immutabilityPolicies"), resourceVersion);
        arg0 = BicepValue.defineProperty(this, "arg0", new String[] { "temp", "arg0" }, false, false, false, null);
        arg2 = BicepValue.defineProperty(this, "arg2", new String[] { "temp", "arg2" }, false, false, false, null);
        arg1 = BicepValue.defineProperty(this, "arg1", new String[] { "temp", "arg1" }, false, false, false, null);
    }

    public BicepValue<String> getArg0() {
        return this.arg0;
    }

    public ImmutabilityPolicyResource setArg0(BicepValue<String> arg0) {
        this.arg0.assign(arg0);
        return this;
    }

    public ImmutabilityPolicyResource setArg0(String arg0) {
        return this.setArg0(BicepValue.from(arg0));
    }

    public BicepValue<String> getArg2() {
        return this.arg2;
    }

    public ImmutabilityPolicyResource setArg2(BicepValue<String> arg2) {
        this.arg2.assign(arg2);
        return this;
    }

    public ImmutabilityPolicyResource setArg2(String arg2) {
        return this.setArg2(BicepValue.from(arg2));
    }

    public BicepValue<String> getArg1() {
        return this.arg1;
    }

    public ImmutabilityPolicyResource setArg1(BicepValue<String> arg1) {
        this.arg1.assign(arg1);
        return this;
    }

    public ImmutabilityPolicyResource setArg1(String arg1) {
        return this.setArg1(BicepValue.from(arg1));
    }

}
