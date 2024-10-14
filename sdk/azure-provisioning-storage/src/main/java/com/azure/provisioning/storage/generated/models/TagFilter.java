// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.provisioning.storage.generated.models;

import com.azure.core.util.logging.ClientLogger;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.primitives.ProvisioningConstruct;

public class TagFilter extends ProvisioningConstruct {

    private final BicepValue<ClientLogger> lOGGER;
    private final BicepValue<String> op;
    private final BicepValue<String> value;
    private final BicepValue<String> name;

    public TagFilter() {
        lOGGER = BicepValue.defineProperty(this, "lOGGER", new String[] { "temp", "lOGGER" }, null);
        op = BicepValue.defineProperty(this, "op", new String[] { "temp", "op" }, null);
        value = BicepValue.defineProperty(this, "value", new String[] { "temp", "value" }, null);
        name = BicepValue.defineProperty(this, "name", new String[] { "temp", "name" }, null);
    }

    public BicepValue<ClientLogger> getLOGGER() {
        return this.lOGGER;
    }

    public TagFilter setLOGGER(BicepValue<ClientLogger> lOGGER) {
        this.lOGGER.assign(lOGGER);
        return this;
    }
    public BicepValue<String> getOp() {
        return this.op;
    }

    public TagFilter setOp(BicepValue<String> op) {
        this.op.assign(op);
        return this;
    }
    public BicepValue<String> getValue() {
        return this.value;
    }

    public TagFilter setValue(BicepValue<String> value) {
        this.value.assign(value);
        return this;
    }
    public BicepValue<String> getName() {
        return this.name;
    }

    public TagFilter setName(BicepValue<String> name) {
        this.name.assign(name);
        return this;
    }
}
