// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated.models;

import java.time.OffsetDateTime;
import com.azure.core.util.logging.ClientLogger;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class TableAccessPolicy extends ProvisioningConstruct {

    private final BicepValue<ClientLogger> lOGGER;
    private final BicepValue<String> permission;
    private final BicepValue<OffsetDateTime> startTime;
    private final BicepValue<OffsetDateTime> expiryTime;

    public TableAccessPolicy() {
        lOGGER = BicepValue.defineProperty(this, "lOGGER", new String[] { "temp", "lOGGER" }, null);
        permission = BicepValue.defineProperty(this, "permission", new String[] { "temp", "permission" }, null);
        startTime = BicepValue.defineProperty(this, "startTime", new String[] { "temp", "startTime" }, null);
        expiryTime = BicepValue.defineProperty(this, "expiryTime", new String[] { "temp", "expiryTime" }, null);
    }

    public BicepValue<ClientLogger> getLOGGER() {
        return this.lOGGER;
    }

    public TableAccessPolicy setLOGGER(BicepValue<ClientLogger> lOGGER) {
        this.lOGGER.assign(lOGGER);
        return this;
    }
    public BicepValue<String> getPermission() {
        return this.permission;
    }

    public TableAccessPolicy setPermission(BicepValue<String> permission) {
        this.permission.assign(permission);
        return this;
    }
    public BicepValue<OffsetDateTime> getStartTime() {
        return this.startTime;
    }

    public TableAccessPolicy setStartTime(BicepValue<OffsetDateTime> startTime) {
        this.startTime.assign(startTime);
        return this;
    }
    public BicepValue<OffsetDateTime> getExpiryTime() {
        return this.expiryTime;
    }

    public TableAccessPolicy setExpiryTime(BicepValue<OffsetDateTime> expiryTime) {
        this.expiryTime.assign(expiryTime);
        return this;
    }
}
