package com.azure.provisioning.primitives;

import com.azure.core.credential.TokenCredential;
import com.azure.core.util.ClientOptions;
import com.azure.provisioning.ProvisioningDeployment;

/**
 * Allows easy creation of a data-plane client for a specific Azure resource.
 *
 * @param <TClient> The type of client that can be created for this Azure resource.
 * @param <TOptions> The type of ClientOptions used to configure the client.
 * 
 * This will be implemented explicitly by individual resources and you should
 * prefer calling ProvisioningDeployment.createClient instead to construct data-plane client resources.
 */
// FIXME just removed the options for now
public interface IClientCreator<TClient> { //, TOptions extends ClientOptions> {

    /**
     * Construct a TClient instance for this resource that was deployed as part of this deployment.
     * This is intended to be called from the ProvisioningDeployment.createClient user facing method.
     *
     * @param deployment The deployment for this resource.
     * @param credential A credential to use for creating the client.
     * @param options Optional ClientOptions to use for creating the client.
     * @return A data-plane client for the provisioned resource.
     */
    TClient createClient(ProvisioningDeployment deployment, TokenCredential credential/*, TOptions options*/);
}