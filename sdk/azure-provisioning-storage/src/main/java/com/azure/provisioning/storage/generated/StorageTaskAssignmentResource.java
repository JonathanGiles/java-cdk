// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated;

import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.Resource;
import com.azure.provisioning.tmp.ResourceType;

public class StorageTaskAssignmentResource extends Resource {

    private final BicepValue<String> resourceGroupName;
    private final BicepValue<String> id;
    private final BicepValue<String> type;
    private final BicepValue<String> storageTaskAssignmentName;
    private final BicepValue<String> name;
    private final BicepValue<String> accountName;

    public StorageTaskAssignmentResource(String identifierName) {
        this(identifierName, null);
    }

    public StorageTaskAssignmentResource(String identifierName, String resourceVersion) {
        super(identifierName, new ResourceType("Microsoft.Storage/storageAccounts/storageTaskAssignments"), resourceVersion);
        resourceGroupName = BicepValue.defineProperty(this, "resourceGroupName", new String[] { "temp", "resourceGroupName" }, false, false, false, null);
        id = BicepValue.defineProperty(this, "id", new String[] { "temp", "id" }, false, false, false, null);
        type = BicepValue.defineProperty(this, "type", new String[] { "temp", "type" }, false, false, false, null);
        storageTaskAssignmentName = BicepValue.defineProperty(this, "storageTaskAssignmentName", new String[] { "temp", "storageTaskAssignmentName" }, false, false, false, null);
        name = BicepValue.defineProperty(this, "name", new String[] { "temp", "name" }, false, false, false, null);
        accountName = BicepValue.defineProperty(this, "accountName", new String[] { "temp", "accountName" }, false, false, false, null);
    }

    public BicepValue<String> getResourceGroupName() {
        return this.resourceGroupName;
    }

    public StorageTaskAssignmentResource setResourceGroupName(BicepValue<String> resourceGroupName) {
        this.resourceGroupName.assign(resourceGroupName);
        return this;
    }

    public StorageTaskAssignmentResource setResourceGroupName(String resourceGroupName) {
        return this.setResourceGroupName(BicepValue.from(resourceGroupName));
    }

    public BicepValue<String> getId() {
        return this.id;
    }

    public StorageTaskAssignmentResource setId(BicepValue<String> id) {
        this.id.assign(id);
        return this;
    }

    public StorageTaskAssignmentResource setId(String id) {
        return this.setId(BicepValue.from(id));
    }

    public BicepValue<String> getType() {
        return this.type;
    }

    public StorageTaskAssignmentResource setType(BicepValue<String> type) {
        this.type.assign(type);
        return this;
    }

    public StorageTaskAssignmentResource setType(String type) {
        return this.setType(BicepValue.from(type));
    }

    public BicepValue<String> getStorageTaskAssignmentName() {
        return this.storageTaskAssignmentName;
    }

    public StorageTaskAssignmentResource setStorageTaskAssignmentName(BicepValue<String> storageTaskAssignmentName) {
        this.storageTaskAssignmentName.assign(storageTaskAssignmentName);
        return this;
    }

    public StorageTaskAssignmentResource setStorageTaskAssignmentName(String storageTaskAssignmentName) {
        return this.setStorageTaskAssignmentName(BicepValue.from(storageTaskAssignmentName));
    }

    public BicepValue<String> getName() {
        return this.name;
    }

    public StorageTaskAssignmentResource setName(BicepValue<String> name) {
        this.name.assign(name);
        return this;
    }

    public StorageTaskAssignmentResource setName(String name) {
        return this.setName(BicepValue.from(name));
    }

    public BicepValue<String> getAccountName() {
        return this.accountName;
    }

    public StorageTaskAssignmentResource setAccountName(BicepValue<String> accountName) {
        this.accountName.assign(accountName);
        return this;
    }

    public StorageTaskAssignmentResource setAccountName(String accountName) {
        return this.setAccountName(BicepValue.from(accountName));
    }


    public static class ResourceVersions {

        public static final String V2024_01_01 = "2024-01-01";

        public static final String V2023_05_01 = "2023-05-01";

        public static final String V2023_04_01 = "2023-04-01";

        public static final String V2023_01_01 = "2023-01-01";

        public static final String V2022_09_01 = "2022-09-01";

        public static final String V2022_05_01 = "2022-05-01";

        public static final String V2021_09_01 = "2021-09-01";

    }
}
