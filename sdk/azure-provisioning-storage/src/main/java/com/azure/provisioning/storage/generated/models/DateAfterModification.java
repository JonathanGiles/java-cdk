// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated.models;

import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class DateAfterModification extends ProvisioningConstruct {

    private final BicepValue<Float> daysAfterCreationGreaterThan;
    private final BicepValue<Float> daysAfterLastAccessTimeGreaterThan;
    private final BicepValue<Float> daysAfterModificationGreaterThan;
    private final BicepValue<Float> daysAfterLastTierChangeGreaterThan;

    public DateAfterModification() {
        daysAfterCreationGreaterThan = BicepValue.defineProperty(this, "daysAfterCreationGreaterThan", new String[] { "temp", "daysAfterCreationGreaterThan" }, null);
        daysAfterLastAccessTimeGreaterThan = BicepValue.defineProperty(this, "daysAfterLastAccessTimeGreaterThan", new String[] { "temp", "daysAfterLastAccessTimeGreaterThan" }, null);
        daysAfterModificationGreaterThan = BicepValue.defineProperty(this, "daysAfterModificationGreaterThan", new String[] { "temp", "daysAfterModificationGreaterThan" }, null);
        daysAfterLastTierChangeGreaterThan = BicepValue.defineProperty(this, "daysAfterLastTierChangeGreaterThan", new String[] { "temp", "daysAfterLastTierChangeGreaterThan" }, null);
    }

    public BicepValue<Float> getDaysAfterCreationGreaterThan() {
        return this.daysAfterCreationGreaterThan;
    }

    public DateAfterModification setDaysAfterCreationGreaterThan(BicepValue<Float> daysAfterCreationGreaterThan) {
        this.daysAfterCreationGreaterThan.assign(daysAfterCreationGreaterThan);
        return this;
    }
    public BicepValue<Float> getDaysAfterLastAccessTimeGreaterThan() {
        return this.daysAfterLastAccessTimeGreaterThan;
    }

    public DateAfterModification setDaysAfterLastAccessTimeGreaterThan(BicepValue<Float> daysAfterLastAccessTimeGreaterThan) {
        this.daysAfterLastAccessTimeGreaterThan.assign(daysAfterLastAccessTimeGreaterThan);
        return this;
    }
    public BicepValue<Float> getDaysAfterModificationGreaterThan() {
        return this.daysAfterModificationGreaterThan;
    }

    public DateAfterModification setDaysAfterModificationGreaterThan(BicepValue<Float> daysAfterModificationGreaterThan) {
        this.daysAfterModificationGreaterThan.assign(daysAfterModificationGreaterThan);
        return this;
    }
    public BicepValue<Float> getDaysAfterLastTierChangeGreaterThan() {
        return this.daysAfterLastTierChangeGreaterThan;
    }

    public DateAfterModification setDaysAfterLastTierChangeGreaterThan(BicepValue<Float> daysAfterLastTierChangeGreaterThan) {
        this.daysAfterLastTierChangeGreaterThan.assign(daysAfterLastTierChangeGreaterThan);
        return this;
    }
}
