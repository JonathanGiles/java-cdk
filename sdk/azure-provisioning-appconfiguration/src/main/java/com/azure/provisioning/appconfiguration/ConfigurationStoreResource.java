// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.appconfiguration;

import java.util.List;
import java.time.OffsetDateTime;
import com.azure.provisioning.appconfiguration.models.EncryptionProperties;
import com.azure.provisioning.appconfiguration.models.CreateMode;
import com.azure.provisioning.appconfiguration.models.PublicNetworkAccess;
import com.azure.provisioning.appconfiguration.models.PrivateEndpointConnectionReference;
import com.azure.provisioning.appconfiguration.models.ProvisioningState;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.BicepList;
import com.azure.provisioning.BicepDictionary;
import com.azure.provisioning.primitives.Resource;
import com.azure.provisioning.tmp.ResourceType;

public class ConfigurationStoreResource extends Resource {

    private final BicepValue<String> resourceGroupName;
    private final BicepValue<String> configStoreName;
    private final BicepValue<ProvisioningState> provisioningState;
    private final BicepValue<OffsetDateTime> creationDate;
    private final BicepValue<String> endpoint;
    private final BicepValue<EncryptionProperties> encryption;
    private final BicepList<PrivateEndpointConnectionReference> privateEndpointConnections;
    private final BicepValue<PublicNetworkAccess> publicNetworkAccess;
    private final BicepValue<Boolean> disableLocalAuth;
    private final BicepValue<Integer> softDeleteRetentionInDays;
    private final BicepValue<Boolean> enablePurgeProtection;
    private final BicepValue<CreateMode> createMode;
    private final BicepValue<String> location;

    public ConfigurationStoreResource(String identifierName) {
        this(identifierName, null);
    }

    public ConfigurationStoreResource(String identifierName, String resourceVersion) {
        super(identifierName, new ResourceType("Microsoft.AppConfiguration/configurationStores"), resourceVersion);
        resourceGroupName = BicepValue.defineProperty(this, "resourceGroupName", new String[] { "temp", "resourceGroupName" }, false, false, false, null);
        configStoreName = BicepValue.defineProperty(this, "configStoreName", new String[] { "temp", "configStoreName" }, false, false, false, null);
        provisioningState = BicepValue.defineProperty(this, "provisioningState", new String[] { "temp", "provisioningState" }, false, false, false, null);
        creationDate = BicepValue.defineProperty(this, "creationDate", new String[] { "temp", "creationDate" }, false, false, false, null);
        endpoint = BicepValue.defineProperty(this, "endpoint", new String[] { "temp", "endpoint" }, false, false, false, null);
        encryption = BicepValue.defineProperty(this, "encryption", new String[] { "temp", "encryption" }, false, false, false, null);
        privateEndpointConnections = BicepList.defineProperty(this, "privateEndpointConnections", new String[] { "temp", "privateEndpointConnections" }, false, false);
        publicNetworkAccess = BicepValue.defineProperty(this, "publicNetworkAccess", new String[] { "temp", "publicNetworkAccess" }, false, false, false, null);
        disableLocalAuth = BicepValue.defineProperty(this, "disableLocalAuth", new String[] { "temp", "disableLocalAuth" }, false, false, false, null);
        softDeleteRetentionInDays = BicepValue.defineProperty(this, "softDeleteRetentionInDays", new String[] { "temp", "softDeleteRetentionInDays" }, false, false, false, null);
        enablePurgeProtection = BicepValue.defineProperty(this, "enablePurgeProtection", new String[] { "temp", "enablePurgeProtection" }, false, false, false, null);
        createMode = BicepValue.defineProperty(this, "createMode", new String[] { "temp", "createMode" }, false, false, false, null);
        location = BicepValue.defineProperty(this, "location", new String[] { "temp", "location" }, false, false, false, null);
    }

    public BicepValue<String> getResourceGroupName() {
        return this.resourceGroupName;
    }

    public ConfigurationStoreResource setResourceGroupName(BicepValue<String> resourceGroupName) {
        this.resourceGroupName.assign(resourceGroupName);
        return this;
    }

    public ConfigurationStoreResource setResourceGroupName(String resourceGroupName) {
        return this.setResourceGroupName(BicepValue.from(resourceGroupName));
    }

    public BicepValue<String> getConfigStoreName() {
        return this.configStoreName;
    }

    public ConfigurationStoreResource setConfigStoreName(BicepValue<String> configStoreName) {
        this.configStoreName.assign(configStoreName);
        return this;
    }

    public ConfigurationStoreResource setConfigStoreName(String configStoreName) {
        return this.setConfigStoreName(BicepValue.from(configStoreName));
    }

    public BicepValue<ProvisioningState> getProvisioningState() {
        return this.provisioningState;
    }

    public ConfigurationStoreResource setProvisioningState(BicepValue<ProvisioningState> provisioningState) {
        this.provisioningState.assign(provisioningState);
        return this;
    }

    public ConfigurationStoreResource setProvisioningState(ProvisioningState provisioningState) {
        return this.setProvisioningState(BicepValue.from(provisioningState));
    }

    public BicepValue<OffsetDateTime> getCreationDate() {
        return this.creationDate;
    }

    public ConfigurationStoreResource setCreationDate(BicepValue<OffsetDateTime> creationDate) {
        this.creationDate.assign(creationDate);
        return this;
    }

    public ConfigurationStoreResource setCreationDate(OffsetDateTime creationDate) {
        return this.setCreationDate(BicepValue.from(creationDate));
    }

    public BicepValue<String> getEndpoint() {
        return this.endpoint;
    }

    public ConfigurationStoreResource setEndpoint(BicepValue<String> endpoint) {
        this.endpoint.assign(endpoint);
        return this;
    }

    public ConfigurationStoreResource setEndpoint(String endpoint) {
        return this.setEndpoint(BicepValue.from(endpoint));
    }

    public BicepValue<EncryptionProperties> getEncryption() {
        return this.encryption;
    }

    public ConfigurationStoreResource setEncryption(BicepValue<EncryptionProperties> encryption) {
        this.encryption.assign(encryption);
        return this;
    }

    public ConfigurationStoreResource setEncryption(EncryptionProperties encryption) {
        return this.setEncryption(BicepValue.from(encryption));
    }

    public BicepList<PrivateEndpointConnectionReference> getPrivateEndpointConnections() {
        return this.privateEndpointConnections;
    }

    public ConfigurationStoreResource setPrivateEndpointConnections(BicepValue<List<PrivateEndpointConnectionReference>> privateEndpointConnections) {
        this.privateEndpointConnections.assign(privateEndpointConnections);
        return this;
    }

    public ConfigurationStoreResource setPrivateEndpointConnections(List<PrivateEndpointConnectionReference> privateEndpointConnections) {
        return this.setPrivateEndpointConnections(BicepValue.from(privateEndpointConnections));
    }

    public BicepValue<PublicNetworkAccess> getPublicNetworkAccess() {
        return this.publicNetworkAccess;
    }

    public ConfigurationStoreResource setPublicNetworkAccess(BicepValue<PublicNetworkAccess> publicNetworkAccess) {
        this.publicNetworkAccess.assign(publicNetworkAccess);
        return this;
    }

    public ConfigurationStoreResource setPublicNetworkAccess(PublicNetworkAccess publicNetworkAccess) {
        return this.setPublicNetworkAccess(BicepValue.from(publicNetworkAccess));
    }

    public BicepValue<Boolean> getDisableLocalAuth() {
        return this.disableLocalAuth;
    }

    public ConfigurationStoreResource setDisableLocalAuth(BicepValue<Boolean> disableLocalAuth) {
        this.disableLocalAuth.assign(disableLocalAuth);
        return this;
    }

    public ConfigurationStoreResource setDisableLocalAuth(Boolean disableLocalAuth) {
        return this.setDisableLocalAuth(BicepValue.from(disableLocalAuth));
    }

    public BicepValue<Integer> getSoftDeleteRetentionInDays() {
        return this.softDeleteRetentionInDays;
    }

    public ConfigurationStoreResource setSoftDeleteRetentionInDays(BicepValue<Integer> softDeleteRetentionInDays) {
        this.softDeleteRetentionInDays.assign(softDeleteRetentionInDays);
        return this;
    }

    public ConfigurationStoreResource setSoftDeleteRetentionInDays(Integer softDeleteRetentionInDays) {
        return this.setSoftDeleteRetentionInDays(BicepValue.from(softDeleteRetentionInDays));
    }

    public BicepValue<Boolean> getEnablePurgeProtection() {
        return this.enablePurgeProtection;
    }

    public ConfigurationStoreResource setEnablePurgeProtection(BicepValue<Boolean> enablePurgeProtection) {
        this.enablePurgeProtection.assign(enablePurgeProtection);
        return this;
    }

    public ConfigurationStoreResource setEnablePurgeProtection(Boolean enablePurgeProtection) {
        return this.setEnablePurgeProtection(BicepValue.from(enablePurgeProtection));
    }

    public BicepValue<CreateMode> getCreateMode() {
        return this.createMode;
    }

    public ConfigurationStoreResource setCreateMode(BicepValue<CreateMode> createMode) {
        this.createMode.assign(createMode);
        return this;
    }

    public ConfigurationStoreResource setCreateMode(CreateMode createMode) {
        return this.setCreateMode(BicepValue.from(createMode));
    }

    public BicepValue<String> getLocation() {
        return this.location;
    }

    public ConfigurationStoreResource setLocation(BicepValue<String> location) {
        this.location.assign(location);
        return this;
    }

    public ConfigurationStoreResource setLocation(String location) {
        return this.setLocation(BicepValue.from(location));
    }


    public static class ResourceVersions {

        public static final String V2024_05_01 = "2024-05-01";

        public static final String V2023_03_01 = "2023-03-01";

        public static final String V2022_05_01 = "2022-05-01";

        public static final String V2020_06_01 = "2020-06-01";

        public static final String V2019_10_01 = "2019-10-01";

    }
}
