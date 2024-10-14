// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated.models;

import java.util.List;
import com.azure.provisioning.storage.generated.models.UpdateHistoryProperty;
import com.azure.provisioning.storage.generated.models.ImmutabilityPolicyState;
import com.azure.provisioning.BicepList;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class ImmutabilityPolicyProperties extends ProvisioningConstruct {

    private final BicepValue<ImmutabilityPolicyState> state;
    private final BicepValue<Integer> immutabilityPeriodSinceCreationInDays;
    private final BicepList<UpdateHistoryProperty> updateHistory;
    private final BicepValue<String> etag;
    private final BicepValue<Boolean> allowProtectedAppendWritesAll;
    private final BicepValue<Boolean> allowProtectedAppendWrites;

    public ImmutabilityPolicyProperties() {
        state = BicepValue.defineProperty(this, "state", new String[] { "temp", "state" }, null);
        immutabilityPeriodSinceCreationInDays = BicepValue.defineProperty(this, "immutabilityPeriodSinceCreationInDays", new String[] { "temp", "immutabilityPeriodSinceCreationInDays" }, null);
        updateHistory = BicepList.defineProperty(this, "updateHistory", new String[] { "temp", "updateHistory" }, false, false);
        etag = BicepValue.defineProperty(this, "etag", new String[] { "temp", "etag" }, null);
        allowProtectedAppendWritesAll = BicepValue.defineProperty(this, "allowProtectedAppendWritesAll", new String[] { "temp", "allowProtectedAppendWritesAll" }, null);
        allowProtectedAppendWrites = BicepValue.defineProperty(this, "allowProtectedAppendWrites", new String[] { "temp", "allowProtectedAppendWrites" }, null);
    }

    public BicepValue<ImmutabilityPolicyState> getState() {
        return this.state;
    }

    public ImmutabilityPolicyProperties setState(BicepValue<ImmutabilityPolicyState> state) {
        this.state.assign(state);
        return this;
    }
    public BicepValue<Integer> getImmutabilityPeriodSinceCreationInDays() {
        return this.immutabilityPeriodSinceCreationInDays;
    }

    public ImmutabilityPolicyProperties setImmutabilityPeriodSinceCreationInDays(BicepValue<Integer> immutabilityPeriodSinceCreationInDays) {
        this.immutabilityPeriodSinceCreationInDays.assign(immutabilityPeriodSinceCreationInDays);
        return this;
    }
    public BicepValue<List<UpdateHistoryProperty>> getUpdateHistory() {
        return this.updateHistory;
    }

    public ImmutabilityPolicyProperties setUpdateHistory(BicepValue<List<UpdateHistoryProperty>> updateHistory) {
        this.updateHistory.assign(updateHistory);
        return this;
    }
    public BicepValue<String> getEtag() {
        return this.etag;
    }

    public ImmutabilityPolicyProperties setEtag(BicepValue<String> etag) {
        this.etag.assign(etag);
        return this;
    }
    public BicepValue<Boolean> getAllowProtectedAppendWritesAll() {
        return this.allowProtectedAppendWritesAll;
    }

    public ImmutabilityPolicyProperties setAllowProtectedAppendWritesAll(BicepValue<Boolean> allowProtectedAppendWritesAll) {
        this.allowProtectedAppendWritesAll.assign(allowProtectedAppendWritesAll);
        return this;
    }
    public BicepValue<Boolean> getAllowProtectedAppendWrites() {
        return this.allowProtectedAppendWrites;
    }

    public ImmutabilityPolicyProperties setAllowProtectedAppendWrites(BicepValue<Boolean> allowProtectedAppendWrites) {
        this.allowProtectedAppendWrites.assign(allowProtectedAppendWrites);
        return this;
    }
}
