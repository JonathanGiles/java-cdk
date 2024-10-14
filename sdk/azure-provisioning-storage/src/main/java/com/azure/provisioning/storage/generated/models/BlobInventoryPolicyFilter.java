// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated.models;

import java.util.List;
import com.azure.provisioning.storage.generated.models.BlobInventoryCreationTime;
import java.lang.String;
import com.azure.provisioning.BicepList;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class BlobInventoryPolicyFilter extends ProvisioningConstruct {

    private final BicepList<String> prefixMatch;
    private final BicepValue<Boolean> includeSnapshots;
    private final BicepValue<Boolean> includeBlobVersions;
    private final BicepValue<Boolean> includeDeleted;
    private final BicepList<String> blobTypes;
    private final BicepList<String> excludePrefix;
    private final BicepValue<BlobInventoryCreationTime> creationTime;

    public BlobInventoryPolicyFilter() {
        prefixMatch = BicepList.defineProperty(this, "prefixMatch", new String[] { "temp", "prefixMatch" }, false, false);
        includeSnapshots = BicepValue.defineProperty(this, "includeSnapshots", new String[] { "temp", "includeSnapshots" }, null);
        includeBlobVersions = BicepValue.defineProperty(this, "includeBlobVersions", new String[] { "temp", "includeBlobVersions" }, null);
        includeDeleted = BicepValue.defineProperty(this, "includeDeleted", new String[] { "temp", "includeDeleted" }, null);
        blobTypes = BicepList.defineProperty(this, "blobTypes", new String[] { "temp", "blobTypes" }, false, false);
        excludePrefix = BicepList.defineProperty(this, "excludePrefix", new String[] { "temp", "excludePrefix" }, false, false);
        creationTime = BicepValue.defineProperty(this, "creationTime", new String[] { "temp", "creationTime" }, null);
    }

    public BicepValue<List<String>> getPrefixMatch() {
        return this.prefixMatch;
    }

    public BlobInventoryPolicyFilter setPrefixMatch(BicepValue<List<String>> prefixMatch) {
        this.prefixMatch.assign(prefixMatch);
        return this;
    }
    public BicepValue<Boolean> getIncludeSnapshots() {
        return this.includeSnapshots;
    }

    public BlobInventoryPolicyFilter setIncludeSnapshots(BicepValue<Boolean> includeSnapshots) {
        this.includeSnapshots.assign(includeSnapshots);
        return this;
    }
    public BicepValue<Boolean> getIncludeBlobVersions() {
        return this.includeBlobVersions;
    }

    public BlobInventoryPolicyFilter setIncludeBlobVersions(BicepValue<Boolean> includeBlobVersions) {
        this.includeBlobVersions.assign(includeBlobVersions);
        return this;
    }
    public BicepValue<Boolean> getIncludeDeleted() {
        return this.includeDeleted;
    }

    public BlobInventoryPolicyFilter setIncludeDeleted(BicepValue<Boolean> includeDeleted) {
        this.includeDeleted.assign(includeDeleted);
        return this;
    }
    public BicepValue<List<String>> getBlobTypes() {
        return this.blobTypes;
    }

    public BlobInventoryPolicyFilter setBlobTypes(BicepValue<List<String>> blobTypes) {
        this.blobTypes.assign(blobTypes);
        return this;
    }
    public BicepValue<List<String>> getExcludePrefix() {
        return this.excludePrefix;
    }

    public BlobInventoryPolicyFilter setExcludePrefix(BicepValue<List<String>> excludePrefix) {
        this.excludePrefix.assign(excludePrefix);
        return this;
    }
    public BicepValue<BlobInventoryCreationTime> getCreationTime() {
        return this.creationTime;
    }

    public BlobInventoryPolicyFilter setCreationTime(BicepValue<BlobInventoryCreationTime> creationTime) {
        this.creationTime.assign(creationTime);
        return this;
    }
}
