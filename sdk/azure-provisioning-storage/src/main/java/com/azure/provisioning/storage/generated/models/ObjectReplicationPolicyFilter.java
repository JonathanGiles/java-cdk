// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated.models;

import java.util.List;
import java.lang.String;
import com.azure.provisioning.BicepList;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class ObjectReplicationPolicyFilter extends ProvisioningConstruct {

    private final BicepList<String> prefixMatch;
    private final BicepValue<String> minCreationTime;

    public ObjectReplicationPolicyFilter() {
        prefixMatch = BicepList.defineProperty(this, "prefixMatch", new String[] { "temp", "prefixMatch" }, false, false);
        minCreationTime = BicepValue.defineProperty(this, "minCreationTime", new String[] { "temp", "minCreationTime" }, null);
    }

    public BicepValue<List<String>> getPrefixMatch() {
        return this.prefixMatch;
    }

    public ObjectReplicationPolicyFilter setPrefixMatch(BicepValue<List<String>> prefixMatch) {
        this.prefixMatch.assign(prefixMatch);
        return this;
    }
    public BicepValue<String> getMinCreationTime() {
        return this.minCreationTime;
    }

    public ObjectReplicationPolicyFilter setMinCreationTime(BicepValue<String> minCreationTime) {
        this.minCreationTime.assign(minCreationTime);
        return this;
    }
}