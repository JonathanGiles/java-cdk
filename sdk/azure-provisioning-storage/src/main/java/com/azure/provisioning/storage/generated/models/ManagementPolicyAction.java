// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated.models;

import com.azure.provisioning.storage.generated.models.ManagementPolicyBaseBlob;
import com.azure.provisioning.storage.generated.models.ManagementPolicyVersion;
import com.azure.provisioning.storage.generated.models.ManagementPolicySnapShot;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class ManagementPolicyAction extends ProvisioningConstruct {

    private final BicepValue<ManagementPolicyBaseBlob> baseBlob;
    private final BicepValue<ManagementPolicySnapShot> snapshot;
    private final BicepValue<ManagementPolicyVersion> version;

    public ManagementPolicyAction() {
        baseBlob = BicepValue.defineProperty(this, "baseBlob", new String[] { "temp", "baseBlob" }, null);
        snapshot = BicepValue.defineProperty(this, "snapshot", new String[] { "temp", "snapshot" }, null);
        version = BicepValue.defineProperty(this, "version", new String[] { "temp", "version" }, null);
    }

    public BicepValue<ManagementPolicyBaseBlob> getBaseBlob() {
        return this.baseBlob;
    }

    public ManagementPolicyAction setBaseBlob(BicepValue<ManagementPolicyBaseBlob> baseBlob) {
        this.baseBlob.assign(baseBlob);
        return this;
    }
    public BicepValue<ManagementPolicySnapShot> getSnapshot() {
        return this.snapshot;
    }

    public ManagementPolicyAction setSnapshot(BicepValue<ManagementPolicySnapShot> snapshot) {
        this.snapshot.assign(snapshot);
        return this;
    }
    public BicepValue<ManagementPolicyVersion> getVersion() {
        return this.version;
    }

    public ManagementPolicyAction setVersion(BicepValue<ManagementPolicyVersion> version) {
        this.version.assign(version);
        return this;
    }
}
