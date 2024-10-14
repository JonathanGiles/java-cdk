// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated.models;

import com.azure.provisioning.storage.generated.models.ImmutabilityPolicyUpdateType;
import java.time.OffsetDateTime;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class UpdateHistoryProperty extends ProvisioningConstruct {

    private final BicepValue<String> upn;
    private final BicepValue<Boolean> allowProtectedAppendWritesAll;
    private final BicepValue<ImmutabilityPolicyUpdateType> update;
    private final BicepValue<Boolean> allowProtectedAppendWrites;
    private final BicepValue<String> tenantId;
    private final BicepValue<String> objectIdentifier;
    private final BicepValue<OffsetDateTime> timestamp;
    private final BicepValue<Integer> immutabilityPeriodSinceCreationInDays;

    public UpdateHistoryProperty() {
        upn = BicepValue.defineProperty(this, "upn", new String[] { "temp", "upn" }, null);
        allowProtectedAppendWritesAll = BicepValue.defineProperty(this, "allowProtectedAppendWritesAll", new String[] { "temp", "allowProtectedAppendWritesAll" }, null);
        update = BicepValue.defineProperty(this, "update", new String[] { "temp", "update" }, null);
        allowProtectedAppendWrites = BicepValue.defineProperty(this, "allowProtectedAppendWrites", new String[] { "temp", "allowProtectedAppendWrites" }, null);
        tenantId = BicepValue.defineProperty(this, "tenantId", new String[] { "temp", "tenantId" }, null);
        objectIdentifier = BicepValue.defineProperty(this, "objectIdentifier", new String[] { "temp", "objectIdentifier" }, null);
        timestamp = BicepValue.defineProperty(this, "timestamp", new String[] { "temp", "timestamp" }, null);
        immutabilityPeriodSinceCreationInDays = BicepValue.defineProperty(this, "immutabilityPeriodSinceCreationInDays", new String[] { "temp", "immutabilityPeriodSinceCreationInDays" }, null);
    }

    public BicepValue<String> getUpn() {
        return this.upn;
    }

    public UpdateHistoryProperty setUpn(BicepValue<String> upn) {
        this.upn.assign(upn);
        return this;
    }
    public BicepValue<Boolean> getAllowProtectedAppendWritesAll() {
        return this.allowProtectedAppendWritesAll;
    }

    public UpdateHistoryProperty setAllowProtectedAppendWritesAll(BicepValue<Boolean> allowProtectedAppendWritesAll) {
        this.allowProtectedAppendWritesAll.assign(allowProtectedAppendWritesAll);
        return this;
    }
    public BicepValue<ImmutabilityPolicyUpdateType> getUpdate() {
        return this.update;
    }

    public UpdateHistoryProperty setUpdate(BicepValue<ImmutabilityPolicyUpdateType> update) {
        this.update.assign(update);
        return this;
    }
    public BicepValue<Boolean> getAllowProtectedAppendWrites() {
        return this.allowProtectedAppendWrites;
    }

    public UpdateHistoryProperty setAllowProtectedAppendWrites(BicepValue<Boolean> allowProtectedAppendWrites) {
        this.allowProtectedAppendWrites.assign(allowProtectedAppendWrites);
        return this;
    }
    public BicepValue<String> getTenantId() {
        return this.tenantId;
    }

    public UpdateHistoryProperty setTenantId(BicepValue<String> tenantId) {
        this.tenantId.assign(tenantId);
        return this;
    }
    public BicepValue<String> getObjectIdentifier() {
        return this.objectIdentifier;
    }

    public UpdateHistoryProperty setObjectIdentifier(BicepValue<String> objectIdentifier) {
        this.objectIdentifier.assign(objectIdentifier);
        return this;
    }
    public BicepValue<OffsetDateTime> getTimestamp() {
        return this.timestamp;
    }

    public UpdateHistoryProperty setTimestamp(BicepValue<OffsetDateTime> timestamp) {
        this.timestamp.assign(timestamp);
        return this;
    }
    public BicepValue<Integer> getImmutabilityPeriodSinceCreationInDays() {
        return this.immutabilityPeriodSinceCreationInDays;
    }

    public UpdateHistoryProperty setImmutabilityPeriodSinceCreationInDays(BicepValue<Integer> immutabilityPeriodSinceCreationInDays) {
        this.immutabilityPeriodSinceCreationInDays.assign(immutabilityPeriodSinceCreationInDays);
        return this;
    }
}
