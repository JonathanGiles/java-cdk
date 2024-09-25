package com.azure.provisioning.storage;

import com.azure.core.credential.TokenCredential;
import com.azure.provisioning.BicepValue;
import com.azure.provisioning.ProvisioningDeployment;
import com.azure.provisioning.expressions.StringLiteral;
import com.azure.provisioning.primitives.IClientCreator;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;

public class BlobService implements IClientCreator<BlobServiceClient/*, BlobClientOptions*/> {

    /**
     * Get the default value for the Name property.
     *
     * @return The default name value.
     */
    private BicepValue<String> getNameDefaultValue() {
//        return new StringLiteral("default");
        throw new RuntimeException("Not implemented");
    }

    /**
     * Create a BlobServiceClient after deploying a BlobService resource.
     *
     * @param deployment The deployment for this resource.
     * @param credential A credential to use for creating the client.
     * @param options Optional BlobClientOptions to use for configuring the BlobServiceClient.
     * @return A BlobServiceClient client for the provisioned BlobService resource.
     */
    @Override
    public BlobServiceClient createClient(ProvisioningDeployment deployment, TokenCredential credential/*, BlobClientOptions options*/) {
        String endpoint = deployment.getClientCreationOutput(this, "endpoint");
        return new BlobServiceClientBuilder()
            .endpoint(endpoint)
            .credential(credential)
            //.options(options) // FIXME
            .buildClient();
//            return new BlobServiceClient(new URI(endpoint), credential, options);
    }
}