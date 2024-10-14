// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated.models;

import com.azure.provisioning.storage.generated.models.DateAfterModification;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class ManagementPolicyBaseBlob extends ProvisioningConstruct {

    private final BicepValue<DateAfterModification> tierToHot;
    private final BicepValue<Boolean> enableAutoTierToHotFromCool;
    private final BicepValue<DateAfterModification> tierToCool;
    private final BicepValue<DateAfterModification> tierToArchive;
    private final BicepValue<DateAfterModification> delete;
    private final BicepValue<DateAfterModification> tierToCold;

    public ManagementPolicyBaseBlob() {
        tierToHot = BicepValue.defineProperty(this, "tierToHot", new String[] { "temp", "tierToHot" }, null);
        enableAutoTierToHotFromCool = BicepValue.defineProperty(this, "enableAutoTierToHotFromCool", new String[] { "temp", "enableAutoTierToHotFromCool" }, null);
        tierToCool = BicepValue.defineProperty(this, "tierToCool", new String[] { "temp", "tierToCool" }, null);
        tierToArchive = BicepValue.defineProperty(this, "tierToArchive", new String[] { "temp", "tierToArchive" }, null);
        delete = BicepValue.defineProperty(this, "delete", new String[] { "temp", "delete" }, null);
        tierToCold = BicepValue.defineProperty(this, "tierToCold", new String[] { "temp", "tierToCold" }, null);
    }

    public BicepValue<DateAfterModification> getTierToHot() {
        return this.tierToHot;
    }

    public ManagementPolicyBaseBlob setTierToHot(BicepValue<DateAfterModification> tierToHot) {
        this.tierToHot.assign(tierToHot);
        return this;
    }
    public BicepValue<Boolean> getEnableAutoTierToHotFromCool() {
        return this.enableAutoTierToHotFromCool;
    }

    public ManagementPolicyBaseBlob setEnableAutoTierToHotFromCool(BicepValue<Boolean> enableAutoTierToHotFromCool) {
        this.enableAutoTierToHotFromCool.assign(enableAutoTierToHotFromCool);
        return this;
    }
    public BicepValue<DateAfterModification> getTierToCool() {
        return this.tierToCool;
    }

    public ManagementPolicyBaseBlob setTierToCool(BicepValue<DateAfterModification> tierToCool) {
        this.tierToCool.assign(tierToCool);
        return this;
    }
    public BicepValue<DateAfterModification> getTierToArchive() {
        return this.tierToArchive;
    }

    public ManagementPolicyBaseBlob setTierToArchive(BicepValue<DateAfterModification> tierToArchive) {
        this.tierToArchive.assign(tierToArchive);
        return this;
    }
    public BicepValue<DateAfterModification> getDelete() {
        return this.delete;
    }

    public ManagementPolicyBaseBlob setDelete(BicepValue<DateAfterModification> delete) {
        this.delete.assign(delete);
        return this;
    }
    public BicepValue<DateAfterModification> getTierToCold() {
        return this.tierToCold;
    }

    public ManagementPolicyBaseBlob setTierToCold(BicepValue<DateAfterModification> tierToCold) {
        this.tierToCold.assign(tierToCold);
        return this;
    }
}
