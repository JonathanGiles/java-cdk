package com.azure.provisioning.implementation.resolvers;

import com.azure.provisioning.ProvisioningContext;
import com.azure.provisioning.Infrastructure;
import com.azure.provisioning.primitives.Provisionable;

import java.util.Collections;
import java.util.List;

public interface InfrastructureResolver {
    /**
     * Resolve any properties of the infrastructure.
     *
     * @param context The current provisioning context.
     * @param infrastructure The infrastructure to resolve properties of.
     */
    default void resolveInfrastructure(ProvisioningContext context, Infrastructure infrastructure) {
        // no-op
    }

    /**
     * Process the collection of resources in the infrastructure.
     *
     * @param context The current provisioning context.
     * @param resources The existing resources to resolve.
     * @return The resolved resources.
     */
    default List<Provisionable> resolveResources(ProvisioningContext context, List<Provisionable> resources) {
        return resources;
    }

    /**
     * Gets any nested infrastructure that should be composed separately.
     *
     * @param context The current provisioning context.
     * @param infrastructure The infrastructure to inspect for any nested infrastructure.
     * @return The nested infrastructure.
     */
    default List<Infrastructure> getNestedInfrastructure(ProvisioningContext context, Infrastructure infrastructure) {
        return Collections.emptyList();
    }
}