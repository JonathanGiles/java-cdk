// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated.models;

import java.time.OffsetDateTime;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class TagProperty extends ProvisioningConstruct {

    private final BicepValue<String> tag;
    private final BicepValue<String> objectIdentifier;
    private final BicepValue<String> upn;
    private final BicepValue<OffsetDateTime> timestamp;
    private final BicepValue<String> tenantId;

    public TagProperty() {
        tag = BicepValue.defineProperty(this, "tag", new String[] { "temp", "tag" }, null);
        objectIdentifier = BicepValue.defineProperty(this, "objectIdentifier", new String[] { "temp", "objectIdentifier" }, null);
        upn = BicepValue.defineProperty(this, "upn", new String[] { "temp", "upn" }, null);
        timestamp = BicepValue.defineProperty(this, "timestamp", new String[] { "temp", "timestamp" }, null);
        tenantId = BicepValue.defineProperty(this, "tenantId", new String[] { "temp", "tenantId" }, null);
    }

    public BicepValue<String> getTag() {
        return this.tag;
    }

    public TagProperty setTag(BicepValue<String> tag) {
        this.tag.assign(tag);
        return this;
    }
    public BicepValue<String> getObjectIdentifier() {
        return this.objectIdentifier;
    }

    public TagProperty setObjectIdentifier(BicepValue<String> objectIdentifier) {
        this.objectIdentifier.assign(objectIdentifier);
        return this;
    }
    public BicepValue<String> getUpn() {
        return this.upn;
    }

    public TagProperty setUpn(BicepValue<String> upn) {
        this.upn.assign(upn);
        return this;
    }
    public BicepValue<OffsetDateTime> getTimestamp() {
        return this.timestamp;
    }

    public TagProperty setTimestamp(BicepValue<OffsetDateTime> timestamp) {
        this.timestamp.assign(timestamp);
        return this;
    }
    public BicepValue<String> getTenantId() {
        return this.tenantId;
    }

    public TagProperty setTenantId(BicepValue<String> tenantId) {
        this.tenantId.assign(tenantId);
        return this;
    }
}
