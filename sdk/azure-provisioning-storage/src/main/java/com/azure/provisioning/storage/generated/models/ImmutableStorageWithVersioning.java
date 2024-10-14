// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated.models;

import com.azure.provisioning.storage.generated.models.MigrationState;
import java.time.OffsetDateTime;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class ImmutableStorageWithVersioning extends ProvisioningConstruct {

    private final BicepValue<Boolean> enabled;
    private final BicepValue<MigrationState> migrationState;
    private final BicepValue<OffsetDateTime> timestamp;

    public ImmutableStorageWithVersioning() {
        enabled = BicepValue.defineProperty(this, "enabled", new String[] { "temp", "enabled" }, null);
        migrationState = BicepValue.defineProperty(this, "migrationState", new String[] { "temp", "migrationState" }, null);
        timestamp = BicepValue.defineProperty(this, "timestamp", new String[] { "temp", "timestamp" }, null);
    }

    public BicepValue<Boolean> getEnabled() {
        return this.enabled;
    }

    public ImmutableStorageWithVersioning setEnabled(BicepValue<Boolean> enabled) {
        this.enabled.assign(enabled);
        return this;
    }
    public BicepValue<MigrationState> getMigrationState() {
        return this.migrationState;
    }

    public ImmutableStorageWithVersioning setMigrationState(BicepValue<MigrationState> migrationState) {
        this.migrationState.assign(migrationState);
        return this;
    }
    public BicepValue<OffsetDateTime> getTimestamp() {
        return this.timestamp;
    }

    public ImmutableStorageWithVersioning setTimestamp(BicepValue<OffsetDateTime> timestamp) {
        this.timestamp.assign(timestamp);
        return this;
    }
}
