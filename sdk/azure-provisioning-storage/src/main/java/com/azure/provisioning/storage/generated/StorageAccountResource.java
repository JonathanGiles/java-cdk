// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated;

import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.Resource;
import com.azure.provisioning.tmp.ResourceType;

public class StorageAccountResource extends Resource {

    private final BicepValue<String> arg1;
    private final BicepValue<String> arg0;

    public StorageAccountResource(String identifierName) {
        this(identifierName, null);
    }

    public StorageAccountResource(String identifierName, String resourceVersion) {
        super(identifierName, new ResourceType("Microsoft.Storage/storageAccounts"), resourceVersion);
        arg1 = BicepValue.defineProperty(this, "arg1", new String[] { "temp", "arg1" }, false, false, false, null);
        arg0 = BicepValue.defineProperty(this, "arg0", new String[] { "temp", "arg0" }, false, false, false, null);
    }

    public BicepValue<String> getArg1() {
        return this.arg1;
    }

    public StorageAccountResource setArg1(BicepValue<String> arg1) {
        this.arg1.assign(arg1);
        return this;
    }

    public StorageAccountResource setArg1(String arg1) {
        return this.setArg1(BicepValue.from(arg1));
    }

    public BicepValue<String> getArg0() {
        return this.arg0;
    }

    public StorageAccountResource setArg0(BicepValue<String> arg0) {
        this.arg0.assign(arg0);
        return this;
    }

    public StorageAccountResource setArg0(String arg0) {
        return this.setArg0(BicepValue.from(arg0));
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
