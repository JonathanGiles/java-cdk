// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated.models;

import java.util.List;
import com.azure.core.util.logging.ClientLogger;
import java.lang.String;
import com.azure.provisioning.storage.generated.models.TagFilter;
import com.azure.provisioning.BicepList;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class ManagementPolicyFilter extends ProvisioningConstruct {

    private final BicepValue<ClientLogger> lOGGER;
    private final BicepList<String> blobTypes;
    private final BicepList<String> prefixMatch;
    private final BicepList<TagFilter> blobIndexMatch;

    public ManagementPolicyFilter() {
        lOGGER = BicepValue.defineProperty(this, "lOGGER", new String[] { "temp", "lOGGER" }, null);
        blobTypes = BicepList.defineProperty(this, "blobTypes", new String[] { "temp", "blobTypes" }, false, false);
        prefixMatch = BicepList.defineProperty(this, "prefixMatch", new String[] { "temp", "prefixMatch" }, false, false);
        blobIndexMatch = BicepList.defineProperty(this, "blobIndexMatch", new String[] { "temp", "blobIndexMatch" }, false, false);
    }

    public BicepValue<ClientLogger> getLOGGER() {
        return this.lOGGER;
    }

    public ManagementPolicyFilter setLOGGER(BicepValue<ClientLogger> lOGGER) {
        this.lOGGER.assign(lOGGER);
        return this;
    }
    public BicepValue<List<String>> getBlobTypes() {
        return this.blobTypes;
    }

    public ManagementPolicyFilter setBlobTypes(BicepValue<List<String>> blobTypes) {
        this.blobTypes.assign(blobTypes);
        return this;
    }
    public BicepValue<List<String>> getPrefixMatch() {
        return this.prefixMatch;
    }

    public ManagementPolicyFilter setPrefixMatch(BicepValue<List<String>> prefixMatch) {
        this.prefixMatch.assign(prefixMatch);
        return this;
    }
    public BicepValue<List<TagFilter>> getBlobIndexMatch() {
        return this.blobIndexMatch;
    }

    public ManagementPolicyFilter setBlobIndexMatch(BicepValue<List<TagFilter>> blobIndexMatch) {
        this.blobIndexMatch.assign(blobIndexMatch);
        return this;
    }
}
