// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated;

import com.azure.provisioning.storage.generated.models.LeaseStatus;
import com.azure.provisioning.BicepDictionary;
import java.time.OffsetDateTime;
import com.azure.provisioning.storage.generated.models.PublicAccess;
import com.azure.provisioning.storage.generated.models.ImmutableStorageWithVersioning;
import com.azure.provisioning.storage.generated.models.LeaseDuration;
import java.util.Map;
import com.azure.provisioning.storage.generated.models.LeaseState;
import java.lang.String;
import com.azure.provisioning.storage.generated.models.LegalHoldProperties;
import com.azure.provisioning.storage.generated.models.ImmutabilityPolicyProperties;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.Resource;
import com.azure.provisioning.tmp.ResourceType;

public class BlobContainerResource extends Resource {

    private final BicepValue<Boolean> enableNfsV3AllSquash;
    private final BicepValue<Boolean> hasLegalHold;
    private final BicepValue<Integer> remainingRetentionDays;
    private final BicepDictionary<String> metadata;
    private final BicepValue<String> type;
    private final BicepValue<String> version;
    private final BicepValue<LeaseDuration> leaseDuration;
    private final BicepValue<OffsetDateTime> deletedTime;
    private final BicepValue<PublicAccess> publicAccess;
    private final BicepValue<String> id;
    private final BicepValue<String> arg1;
    private final BicepValue<LegalHoldProperties> legalHold;
    private final BicepValue<String> name;
    private final BicepValue<String> etag;
    private final BicepValue<OffsetDateTime> lastModifiedTime;
    private final BicepValue<LeaseStatus> leaseStatus;
    private final BicepValue<Boolean> enableNfsV3RootSquash;
    private final BicepValue<Boolean> deleted;
    private final BicepValue<LeaseState> leaseState;
    private final BicepValue<ImmutableStorageWithVersioning> immutableStorageWithVersioning;
    private final BicepValue<ImmutabilityPolicyProperties> immutabilityPolicy;
    private final BicepValue<String> arg0;
    private final BicepValue<String> arg2;
    private final BicepValue<Boolean> denyEncryptionScopeOverride;
    private final BicepValue<String> defaultEncryptionScope;
    private final BicepValue<Boolean> hasImmutabilityPolicy;

    public BlobContainerResource(String identifierName) {
        this(identifierName, null);
    }

    public BlobContainerResource(String identifierName, String resourceVersion) {
        super(identifierName, new ResourceType("Microsoft.Storage/storageAccounts/blobServices/containers"), resourceVersion);
        enableNfsV3AllSquash = BicepValue.defineProperty(this, "enableNfsV3AllSquash", new String[] { "temp", "enableNfsV3AllSquash" }, false, false, false, null);
        hasLegalHold = BicepValue.defineProperty(this, "hasLegalHold", new String[] { "temp", "hasLegalHold" }, false, false, false, null);
        remainingRetentionDays = BicepValue.defineProperty(this, "remainingRetentionDays", new String[] { "temp", "remainingRetentionDays" }, false, false, false, null);
        metadata = BicepDictionary.defineProperty(this, "metadata", new String[] { "temp", "metadata" }, false, false);
        type = BicepValue.defineProperty(this, "type", new String[] { "temp", "type" }, false, false, false, null);
        version = BicepValue.defineProperty(this, "version", new String[] { "temp", "version" }, false, false, false, null);
        leaseDuration = BicepValue.defineProperty(this, "leaseDuration", new String[] { "temp", "leaseDuration" }, false, false, false, null);
        deletedTime = BicepValue.defineProperty(this, "deletedTime", new String[] { "temp", "deletedTime" }, false, false, false, null);
        publicAccess = BicepValue.defineProperty(this, "publicAccess", new String[] { "temp", "publicAccess" }, false, false, false, null);
        id = BicepValue.defineProperty(this, "id", new String[] { "temp", "id" }, false, false, false, null);
        arg1 = BicepValue.defineProperty(this, "arg1", new String[] { "temp", "arg1" }, false, false, false, null);
        legalHold = BicepValue.defineProperty(this, "legalHold", new String[] { "temp", "legalHold" }, false, false, false, null);
        name = BicepValue.defineProperty(this, "name", new String[] { "temp", "name" }, false, false, false, null);
        etag = BicepValue.defineProperty(this, "etag", new String[] { "temp", "etag" }, false, false, false, null);
        lastModifiedTime = BicepValue.defineProperty(this, "lastModifiedTime", new String[] { "temp", "lastModifiedTime" }, false, false, false, null);
        leaseStatus = BicepValue.defineProperty(this, "leaseStatus", new String[] { "temp", "leaseStatus" }, false, false, false, null);
        enableNfsV3RootSquash = BicepValue.defineProperty(this, "enableNfsV3RootSquash", new String[] { "temp", "enableNfsV3RootSquash" }, false, false, false, null);
        deleted = BicepValue.defineProperty(this, "deleted", new String[] { "temp", "deleted" }, false, false, false, null);
        leaseState = BicepValue.defineProperty(this, "leaseState", new String[] { "temp", "leaseState" }, false, false, false, null);
        immutableStorageWithVersioning = BicepValue.defineProperty(this, "immutableStorageWithVersioning", new String[] { "temp", "immutableStorageWithVersioning" }, false, false, false, null);
        immutabilityPolicy = BicepValue.defineProperty(this, "immutabilityPolicy", new String[] { "temp", "immutabilityPolicy" }, false, false, false, null);
        arg0 = BicepValue.defineProperty(this, "arg0", new String[] { "temp", "arg0" }, false, false, false, null);
        arg2 = BicepValue.defineProperty(this, "arg2", new String[] { "temp", "arg2" }, false, false, false, null);
        denyEncryptionScopeOverride = BicepValue.defineProperty(this, "denyEncryptionScopeOverride", new String[] { "temp", "denyEncryptionScopeOverride" }, false, false, false, null);
        defaultEncryptionScope = BicepValue.defineProperty(this, "defaultEncryptionScope", new String[] { "temp", "defaultEncryptionScope" }, false, false, false, null);
        hasImmutabilityPolicy = BicepValue.defineProperty(this, "hasImmutabilityPolicy", new String[] { "temp", "hasImmutabilityPolicy" }, false, false, false, null);
    }

    public BicepValue<Boolean> getEnableNfsV3AllSquash() {
        return this.enableNfsV3AllSquash;
    }

    public BlobContainerResource setEnableNfsV3AllSquash(BicepValue<Boolean> enableNfsV3AllSquash) {
        this.enableNfsV3AllSquash.assign(enableNfsV3AllSquash);
        return this;
    }

    public BlobContainerResource setEnableNfsV3AllSquash(Boolean enableNfsV3AllSquash) {
        return this.setEnableNfsV3AllSquash(BicepValue.from(enableNfsV3AllSquash));
    }

    public BicepValue<Boolean> getHasLegalHold() {
        return this.hasLegalHold;
    }

    public BlobContainerResource setHasLegalHold(BicepValue<Boolean> hasLegalHold) {
        this.hasLegalHold.assign(hasLegalHold);
        return this;
    }

    public BlobContainerResource setHasLegalHold(Boolean hasLegalHold) {
        return this.setHasLegalHold(BicepValue.from(hasLegalHold));
    }

    public BicepValue<Integer> getRemainingRetentionDays() {
        return this.remainingRetentionDays;
    }

    public BlobContainerResource setRemainingRetentionDays(BicepValue<Integer> remainingRetentionDays) {
        this.remainingRetentionDays.assign(remainingRetentionDays);
        return this;
    }

    public BlobContainerResource setRemainingRetentionDays(Integer remainingRetentionDays) {
        return this.setRemainingRetentionDays(BicepValue.from(remainingRetentionDays));
    }

    public BicepDictionary<String> getMetadata() {
        return this.metadata;
    }

    public BlobContainerResource setMetadata(BicepValue<Map<String,String>> metadata) {
        this.metadata.assign(metadata);
        return this;
    }

    public BlobContainerResource setMetadata(Map<String,String> metadata) {
        return this.setMetadata(BicepValue.from(metadata));
    }

    public BicepValue<String> getType() {
        return this.type;
    }

    public BlobContainerResource setType(BicepValue<String> type) {
        this.type.assign(type);
        return this;
    }

    public BlobContainerResource setType(String type) {
        return this.setType(BicepValue.from(type));
    }

    public BicepValue<String> getVersion() {
        return this.version;
    }

    public BlobContainerResource setVersion(BicepValue<String> version) {
        this.version.assign(version);
        return this;
    }

    public BlobContainerResource setVersion(String version) {
        return this.setVersion(BicepValue.from(version));
    }

    public BicepValue<LeaseDuration> getLeaseDuration() {
        return this.leaseDuration;
    }

    public BlobContainerResource setLeaseDuration(BicepValue<LeaseDuration> leaseDuration) {
        this.leaseDuration.assign(leaseDuration);
        return this;
    }

    public BlobContainerResource setLeaseDuration(LeaseDuration leaseDuration) {
        return this.setLeaseDuration(BicepValue.from(leaseDuration));
    }

    public BicepValue<OffsetDateTime> getDeletedTime() {
        return this.deletedTime;
    }

    public BlobContainerResource setDeletedTime(BicepValue<OffsetDateTime> deletedTime) {
        this.deletedTime.assign(deletedTime);
        return this;
    }

    public BlobContainerResource setDeletedTime(OffsetDateTime deletedTime) {
        return this.setDeletedTime(BicepValue.from(deletedTime));
    }

    public BicepValue<PublicAccess> getPublicAccess() {
        return this.publicAccess;
    }

    public BlobContainerResource setPublicAccess(BicepValue<PublicAccess> publicAccess) {
        this.publicAccess.assign(publicAccess);
        return this;
    }

    public BlobContainerResource setPublicAccess(PublicAccess publicAccess) {
        return this.setPublicAccess(BicepValue.from(publicAccess));
    }

    public BicepValue<String> getId() {
        return this.id;
    }

    public BlobContainerResource setId(BicepValue<String> id) {
        this.id.assign(id);
        return this;
    }

    public BlobContainerResource setId(String id) {
        return this.setId(BicepValue.from(id));
    }

    public BicepValue<String> getArg1() {
        return this.arg1;
    }

    public BlobContainerResource setArg1(BicepValue<String> arg1) {
        this.arg1.assign(arg1);
        return this;
    }

    public BlobContainerResource setArg1(String arg1) {
        return this.setArg1(BicepValue.from(arg1));
    }

    public BicepValue<LegalHoldProperties> getLegalHold() {
        return this.legalHold;
    }

    public BlobContainerResource setLegalHold(BicepValue<LegalHoldProperties> legalHold) {
        this.legalHold.assign(legalHold);
        return this;
    }

    public BlobContainerResource setLegalHold(LegalHoldProperties legalHold) {
        return this.setLegalHold(BicepValue.from(legalHold));
    }

    public BicepValue<String> getName() {
        return this.name;
    }

    public BlobContainerResource setName(BicepValue<String> name) {
        this.name.assign(name);
        return this;
    }

    public BlobContainerResource setName(String name) {
        return this.setName(BicepValue.from(name));
    }

    public BicepValue<String> getEtag() {
        return this.etag;
    }

    public BlobContainerResource setEtag(BicepValue<String> etag) {
        this.etag.assign(etag);
        return this;
    }

    public BlobContainerResource setEtag(String etag) {
        return this.setEtag(BicepValue.from(etag));
    }

    public BicepValue<OffsetDateTime> getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public BlobContainerResource setLastModifiedTime(BicepValue<OffsetDateTime> lastModifiedTime) {
        this.lastModifiedTime.assign(lastModifiedTime);
        return this;
    }

    public BlobContainerResource setLastModifiedTime(OffsetDateTime lastModifiedTime) {
        return this.setLastModifiedTime(BicepValue.from(lastModifiedTime));
    }

    public BicepValue<LeaseStatus> getLeaseStatus() {
        return this.leaseStatus;
    }

    public BlobContainerResource setLeaseStatus(BicepValue<LeaseStatus> leaseStatus) {
        this.leaseStatus.assign(leaseStatus);
        return this;
    }

    public BlobContainerResource setLeaseStatus(LeaseStatus leaseStatus) {
        return this.setLeaseStatus(BicepValue.from(leaseStatus));
    }

    public BicepValue<Boolean> getEnableNfsV3RootSquash() {
        return this.enableNfsV3RootSquash;
    }

    public BlobContainerResource setEnableNfsV3RootSquash(BicepValue<Boolean> enableNfsV3RootSquash) {
        this.enableNfsV3RootSquash.assign(enableNfsV3RootSquash);
        return this;
    }

    public BlobContainerResource setEnableNfsV3RootSquash(Boolean enableNfsV3RootSquash) {
        return this.setEnableNfsV3RootSquash(BicepValue.from(enableNfsV3RootSquash));
    }

    public BicepValue<Boolean> getDeleted() {
        return this.deleted;
    }

    public BlobContainerResource setDeleted(BicepValue<Boolean> deleted) {
        this.deleted.assign(deleted);
        return this;
    }

    public BlobContainerResource setDeleted(Boolean deleted) {
        return this.setDeleted(BicepValue.from(deleted));
    }

    public BicepValue<LeaseState> getLeaseState() {
        return this.leaseState;
    }

    public BlobContainerResource setLeaseState(BicepValue<LeaseState> leaseState) {
        this.leaseState.assign(leaseState);
        return this;
    }

    public BlobContainerResource setLeaseState(LeaseState leaseState) {
        return this.setLeaseState(BicepValue.from(leaseState));
    }

    public BicepValue<ImmutableStorageWithVersioning> getImmutableStorageWithVersioning() {
        return this.immutableStorageWithVersioning;
    }

    public BlobContainerResource setImmutableStorageWithVersioning(BicepValue<ImmutableStorageWithVersioning> immutableStorageWithVersioning) {
        this.immutableStorageWithVersioning.assign(immutableStorageWithVersioning);
        return this;
    }

    public BlobContainerResource setImmutableStorageWithVersioning(ImmutableStorageWithVersioning immutableStorageWithVersioning) {
        return this.setImmutableStorageWithVersioning(BicepValue.from(immutableStorageWithVersioning));
    }

    public BicepValue<ImmutabilityPolicyProperties> getImmutabilityPolicy() {
        return this.immutabilityPolicy;
    }

    public BlobContainerResource setImmutabilityPolicy(BicepValue<ImmutabilityPolicyProperties> immutabilityPolicy) {
        this.immutabilityPolicy.assign(immutabilityPolicy);
        return this;
    }

    public BlobContainerResource setImmutabilityPolicy(ImmutabilityPolicyProperties immutabilityPolicy) {
        return this.setImmutabilityPolicy(BicepValue.from(immutabilityPolicy));
    }

    public BicepValue<String> getArg0() {
        return this.arg0;
    }

    public BlobContainerResource setArg0(BicepValue<String> arg0) {
        this.arg0.assign(arg0);
        return this;
    }

    public BlobContainerResource setArg0(String arg0) {
        return this.setArg0(BicepValue.from(arg0));
    }

    public BicepValue<String> getArg2() {
        return this.arg2;
    }

    public BlobContainerResource setArg2(BicepValue<String> arg2) {
        this.arg2.assign(arg2);
        return this;
    }

    public BlobContainerResource setArg2(String arg2) {
        return this.setArg2(BicepValue.from(arg2));
    }

    public BicepValue<Boolean> getDenyEncryptionScopeOverride() {
        return this.denyEncryptionScopeOverride;
    }

    public BlobContainerResource setDenyEncryptionScopeOverride(BicepValue<Boolean> denyEncryptionScopeOverride) {
        this.denyEncryptionScopeOverride.assign(denyEncryptionScopeOverride);
        return this;
    }

    public BlobContainerResource setDenyEncryptionScopeOverride(Boolean denyEncryptionScopeOverride) {
        return this.setDenyEncryptionScopeOverride(BicepValue.from(denyEncryptionScopeOverride));
    }

    public BicepValue<String> getDefaultEncryptionScope() {
        return this.defaultEncryptionScope;
    }

    public BlobContainerResource setDefaultEncryptionScope(BicepValue<String> defaultEncryptionScope) {
        this.defaultEncryptionScope.assign(defaultEncryptionScope);
        return this;
    }

    public BlobContainerResource setDefaultEncryptionScope(String defaultEncryptionScope) {
        return this.setDefaultEncryptionScope(BicepValue.from(defaultEncryptionScope));
    }

    public BicepValue<Boolean> getHasImmutabilityPolicy() {
        return this.hasImmutabilityPolicy;
    }

    public BlobContainerResource setHasImmutabilityPolicy(BicepValue<Boolean> hasImmutabilityPolicy) {
        this.hasImmutabilityPolicy.assign(hasImmutabilityPolicy);
        return this;
    }

    public BlobContainerResource setHasImmutabilityPolicy(Boolean hasImmutabilityPolicy) {
        return this.setHasImmutabilityPolicy(BicepValue.from(hasImmutabilityPolicy));
    }

}
