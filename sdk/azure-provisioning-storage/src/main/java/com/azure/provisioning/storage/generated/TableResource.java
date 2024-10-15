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

    private final BicepValue<String> resourceGroupName;
    private final BicepValue<String> id;
    private final BicepValue<String> type;
    private final BicepList<TableSignedIdentifier> signedIdentifiers;
    private final BicepValue<String> tableName;
    private final BicepValue<String> name;
    private final BicepValue<String> accountName;

    public TableResource(String identifierName) {
        this(identifierName, null);
    }

    public TableResource(String identifierName, String resourceVersion) {
        super(identifierName, new ResourceType("Microsoft.Storage/storageAccounts/tableServices/tables"), resourceVersion);
        resourceGroupName = BicepValue.defineProperty(this, "resourceGroupName", new String[] { "temp", "resourceGroupName" }, false, false, false, null);
        id = BicepValue.defineProperty(this, "id", new String[] { "temp", "id" }, false, false, false, null);
        type = BicepValue.defineProperty(this, "type", new String[] { "temp", "type" }, false, false, false, null);
        signedIdentifiers = BicepList.defineProperty(this, "signedIdentifiers", new String[] { "temp", "signedIdentifiers" }, false, false);
        tableName = BicepValue.defineProperty(this, "tableName", new String[] { "temp", "tableName" }, false, false, false, null);
        name = BicepValue.defineProperty(this, "name", new String[] { "temp", "name" }, false, false, false, null);
        accountName = BicepValue.defineProperty(this, "accountName", new String[] { "temp", "accountName" }, false, false, false, null);
    }

    public BicepValue<String> getResourceGroupName() {
        return this.resourceGroupName;
    }

    public TableResource setResourceGroupName(BicepValue<String> resourceGroupName) {
        this.resourceGroupName.assign(resourceGroupName);
        return this;
    }

    public TableResource setResourceGroupName(String resourceGroupName) {
        return this.setResourceGroupName(BicepValue.from(resourceGroupName));
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

    public BicepValue<String> getAccountName() {
        return this.accountName;
    }

    public TableResource setAccountName(BicepValue<String> accountName) {
        this.accountName.assign(accountName);
        return this;
    }

    public TableResource setAccountName(String accountName) {
        return this.setAccountName(BicepValue.from(accountName));
    }

}
