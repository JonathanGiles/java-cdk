// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated.models;

import com.azure.provisioning.storage.generated.models.TagProperty;
import java.util.List;
import com.azure.provisioning.storage.generated.models.ProtectedAppendWritesHistory;
import com.azure.provisioning.BicepList;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class LegalHoldProperties extends ProvisioningConstruct {

    private final BicepValue<ProtectedAppendWritesHistory> protectedAppendWritesHistory;
    private final BicepList<TagProperty> tags;
    private final BicepValue<Boolean> hasLegalHold;

    public LegalHoldProperties() {
        protectedAppendWritesHistory = BicepValue.defineProperty(this, "protectedAppendWritesHistory", new String[] { "temp", "protectedAppendWritesHistory" }, null);
        tags = BicepList.defineProperty(this, "tags", new String[] { "temp", "tags" }, false, false);
        hasLegalHold = BicepValue.defineProperty(this, "hasLegalHold", new String[] { "temp", "hasLegalHold" }, null);
    }

    public BicepValue<ProtectedAppendWritesHistory> getProtectedAppendWritesHistory() {
        return this.protectedAppendWritesHistory;
    }

    public LegalHoldProperties setProtectedAppendWritesHistory(BicepValue<ProtectedAppendWritesHistory> protectedAppendWritesHistory) {
        this.protectedAppendWritesHistory.assign(protectedAppendWritesHistory);
        return this;
    }
    public BicepValue<List<TagProperty>> getTags() {
        return this.tags;
    }

    public LegalHoldProperties setTags(BicepValue<List<TagProperty>> tags) {
        this.tags.assign(tags);
        return this;
    }
    public BicepValue<Boolean> getHasLegalHold() {
        return this.hasLegalHold;
    }

    public LegalHoldProperties setHasLegalHold(BicepValue<Boolean> hasLegalHold) {
        this.hasLegalHold.assign(hasLegalHold);
        return this;
    }
}
