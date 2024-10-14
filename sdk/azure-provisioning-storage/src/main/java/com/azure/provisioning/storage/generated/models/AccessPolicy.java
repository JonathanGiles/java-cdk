// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated.models;

import java.time.OffsetDateTime;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class AccessPolicy extends ProvisioningConstruct {

    private final BicepValue<OffsetDateTime> startTime;
    private final BicepValue<OffsetDateTime> expiryTime;
    private final BicepValue<String> permission;

    public AccessPolicy() {
        startTime = BicepValue.defineProperty(this, "startTime", new String[] { "temp", "startTime" }, null);
        expiryTime = BicepValue.defineProperty(this, "expiryTime", new String[] { "temp", "expiryTime" }, null);
        permission = BicepValue.defineProperty(this, "permission", new String[] { "temp", "permission" }, null);
    }

    public BicepValue<OffsetDateTime> getStartTime() {
        return this.startTime;
    }

    public AccessPolicy setStartTime(BicepValue<OffsetDateTime> startTime) {
        this.startTime.assign(startTime);
        return this;
    }
    public BicepValue<OffsetDateTime> getExpiryTime() {
        return this.expiryTime;
    }

    public AccessPolicy setExpiryTime(BicepValue<OffsetDateTime> expiryTime) {
        this.expiryTime.assign(expiryTime);
        return this;
    }
    public BicepValue<String> getPermission() {
        return this.permission;
    }

    public AccessPolicy setPermission(BicepValue<String> permission) {
        this.permission.assign(permission);
        return this;
    }
}
