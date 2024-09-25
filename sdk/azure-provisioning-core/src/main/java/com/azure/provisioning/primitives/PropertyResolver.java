package com.azure.provisioning.primitives;

import com.azure.provisioning.ProvisioningContext;

/**
 * A property resolver attempts to resolve the values of any unset properties
 * in a construct. This can be useful for defaulting common values,
 * implementing organization policies, or other scenarios where you want to
 * uniformly configure all the resources in a deployment.
 */
public abstract class PropertyResolver {

    /**
     * Try to resolve the values of any unset properties in the given construct.
     *
     * @param context The current provisioning context.
     * @param construct The construct with properties to resolve.
     */
    public abstract void resolveProperties(ProvisioningContext context, ProvisioningConstruct construct);
}