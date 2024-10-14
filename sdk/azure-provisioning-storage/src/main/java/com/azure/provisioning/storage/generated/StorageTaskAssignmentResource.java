// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated;

import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.Resource;
import com.azure.provisioning.tmp.ResourceType;

public class StorageTaskAssignmentResource extends Resource {

    private final BicepValue<String> arg1;
    private final BicepValue<String> name;
    private final BicepValue<String> arg2;
    private final BicepValue<String> type;
    private final BicepValue<String> arg0;
    private final BicepValue<String> id;

    public StorageTaskAssignmentResource(String identifierName) {
        this(identifierName, null);
    }

    public StorageTaskAssignmentResource(String identifierName, String resourceVersion) {
        super(identifierName, new ResourceType("Microsoft.Storage/storageAccounts/storageTaskAssignments"), resourceVersion);
        arg1 = BicepValue.defineProperty(this, "arg1", new String[] { "temp", "arg1" }, false, false, false, null);
        name = BicepValue.defineProperty(this, "name", new String[] { "temp", "name" }, false, false, false, null);
        arg2 = BicepValue.defineProperty(this, "arg2", new String[] { "temp", "arg2" }, false, false, false, null);
        type = BicepValue.defineProperty(this, "type", new String[] { "temp", "type" }, false, false, false, null);
        arg0 = BicepValue.defineProperty(this, "arg0", new String[] { "temp", "arg0" }, false, false, false, null);
        id = BicepValue.defineProperty(this, "id", new String[] { "temp", "id" }, false, false, false, null);
    }

    public BicepValue<String> getArg1() {
        return this.arg1;
    }

    public StorageTaskAssignmentResource setArg1(BicepValue<String> arg1) {
        this.arg1.assign(arg1);
        return this;
    }

    public StorageTaskAssignmentResource setArg1(String arg1) {
        return this.setArg1(BicepValue.from(arg1));
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

    public BicepValue<String> getArg2() {
        return this.arg2;
    }

    public StorageTaskAssignmentResource setArg2(BicepValue<String> arg2) {
        this.arg2.assign(arg2);
        return this;
    }

    public StorageTaskAssignmentResource setArg2(String arg2) {
        return this.setArg2(BicepValue.from(arg2));
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

    public BicepValue<String> getArg0() {
        return this.arg0;
    }

    public StorageTaskAssignmentResource setArg0(BicepValue<String> arg0) {
        this.arg0.assign(arg0);
        return this;
    }

    public StorageTaskAssignmentResource setArg0(String arg0) {
        return this.setArg0(BicepValue.from(arg0));
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
