// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated.models;

import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class DateAfterCreation extends ProvisioningConstruct {

    private final BicepValue<float> daysAfterCreationGreaterThan;
    private final BicepValue<Float> daysAfterLastTierChangeGreaterThan;

    public DateAfterCreation() {
        daysAfterCreationGreaterThan = BicepValue.defineProperty(this, "daysAfterCreationGreaterThan", new String[] { "temp", "daysAfterCreationGreaterThan" }, null);
        daysAfterLastTierChangeGreaterThan = BicepValue.defineProperty(this, "daysAfterLastTierChangeGreaterThan", new String[] { "temp", "daysAfterLastTierChangeGreaterThan" }, null);
    }

    public BicepValue<float> getDaysAfterCreationGreaterThan() {
        return this.daysAfterCreationGreaterThan;
    }

    public DateAfterCreation setDaysAfterCreationGreaterThan(BicepValue<float> daysAfterCreationGreaterThan) {
        this.daysAfterCreationGreaterThan.assign(daysAfterCreationGreaterThan);
        return this;
    }
    public BicepValue<Float> getDaysAfterLastTierChangeGreaterThan() {
        return this.daysAfterLastTierChangeGreaterThan;
    }

    public DateAfterCreation setDaysAfterLastTierChangeGreaterThan(BicepValue<Float> daysAfterLastTierChangeGreaterThan) {
        this.daysAfterLastTierChangeGreaterThan.assign(daysAfterLastTierChangeGreaterThan);
        return this;
    }
}
