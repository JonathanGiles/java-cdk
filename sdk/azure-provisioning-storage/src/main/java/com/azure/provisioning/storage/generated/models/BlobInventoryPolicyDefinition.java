// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated.models;

import java.util.List;
import com.azure.provisioning.storage.generated.models.Format;
import com.azure.core.util.logging.ClientLogger;
import com.azure.provisioning.storage.generated.models.Schedule;
import java.lang.String;
import com.azure.provisioning.storage.generated.models.ObjectType;
import com.azure.provisioning.storage.generated.models.BlobInventoryPolicyFilter;
import com.azure.provisioning.BicepList;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class BlobInventoryPolicyDefinition extends ProvisioningConstruct {

    private final BicepList<String> schemaFields;
    private final BicepValue<Schedule> schedule;
    private final BicepValue<BlobInventoryPolicyFilter> filters;
    private final BicepValue<ObjectType> objectType;
    private final BicepValue<Format> format;
    private final BicepValue<ClientLogger> lOGGER;

    public BlobInventoryPolicyDefinition() {
        schemaFields = BicepList.defineProperty(this, "schemaFields", new String[] { "temp", "schemaFields" }, false, false);
        schedule = BicepValue.defineProperty(this, "schedule", new String[] { "temp", "schedule" }, null);
        filters = BicepValue.defineProperty(this, "filters", new String[] { "temp", "filters" }, null);
        objectType = BicepValue.defineProperty(this, "objectType", new String[] { "temp", "objectType" }, null);
        format = BicepValue.defineProperty(this, "format", new String[] { "temp", "format" }, null);
        lOGGER = BicepValue.defineProperty(this, "lOGGER", new String[] { "temp", "lOGGER" }, null);
    }

    public BicepValue<List<String>> getSchemaFields() {
        return this.schemaFields;
    }

    public BlobInventoryPolicyDefinition setSchemaFields(BicepValue<List<String>> schemaFields) {
        this.schemaFields.assign(schemaFields);
        return this;
    }
    public BicepValue<Schedule> getSchedule() {
        return this.schedule;
    }

    public BlobInventoryPolicyDefinition setSchedule(BicepValue<Schedule> schedule) {
        this.schedule.assign(schedule);
        return this;
    }
    public BicepValue<BlobInventoryPolicyFilter> getFilters() {
        return this.filters;
    }

    public BlobInventoryPolicyDefinition setFilters(BicepValue<BlobInventoryPolicyFilter> filters) {
        this.filters.assign(filters);
        return this;
    }
    public BicepValue<ObjectType> getObjectType() {
        return this.objectType;
    }

    public BlobInventoryPolicyDefinition setObjectType(BicepValue<ObjectType> objectType) {
        this.objectType.assign(objectType);
        return this;
    }
    public BicepValue<Format> getFormat() {
        return this.format;
    }

    public BlobInventoryPolicyDefinition setFormat(BicepValue<Format> format) {
        this.format.assign(format);
        return this;
    }
    public BicepValue<ClientLogger> getLOGGER() {
        return this.lOGGER;
    }

    public BlobInventoryPolicyDefinition setLOGGER(BicepValue<ClientLogger> lOGGER) {
        this.lOGGER.assign(lOGGER);
        return this;
    }
}
