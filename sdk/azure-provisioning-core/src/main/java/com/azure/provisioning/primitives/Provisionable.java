package com.azure.provisioning.primitives;

import com.azure.provisioning.ProvisioningContext;
import com.azure.provisioning.implementation.bicep.syntax.Statement;

import java.util.Collections;
import java.util.List;

public interface Provisionable {

    /**
     * Get any resources represented by this object. This will typically only
     * be the object itself for everything but Infrastructure.
     *
     * @return Any resources represented by this object.
     */
    default List<Provisionable> getResources() {
        return Collections.singletonList(this);
    }

    /**
     * Resolve any resources or properties that were not explicitly specified.
     *
     * @param context Optional ProvisioningContext.
     */
    void resolve(ProvisioningContext context);

    /**
     * Validate the presence of any required members.
     *
     * @param context Optional ProvisioningContext.
     */
    void validate(ProvisioningContext context);

    /**
     * Compile the resource into a set of Bicep statements.
     *
     * @param context Optional ProvisioningContext.
     * @return Bicep representation of the resource.
     */
    List<Statement> compile(ProvisioningContext context);
}