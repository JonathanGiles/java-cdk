// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated;

import com.azure.provisioning.storage.generated.models.RootSquashType;
import com.azure.provisioning.storage.generated.models.LeaseStatus;
import com.azure.provisioning.storage.generated.models.EnabledProtocols;
import com.azure.provisioning.BicepList;
import java.util.List;
import com.azure.provisioning.BicepDictionary;
import java.time.OffsetDateTime;
import com.azure.provisioning.storage.generated.models.LeaseDuration;
import com.azure.provisioning.storage.generated.models.SignedIdentifier;
import java.util.Map;
import com.azure.provisioning.storage.generated.models.ShareAccessTier;
import com.azure.provisioning.storage.generated.models.LeaseState;
import java.lang.String;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.Resource;
import com.azure.provisioning.tmp.ResourceType;

public class FileShareResource extends Resource {

    private final BicepValue<ShareAccessTier> accessTier;
    private final BicepValue<LeaseDuration> leaseDuration;
    private final BicepValue<String> type;
    private final BicepValue<RootSquashType> rootSquash;
    private final BicepValue<LeaseStatus> leaseStatus;
    private final BicepValue<String> accessTierStatus;
    private final BicepValue<String> arg1;
    private final BicepValue<String> name;
    private final BicepValue<Boolean> deleted;
    private final BicepValue<String> version;
    private final BicepValue<LeaseState> leaseState;
    private final BicepValue<String> etag;
    private final BicepDictionary<String> metadata;
    private final BicepValue<EnabledProtocols> enabledProtocols;
    private final BicepValue<OffsetDateTime> accessTierChangeTime;
    private final BicepValue<OffsetDateTime> snapshotTime;
    private final BicepValue<String> id;
    private final BicepList<SignedIdentifier> signedIdentifiers;
    private final BicepValue<Long> shareUsageBytes;
    private final BicepValue<OffsetDateTime> lastModifiedTime;
    private final BicepValue<String> arg2;
    private final BicepValue<Integer> shareQuota;
    private final BicepValue<String> arg4;
    private final BicepValue<String> arg0;
    private final BicepValue<Integer> remainingRetentionDays;
    private final BicepValue<OffsetDateTime> deletedTime;

    public FileShareResource(String identifierName) {
        this(identifierName, null);
    }

    public FileShareResource(String identifierName, String resourceVersion) {
        super(identifierName, new ResourceType("Microsoft.Storage/storageAccounts/fileServices/shares"), resourceVersion);
        accessTier = BicepValue.defineProperty(this, "accessTier", new String[] { "temp", "accessTier" }, false, false, false, null);
        leaseDuration = BicepValue.defineProperty(this, "leaseDuration", new String[] { "temp", "leaseDuration" }, false, false, false, null);
        type = BicepValue.defineProperty(this, "type", new String[] { "temp", "type" }, false, false, false, null);
        rootSquash = BicepValue.defineProperty(this, "rootSquash", new String[] { "temp", "rootSquash" }, false, false, false, null);
        leaseStatus = BicepValue.defineProperty(this, "leaseStatus", new String[] { "temp", "leaseStatus" }, false, false, false, null);
        accessTierStatus = BicepValue.defineProperty(this, "accessTierStatus", new String[] { "temp", "accessTierStatus" }, false, false, false, null);
        arg1 = BicepValue.defineProperty(this, "arg1", new String[] { "temp", "arg1" }, false, false, false, null);
        name = BicepValue.defineProperty(this, "name", new String[] { "temp", "name" }, false, false, false, null);
        deleted = BicepValue.defineProperty(this, "deleted", new String[] { "temp", "deleted" }, false, false, false, null);
        version = BicepValue.defineProperty(this, "version", new String[] { "temp", "version" }, false, false, false, null);
        leaseState = BicepValue.defineProperty(this, "leaseState", new String[] { "temp", "leaseState" }, false, false, false, null);
        etag = BicepValue.defineProperty(this, "etag", new String[] { "temp", "etag" }, false, false, false, null);
        metadata = BicepDictionary.defineProperty(this, "metadata", new String[] { "temp", "metadata" }, false, false);
        enabledProtocols = BicepValue.defineProperty(this, "enabledProtocols", new String[] { "temp", "enabledProtocols" }, false, false, false, null);
        accessTierChangeTime = BicepValue.defineProperty(this, "accessTierChangeTime", new String[] { "temp", "accessTierChangeTime" }, false, false, false, null);
        snapshotTime = BicepValue.defineProperty(this, "snapshotTime", new String[] { "temp", "snapshotTime" }, false, false, false, null);
        id = BicepValue.defineProperty(this, "id", new String[] { "temp", "id" }, false, false, false, null);
        signedIdentifiers = BicepList.defineProperty(this, "signedIdentifiers", new String[] { "temp", "signedIdentifiers" }, false, false);
        shareUsageBytes = BicepValue.defineProperty(this, "shareUsageBytes", new String[] { "temp", "shareUsageBytes" }, false, false, false, null);
        lastModifiedTime = BicepValue.defineProperty(this, "lastModifiedTime", new String[] { "temp", "lastModifiedTime" }, false, false, false, null);
        arg2 = BicepValue.defineProperty(this, "arg2", new String[] { "temp", "arg2" }, false, false, false, null);
        shareQuota = BicepValue.defineProperty(this, "shareQuota", new String[] { "temp", "shareQuota" }, false, false, false, null);
        arg4 = BicepValue.defineProperty(this, "arg4", new String[] { "temp", "arg4" }, false, false, false, null);
        arg0 = BicepValue.defineProperty(this, "arg0", new String[] { "temp", "arg0" }, false, false, false, null);
        remainingRetentionDays = BicepValue.defineProperty(this, "remainingRetentionDays", new String[] { "temp", "remainingRetentionDays" }, false, false, false, null);
        deletedTime = BicepValue.defineProperty(this, "deletedTime", new String[] { "temp", "deletedTime" }, false, false, false, null);
    }

    public BicepValue<ShareAccessTier> getAccessTier() {
        return this.accessTier;
    }

    public FileShareResource setAccessTier(BicepValue<ShareAccessTier> accessTier) {
        this.accessTier.assign(accessTier);
        return this;
    }

    public FileShareResource setAccessTier(ShareAccessTier accessTier) {
        return this.setAccessTier(BicepValue.from(accessTier));
    }

    public BicepValue<LeaseDuration> getLeaseDuration() {
        return this.leaseDuration;
    }

    public FileShareResource setLeaseDuration(BicepValue<LeaseDuration> leaseDuration) {
        this.leaseDuration.assign(leaseDuration);
        return this;
    }

    public FileShareResource setLeaseDuration(LeaseDuration leaseDuration) {
        return this.setLeaseDuration(BicepValue.from(leaseDuration));
    }

    public BicepValue<String> getType() {
        return this.type;
    }

    public FileShareResource setType(BicepValue<String> type) {
        this.type.assign(type);
        return this;
    }

    public FileShareResource setType(String type) {
        return this.setType(BicepValue.from(type));
    }

    public BicepValue<RootSquashType> getRootSquash() {
        return this.rootSquash;
    }

    public FileShareResource setRootSquash(BicepValue<RootSquashType> rootSquash) {
        this.rootSquash.assign(rootSquash);
        return this;
    }

    public FileShareResource setRootSquash(RootSquashType rootSquash) {
        return this.setRootSquash(BicepValue.from(rootSquash));
    }

    public BicepValue<LeaseStatus> getLeaseStatus() {
        return this.leaseStatus;
    }

    public FileShareResource setLeaseStatus(BicepValue<LeaseStatus> leaseStatus) {
        this.leaseStatus.assign(leaseStatus);
        return this;
    }

    public FileShareResource setLeaseStatus(LeaseStatus leaseStatus) {
        return this.setLeaseStatus(BicepValue.from(leaseStatus));
    }

    public BicepValue<String> getAccessTierStatus() {
        return this.accessTierStatus;
    }

    public FileShareResource setAccessTierStatus(BicepValue<String> accessTierStatus) {
        this.accessTierStatus.assign(accessTierStatus);
        return this;
    }

    public FileShareResource setAccessTierStatus(String accessTierStatus) {
        return this.setAccessTierStatus(BicepValue.from(accessTierStatus));
    }

    public BicepValue<String> getArg1() {
        return this.arg1;
    }

    public FileShareResource setArg1(BicepValue<String> arg1) {
        this.arg1.assign(arg1);
        return this;
    }

    public FileShareResource setArg1(String arg1) {
        return this.setArg1(BicepValue.from(arg1));
    }

    public BicepValue<String> getName() {
        return this.name;
    }

    public FileShareResource setName(BicepValue<String> name) {
        this.name.assign(name);
        return this;
    }

    public FileShareResource setName(String name) {
        return this.setName(BicepValue.from(name));
    }

    public BicepValue<Boolean> getDeleted() {
        return this.deleted;
    }

    public FileShareResource setDeleted(BicepValue<Boolean> deleted) {
        this.deleted.assign(deleted);
        return this;
    }

    public FileShareResource setDeleted(Boolean deleted) {
        return this.setDeleted(BicepValue.from(deleted));
    }

    public BicepValue<String> getVersion() {
        return this.version;
    }

    public FileShareResource setVersion(BicepValue<String> version) {
        this.version.assign(version);
        return this;
    }

    public FileShareResource setVersion(String version) {
        return this.setVersion(BicepValue.from(version));
    }

    public BicepValue<LeaseState> getLeaseState() {
        return this.leaseState;
    }

    public FileShareResource setLeaseState(BicepValue<LeaseState> leaseState) {
        this.leaseState.assign(leaseState);
        return this;
    }

    public FileShareResource setLeaseState(LeaseState leaseState) {
        return this.setLeaseState(BicepValue.from(leaseState));
    }

    public BicepValue<String> getEtag() {
        return this.etag;
    }

    public FileShareResource setEtag(BicepValue<String> etag) {
        this.etag.assign(etag);
        return this;
    }

    public FileShareResource setEtag(String etag) {
        return this.setEtag(BicepValue.from(etag));
    }

    public BicepDictionary<String> getMetadata() {
        return this.metadata;
    }

    public FileShareResource setMetadata(BicepValue<Map<String,String>> metadata) {
        this.metadata.assign(metadata);
        return this;
    }

    public FileShareResource setMetadata(Map<String,String> metadata) {
        return this.setMetadata(BicepValue.from(metadata));
    }

    public BicepValue<EnabledProtocols> getEnabledProtocols() {
        return this.enabledProtocols;
    }

    public FileShareResource setEnabledProtocols(BicepValue<EnabledProtocols> enabledProtocols) {
        this.enabledProtocols.assign(enabledProtocols);
        return this;
    }

    public FileShareResource setEnabledProtocols(EnabledProtocols enabledProtocols) {
        return this.setEnabledProtocols(BicepValue.from(enabledProtocols));
    }

    public BicepValue<OffsetDateTime> getAccessTierChangeTime() {
        return this.accessTierChangeTime;
    }

    public FileShareResource setAccessTierChangeTime(BicepValue<OffsetDateTime> accessTierChangeTime) {
        this.accessTierChangeTime.assign(accessTierChangeTime);
        return this;
    }

    public FileShareResource setAccessTierChangeTime(OffsetDateTime accessTierChangeTime) {
        return this.setAccessTierChangeTime(BicepValue.from(accessTierChangeTime));
    }

    public BicepValue<OffsetDateTime> getSnapshotTime() {
        return this.snapshotTime;
    }

    public FileShareResource setSnapshotTime(BicepValue<OffsetDateTime> snapshotTime) {
        this.snapshotTime.assign(snapshotTime);
        return this;
    }

    public FileShareResource setSnapshotTime(OffsetDateTime snapshotTime) {
        return this.setSnapshotTime(BicepValue.from(snapshotTime));
    }

    public BicepValue<String> getId() {
        return this.id;
    }

    public FileShareResource setId(BicepValue<String> id) {
        this.id.assign(id);
        return this;
    }

    public FileShareResource setId(String id) {
        return this.setId(BicepValue.from(id));
    }

    public BicepList<SignedIdentifier> getSignedIdentifiers() {
        return this.signedIdentifiers;
    }

    public FileShareResource setSignedIdentifiers(BicepValue<List<SignedIdentifier>> signedIdentifiers) {
        this.signedIdentifiers.assign(signedIdentifiers);
        return this;
    }

    public FileShareResource setSignedIdentifiers(List<SignedIdentifier> signedIdentifiers) {
        return this.setSignedIdentifiers(BicepValue.from(signedIdentifiers));
    }

    public BicepValue<Long> getShareUsageBytes() {
        return this.shareUsageBytes;
    }

    public FileShareResource setShareUsageBytes(BicepValue<Long> shareUsageBytes) {
        this.shareUsageBytes.assign(shareUsageBytes);
        return this;
    }

    public FileShareResource setShareUsageBytes(Long shareUsageBytes) {
        return this.setShareUsageBytes(BicepValue.from(shareUsageBytes));
    }

    public BicepValue<OffsetDateTime> getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public FileShareResource setLastModifiedTime(BicepValue<OffsetDateTime> lastModifiedTime) {
        this.lastModifiedTime.assign(lastModifiedTime);
        return this;
    }

    public FileShareResource setLastModifiedTime(OffsetDateTime lastModifiedTime) {
        return this.setLastModifiedTime(BicepValue.from(lastModifiedTime));
    }

    public BicepValue<String> getArg2() {
        return this.arg2;
    }

    public FileShareResource setArg2(BicepValue<String> arg2) {
        this.arg2.assign(arg2);
        return this;
    }

    public FileShareResource setArg2(String arg2) {
        return this.setArg2(BicepValue.from(arg2));
    }

    public BicepValue<Integer> getShareQuota() {
        return this.shareQuota;
    }

    public FileShareResource setShareQuota(BicepValue<Integer> shareQuota) {
        this.shareQuota.assign(shareQuota);
        return this;
    }

    public FileShareResource setShareQuota(Integer shareQuota) {
        return this.setShareQuota(BicepValue.from(shareQuota));
    }

    public BicepValue<String> getArg4() {
        return this.arg4;
    }

    public FileShareResource setArg4(BicepValue<String> arg4) {
        this.arg4.assign(arg4);
        return this;
    }

    public FileShareResource setArg4(String arg4) {
        return this.setArg4(BicepValue.from(arg4));
    }

    public BicepValue<String> getArg0() {
        return this.arg0;
    }

    public FileShareResource setArg0(BicepValue<String> arg0) {
        this.arg0.assign(arg0);
        return this;
    }

    public FileShareResource setArg0(String arg0) {
        return this.setArg0(BicepValue.from(arg0));
    }

    public BicepValue<Integer> getRemainingRetentionDays() {
        return this.remainingRetentionDays;
    }

    public FileShareResource setRemainingRetentionDays(BicepValue<Integer> remainingRetentionDays) {
        this.remainingRetentionDays.assign(remainingRetentionDays);
        return this;
    }

    public FileShareResource setRemainingRetentionDays(Integer remainingRetentionDays) {
        return this.setRemainingRetentionDays(BicepValue.from(remainingRetentionDays));
    }

    public BicepValue<OffsetDateTime> getDeletedTime() {
        return this.deletedTime;
    }

    public FileShareResource setDeletedTime(BicepValue<OffsetDateTime> deletedTime) {
        this.deletedTime.assign(deletedTime);
        return this;
    }

    public FileShareResource setDeletedTime(OffsetDateTime deletedTime) {
        return this.setDeletedTime(BicepValue.from(deletedTime));
    }

}
