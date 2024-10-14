// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated.models;

import java.time.OffsetDateTime;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class ProtectedAppendWritesHistory extends ProvisioningConstruct {

    private final BicepValue<Boolean> allowProtectedAppendWritesAll;
    private final BicepValue<OffsetDateTime> timestamp;

    public ProtectedAppendWritesHistory() {
        allowProtectedAppendWritesAll = BicepValue.defineProperty(this, "allowProtectedAppendWritesAll", new String[] { "temp", "allowProtectedAppendWritesAll" }, null);
        timestamp = BicepValue.defineProperty(this, "timestamp", new String[] { "temp", "timestamp" }, null);
    }

    public BicepValue<Boolean> getAllowProtectedAppendWritesAll() {
        return this.allowProtectedAppendWritesAll;
    }

    public ProtectedAppendWritesHistory setAllowProtectedAppendWritesAll(BicepValue<Boolean> allowProtectedAppendWritesAll) {
        this.allowProtectedAppendWritesAll.assign(allowProtectedAppendWritesAll);
        return this;
    }
    public BicepValue<OffsetDateTime> getTimestamp() {
        return this.timestamp;
    }

    public ProtectedAppendWritesHistory setTimestamp(BicepValue<OffsetDateTime> timestamp) {
        this.timestamp.assign(timestamp);
        return this;
    }
}
