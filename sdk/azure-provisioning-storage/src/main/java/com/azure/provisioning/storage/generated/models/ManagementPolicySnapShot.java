// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated.models;

import com.azure.provisioning.storage.generated.models.DateAfterCreation;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class ManagementPolicySnapShot extends ProvisioningConstruct {

    private final BicepValue<DateAfterCreation> tierToCold;
    private final BicepValue<DateAfterCreation> tierToHot;
    private final BicepValue<DateAfterCreation> tierToCool;
    private final BicepValue<DateAfterCreation> tierToArchive;
    private final BicepValue<DateAfterCreation> delete;

    public ManagementPolicySnapShot() {
        tierToCold = BicepValue.defineProperty(this, "tierToCold", new String[] { "temp", "tierToCold" }, null);
        tierToHot = BicepValue.defineProperty(this, "tierToHot", new String[] { "temp", "tierToHot" }, null);
        tierToCool = BicepValue.defineProperty(this, "tierToCool", new String[] { "temp", "tierToCool" }, null);
        tierToArchive = BicepValue.defineProperty(this, "tierToArchive", new String[] { "temp", "tierToArchive" }, null);
        delete = BicepValue.defineProperty(this, "delete", new String[] { "temp", "delete" }, null);
    }

    public BicepValue<DateAfterCreation> getTierToCold() {
        return this.tierToCold;
    }

    public ManagementPolicySnapShot setTierToCold(BicepValue<DateAfterCreation> tierToCold) {
        this.tierToCold.assign(tierToCold);
        return this;
    }
    public BicepValue<DateAfterCreation> getTierToHot() {
        return this.tierToHot;
    }

    public ManagementPolicySnapShot setTierToHot(BicepValue<DateAfterCreation> tierToHot) {
        this.tierToHot.assign(tierToHot);
        return this;
    }
    public BicepValue<DateAfterCreation> getTierToCool() {
        return this.tierToCool;
    }

    public ManagementPolicySnapShot setTierToCool(BicepValue<DateAfterCreation> tierToCool) {
        this.tierToCool.assign(tierToCool);
        return this;
    }
    public BicepValue<DateAfterCreation> getTierToArchive() {
        return this.tierToArchive;
    }

    public ManagementPolicySnapShot setTierToArchive(BicepValue<DateAfterCreation> tierToArchive) {
        this.tierToArchive.assign(tierToArchive);
        return this;
    }
    public BicepValue<DateAfterCreation> getDelete() {
        return this.delete;
    }

    public ManagementPolicySnapShot setDelete(BicepValue<DateAfterCreation> delete) {
        this.delete.assign(delete);
        return this;
    }
}
