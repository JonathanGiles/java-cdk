// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.appconfiguration;

import java.util.List;
import java.time.OffsetDateTime;
import com.azure.provisioning.appconfiguration.models.EncryptionProperties;
import com.azure.provisioning.appconfiguration.models.CreateMode;
import com.azure.provisioning.appconfiguration.models.PublicNetworkAccess;
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
    private final BicepValue<List> privateEndpointConnections;
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
        resourceGroupName = BicepValue.defineProperty(this, "resourceGroupName", new String[] {  }, false, true, false, null);;
        configStoreName = BicepValue.defineProperty(this, "configStoreName", new String[] {  }, false, true, false, null);;
        provisioningState = BicepValue.defineProperty(this, "provisioningState", new String[] {  }, false, false, false, null);;
        creationDate = BicepValue.defineProperty(this, "creationDate", new String[] {  }, false, false, false, null);;
        endpoint = BicepValue.defineProperty(this, "endpoint", new String[] {  }, false, true, false, null);;
        encryption = BicepValue.defineProperty(this, "encryption", new String[] {  }, false, false, false, null);;
        privateEndpointConnections = BicepValue.defineProperty(this, "privateEndpointConnections", new String[] {  }, false, false, false, null);;
        publicNetworkAccess = BicepValue.defineProperty(this, "publicNetworkAccess", new String[] {  }, false, false, false, null);;
        disableLocalAuth = BicepValue.defineProperty(this, "disableLocalAuth", new String[] {  }, false, true, false, null);;
        softDeleteRetentionInDays = BicepValue.defineProperty(this, "softDeleteRetentionInDays", new String[] {  }, false, true, false, null);;
        enablePurgeProtection = BicepValue.defineProperty(this, "enablePurgeProtection", new String[] {  }, false, true, false, null);;
        createMode = BicepValue.defineProperty(this, "createMode", new String[] {  }, false, false, false, null);;
        location = BicepValue.defineProperty(this, "location", new String[] {  }, false, true, false, null);;
    }

    public BicepValue<String> getResourceGroupName() {
        return this.resourceGroupName;
    }

    public ConfigurationStoreResource setResourceGroupName(BicepValue<String> resourceGroupName) {
        this.resourceGroupName.assign(resourceGroupName);
        return this;
    }
    public BicepValue<String> getConfigStoreName() {
        return this.configStoreName;
    }

    public ConfigurationStoreResource setConfigStoreName(BicepValue<String> configStoreName) {
        this.configStoreName.assign(configStoreName);
        return this;
    }
    public BicepValue<ProvisioningState> getProvisioningState() {
        return this.provisioningState;
    }

    public ConfigurationStoreResource setProvisioningState(BicepValue<ProvisioningState> provisioningState) {
        this.provisioningState.assign(provisioningState);
        return this;
    }
    public BicepValue<OffsetDateTime> getCreationDate() {
        return this.creationDate;
    }

    public ConfigurationStoreResource setCreationDate(BicepValue<OffsetDateTime> creationDate) {
        this.creationDate.assign(creationDate);
        return this;
    }
    public BicepValue<String> getEndpoint() {
        return this.endpoint;
    }

    public ConfigurationStoreResource setEndpoint(BicepValue<String> endpoint) {
        this.endpoint.assign(endpoint);
        return this;
    }
    public BicepValue<EncryptionProperties> getEncryption() {
        return this.encryption;
    }

    public ConfigurationStoreResource setEncryption(BicepValue<EncryptionProperties> encryption) {
        this.encryption.assign(encryption);
        return this;
    }
    public BicepValue<List> getPrivateEndpointConnections() {
        return this.privateEndpointConnections;
    }

    public ConfigurationStoreResource setPrivateEndpointConnections(BicepValue<List> privateEndpointConnections) {
        this.privateEndpointConnections.assign(privateEndpointConnections);
        return this;
    }
    public BicepValue<PublicNetworkAccess> getPublicNetworkAccess() {
        return this.publicNetworkAccess;
    }

    public ConfigurationStoreResource setPublicNetworkAccess(BicepValue<PublicNetworkAccess> publicNetworkAccess) {
        this.publicNetworkAccess.assign(publicNetworkAccess);
        return this;
    }
    public BicepValue<Boolean> getDisableLocalAuth() {
        return this.disableLocalAuth;
    }

    public ConfigurationStoreResource setDisableLocalAuth(BicepValue<Boolean> disableLocalAuth) {
        this.disableLocalAuth.assign(disableLocalAuth);
        return this;
    }
    public BicepValue<Integer> getSoftDeleteRetentionInDays() {
        return this.softDeleteRetentionInDays;
    }

    public ConfigurationStoreResource setSoftDeleteRetentionInDays(BicepValue<Integer> softDeleteRetentionInDays) {
        this.softDeleteRetentionInDays.assign(softDeleteRetentionInDays);
        return this;
    }
    public BicepValue<Boolean> getEnablePurgeProtection() {
        return this.enablePurgeProtection;
    }

    public ConfigurationStoreResource setEnablePurgeProtection(BicepValue<Boolean> enablePurgeProtection) {
        this.enablePurgeProtection.assign(enablePurgeProtection);
        return this;
    }
    public BicepValue<CreateMode> getCreateMode() {
        return this.createMode;
    }

    public ConfigurationStoreResource setCreateMode(BicepValue<CreateMode> createMode) {
        this.createMode.assign(createMode);
        return this;
    }
    public BicepValue<String> getLocation() {
        return this.location;
    }

    public ConfigurationStoreResource setLocation(BicepValue<String> location) {
        this.location.assign(location);
        return this;
    }

    public static class ResourceVersions {

        public static final String V2024_05_01 = "2024-05-01";

        public static final String V2023_03_01 = "2023-03-01";

        public static final String V2022_05_01 = "2022-05-01";

        public static final String V2020_06_01 = "2020-06-01";

        public static final String V2019_10_01 = "2019-10-01";

    }
}
