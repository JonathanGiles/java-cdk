// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated;

import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.Resource;
import com.azure.provisioning.tmp.ResourceType;

public class StorageAccountResource extends Resource {

    private final BicepValue<String> resourceGroupName;
    private final BicepValue<String> accountName;

    public StorageAccountResource(String identifierName) {
        this(identifierName, null);
    }

    public StorageAccountResource(String identifierName, String resourceVersion) {
        super(identifierName, new ResourceType("Microsoft.Storage/storageAccounts"), resourceVersion);
        resourceGroupName = BicepValue.defineProperty(this, "resourceGroupName", new String[] { "temp", "resourceGroupName" }, false, false, false, null);
        accountName = BicepValue.defineProperty(this, "accountName", new String[] { "temp", "accountName" }, false, false, false, null);
    }

    public BicepValue<String> getResourceGroupName() {
        return this.resourceGroupName;
    }

    public StorageAccountResource setResourceGroupName(BicepValue<String> resourceGroupName) {
        this.resourceGroupName.assign(resourceGroupName);
        return this;
    }

    public StorageAccountResource setResourceGroupName(String resourceGroupName) {
        return this.setResourceGroupName(BicepValue.from(resourceGroupName));
    }

    public BicepValue<String> getAccountName() {
        return this.accountName;
    }

    public StorageAccountResource setAccountName(BicepValue<String> accountName) {
        this.accountName.assign(accountName);
        return this;
    }

    public StorageAccountResource setAccountName(String accountName) {
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

        public static final String V2021_08_01 = "2021-08-01";

        public static final String V2021_06_01 = "2021-06-01";

        public static final String V2021_05_01 = "2021-05-01";

        public static final String V2021_04_01 = "2021-04-01";

        public static final String V2021_02_01 = "2021-02-01";

        public static final String V2021_01_01 = "2021-01-01";

        public static final String V2019_06_01 = "2019-06-01";

        public static final String V2019_04_01 = "2019-04-01";

        public static final String V2018_11_01 = "2018-11-01";

        public static final String V2018_07_01 = "2018-07-01";

        public static final String V2018_02_01 = "2018-02-01";

        public static final String V2017_10_01 = "2017-10-01";

        public static final String V2017_06_01 = "2017-06-01";

        public static final String V2016_12_01 = "2016-12-01";

        public static final String V2016_05_01 = "2016-05-01";

        public static final String V2016_01_01 = "2016-01-01";

        public static final String V2015_06_15 = "2015-06-15";

    }
}
