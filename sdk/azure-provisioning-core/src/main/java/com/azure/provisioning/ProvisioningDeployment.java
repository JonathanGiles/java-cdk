package com.azure.provisioning;

import com.azure.core.credential.TokenCredential;
import com.azure.core.models.ResponseError;
import com.azure.provisioning.primitives.IClientCreator;
import com.azure.provisioning.primitives.Resource;

import java.util.Map;

public class ProvisioningDeployment {

    private final ProvisioningContext context;
    private final ArmDeploymentResource deployment;
    private final Map<String, Object> outputs;

    public ProvisioningDeployment(ProvisioningContext context, ArmDeploymentResource deployment, Map<String, Object> outputs) {
        if (!deployment.hasData()) {
            throw new IllegalArgumentException("The deployment must have its data property set.");
        }
        this.context = context;
        this.deployment = deployment;
        this.outputs = outputs;
    }

    public ProvisioningContext getContext() {
        return context;
    }

    public ArmDeploymentResource getDeployment() {
        return deployment;
    }

    public ResourcesProvisioningState getProvisioningState() {
        return deployment.getData().getProperties().getProvisioningState();
    }

    public ResponseError getError() {
        return deployment.getData().getProperties().getError();
    }

    public Map<String, Object> getOutputs() {
        return outputs;
    }

    public <TClient/*, TOptions extends ClientOptions*/> TClient createClient(IClientCreator<TClient/*, TOptions*/> resource, TokenCredential credential, TOptions options) {
        if (getProvisioningState() != ResourcesProvisioningState.SUCCEEDED) {
            throw new IllegalStateException("Cannot create a client because the deployment did not succeed: " + getError());
        }
        if (credential == null) {
            credential = context.getDefaultClientCredential();
        }
//        if (options != null) {
//            context.getConfigureClientOptionsCallback().accept(options);
//        }
        return resource.createClient(this, credential/*, options*/);
    }

    public <T> T getClientCreationOutput(Resource resource, String parameterName) {
        String qualifiedName = resource.getResourceName() + "_" + parameterName;
        Object raw = outputs.get(qualifiedName);
        if (raw == null) {
            throw new IllegalStateException("Could not find output value " + qualifiedName + " to construct " + resource.getClass().getSimpleName() + " resource " + resource.getResourceName() + ".");
        }
        return (T) raw;
    }
}