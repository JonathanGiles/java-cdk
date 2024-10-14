// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated.models;

import com.azure.core.util.logging.ClientLogger;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class PermissionScope extends ProvisioningConstruct {

    private final BicepValue<String> service;
    private final BicepValue<String> resourceName;
    private final BicepValue<String> permissions;
    private final BicepValue<ClientLogger> lOGGER;

    public PermissionScope() {
        service = BicepValue.defineProperty(this, "service", new String[] { "temp", "service" }, null);
        resourceName = BicepValue.defineProperty(this, "resourceName", new String[] { "temp", "resourceName" }, null);
        permissions = BicepValue.defineProperty(this, "permissions", new String[] { "temp", "permissions" }, null);
        lOGGER = BicepValue.defineProperty(this, "lOGGER", new String[] { "temp", "lOGGER" }, null);
    }

    public BicepValue<String> getService() {
        return this.service;
    }

    public PermissionScope setService(BicepValue<String> service) {
        this.service.assign(service);
        return this;
    }
    public BicepValue<String> getResourceName() {
        return this.resourceName;
    }

    public PermissionScope setResourceName(BicepValue<String> resourceName) {
        this.resourceName.assign(resourceName);
        return this;
    }
    public BicepValue<String> getPermissions() {
        return this.permissions;
    }

    public PermissionScope setPermissions(BicepValue<String> permissions) {
        this.permissions.assign(permissions);
        return this;
    }
    public BicepValue<ClientLogger> getLOGGER() {
        return this.lOGGER;
    }

    public PermissionScope setLOGGER(BicepValue<ClientLogger> lOGGER) {
        this.lOGGER.assign(lOGGER);
        return this;
    }
}
