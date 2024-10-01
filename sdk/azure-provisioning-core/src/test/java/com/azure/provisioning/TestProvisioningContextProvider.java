package com.azure.provisioning;

import com.azure.provisioning.implementation.contextproviders.ProvisioningContextProvider;

public class TestProvisioningContextProvider extends ProvisioningContextProvider {
    private final ProvisioningTestBase test;
    private ProvisioningContext current;

    public TestProvisioningContextProvider(ProvisioningTestBase test) {
        this.test = test;
    }

    private ProvisioningContext createContext() {
//        TokenCredential credential = new DefaultAzureCredentialBuilder().build();
//        AzureResourceManager armClient = AzureResourceManager
//            .authenticate(credential, test.getTestEnvironment().getSubscriptionId())
//            .withDefaultSubscription();
//
//        return new ProvisioningContext()
//            .setArmClient(armClient)
//            .setDefaultCredential(credential)
//            .setDefaultSubscriptionId(test.getTestEnvironment().getSubscriptionId());
        throw new RuntimeException("Not implemented");
    }

    @Override
    public ProvisioningContext getProvisioningContext() {
        if (current == null) {
            current = createContext();
        }
        return current;
    }

    public void reset() {
        current = null;
    }
}