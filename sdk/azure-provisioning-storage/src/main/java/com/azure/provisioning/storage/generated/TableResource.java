// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated;

import java.util.List;
import com.azure.provisioning.storage.generated.models.TableSignedIdentifier;
import com.azure.provisioning.BicepList;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.Resource;
import com.azure.provisioning.tmp.ResourceType;

public class TableResource extends Resource {

    private final BicepValue<String> arg1;
    private final BicepValue<String> name;
    private final BicepValue<String> arg2;
    private final BicepList<TableSignedIdentifier> signedIdentifiers;
    private final BicepValue<String> tableName;
    private final BicepValue<String> type;
    private final BicepValue<String> arg0;
    private final BicepValue<String> id;

    public TableResource(String identifierName) {
        this(identifierName, null);
    }

    public TableResource(String identifierName, String resourceVersion) {
        super(identifierName, new ResourceType("Microsoft.Storage/storageAccounts/tableServices/tables"), resourceVersion);
        arg1 = BicepValue.defineProperty(this, "arg1", new String[] { "temp", "arg1" }, false, false, false, null);
        name = BicepValue.defineProperty(this, "name", new String[] { "temp", "name" }, false, false, false, null);
        arg2 = BicepValue.defineProperty(this, "arg2", new String[] { "temp", "arg2" }, false, false, false, null);
        signedIdentifiers = BicepList.defineProperty(this, "signedIdentifiers", new String[] { "temp", "signedIdentifiers" }, false, false);
        tableName = BicepValue.defineProperty(this, "tableName", new String[] { "temp", "tableName" }, false, false, false, null);
        type = BicepValue.defineProperty(this, "type", new String[] { "temp", "type" }, false, false, false, null);
        arg0 = BicepValue.defineProperty(this, "arg0", new String[] { "temp", "arg0" }, false, false, false, null);
        id = BicepValue.defineProperty(this, "id", new String[] { "temp", "id" }, false, false, false, null);
    }

    public BicepValue<String> getArg1() {
        return this.arg1;
    }

    public TableResource setArg1(BicepValue<String> arg1) {
        this.arg1.assign(arg1);
        return this;
    }

    public TableResource setArg1(String arg1) {
        return this.setArg1(BicepValue.from(arg1));
    }

    public BicepValue<String> getName() {
        return this.name;
    }

    public TableResource setName(BicepValue<String> name) {
        this.name.assign(name);
        return this;
    }

    public TableResource setName(String name) {
        return this.setName(BicepValue.from(name));
    }

    public BicepValue<String> getArg2() {
        return this.arg2;
    }

    public TableResource setArg2(BicepValue<String> arg2) {
        this.arg2.assign(arg2);
        return this;
    }

    public TableResource setArg2(String arg2) {
        return this.setArg2(BicepValue.from(arg2));
    }

    public BicepList<TableSignedIdentifier> getSignedIdentifiers() {
        return this.signedIdentifiers;
    }

    public TableResource setSignedIdentifiers(BicepValue<List<TableSignedIdentifier>> signedIdentifiers) {
        this.signedIdentifiers.assign(signedIdentifiers);
        return this;
    }

    public TableResource setSignedIdentifiers(List<TableSignedIdentifier> signedIdentifiers) {
        return this.setSignedIdentifiers(BicepValue.from(signedIdentifiers));
    }

    public BicepValue<String> getTableName() {
        return this.tableName;
    }

    public TableResource setTableName(BicepValue<String> tableName) {
        this.tableName.assign(tableName);
        return this;
    }

    public TableResource setTableName(String tableName) {
        return this.setTableName(BicepValue.from(tableName));
    }

    public BicepValue<String> getType() {
        return this.type;
    }

    public TableResource setType(BicepValue<String> type) {
        this.type.assign(type);
        return this;
    }

    public TableResource setType(String type) {
        return this.setType(BicepValue.from(type));
    }

    public BicepValue<String> getArg0() {
        return this.arg0;
    }

    public TableResource setArg0(BicepValue<String> arg0) {
        this.arg0.assign(arg0);
        return this;
    }

    public TableResource setArg0(String arg0) {
        return this.setArg0(BicepValue.from(arg0));
    }

    public BicepValue<String> getId() {
        return this.id;
    }

    public TableResource setId(BicepValue<String> id) {
        this.id.assign(id);
        return this;
    }

    public TableResource setId(String id) {
        return this.setId(BicepValue.from(id));
    }

}
