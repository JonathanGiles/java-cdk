package com.azure.provisioning;

import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.provisioning.implementation.contextproviders.LocalProvisioningContextProvider;
import com.azure.provisioning.implementation.contextproviders.ProvisioningContextProvider;
import com.azure.provisioning.implementation.resolvers.*;

import com.azure.core.credential.TokenCredential;
import com.azure.resourcemanager.AzureResourceManager;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Supplier;

public class ProvisioningContext {


    // package-private and non-final for unit testing purposes
    static ProvisioningContextProvider PROVIDER = new LocalProvisioningContextProvider();

    private static final Supplier<Infrastructure> DEFAULT_INFRASTRUCTURE_PROVIDER = Infrastructure::new;

    private static final Supplier<TokenCredential> DEFAULT_CREDENTIAL_PROVIDER = () -> new DefaultAzureCredentialBuilder().build();

    private Infrastructure defaultInfrastructure;
    private AzureResourceManager armClient;
    private TokenCredential defaultArmCredential;
    private TokenCredential defaultClientCredential;

    public Infrastructure getDefaultInfrastructure() {
        if (defaultInfrastructure == null) {
            defaultInfrastructure = DEFAULT_INFRASTRUCTURE_PROVIDER.get();
        }
        return defaultInfrastructure;
    }

    public void setDefaultInfrastructure(Infrastructure defaultInfrastructure) {
        this.defaultInfrastructure = defaultInfrastructure;
    }

    private final List<PropertyResolver> propertyResolvers = new ArrayList<>() {{
        add(new DynamicResourceNamePropertyResolver());
        add(new LocationPropertyResolver());
    }};

    private final List<InfrastructureResolver> infrastructureResolvers = new ArrayList<>() {{
        add(new OrderingInfrastructureResolver());
    }};

    public List<InfrastructureResolver> getInfrastructureResolvers() {
        return Collections.unmodifiableList(infrastructureResolvers);
    }

    public static Supplier<Infrastructure> getDefaultInfrastructureProvider() {
        return DEFAULT_INFRASTRUCTURE_PROVIDER;
    }

    // FIXME better name
    public static ProvisioningContextProvider getProvider() {
        return PROVIDER;
    }

    public List<PropertyResolver> getPropertyResolvers() {
        return Collections.unmodifiableList(propertyResolvers);
    }

    public AzureResourceManager getArmClient() {
//        if (_armClient == null) {
//            ArmClientOptions options = new ArmClientOptions();
//            if (ConfigureClientOptionsCallback != null) {
//                ConfigureClientOptionsCallback.accept(options);
//            }
//            _armClient = new ArmClient(getDefaultArmCredential(), getDefaultSubscriptionId(), options);
//        }
//        return _armClient;

        // FIXME Jonathan added this, but it might not completely align with the original code above
        AzureProfile profile = new AzureProfile(AzureEnvironment.AZURE);
        armClient = AzureResourceManager
            .authenticate(getDefaultArmCredential(), profile)
            .withSubscription(getDefaultSubscriptionId());
        return armClient;
    }

    public void setArmClient(AzureResourceManager armClient) {
        this.armClient = armClient;
    }

    public String getDefaultSubscriptionId() {
        return System.getenv("AZURE_SUBSCRIPTION_ID");
    }
//
//    public TokenCredential getDefaultCredential() {
//        return DefaultCredential;
//    }
//
//    public void setDefaultCredential(TokenCredential defaultCredential) {
//        this.DefaultCredential = defaultCredential;
//    }
//
    public TokenCredential getDefaultArmCredential() {
        if (defaultArmCredential == null) {
            defaultArmCredential = DEFAULT_CREDENTIAL_PROVIDER.get();
        }
        return defaultArmCredential;
    }

    public void setDefaultArmCredential(TokenCredential defaultArmCredential) {
        this.defaultArmCredential = defaultArmCredential;
    }

    public TokenCredential getDefaultClientCredential() {
        if (defaultClientCredential == null) {
            defaultClientCredential = DEFAULT_CREDENTIAL_PROVIDER.get();
        }
        return defaultClientCredential;
    }

    public void setDefaultClientCredential(TokenCredential defaultClientCredential) {
        this.defaultClientCredential = defaultClientCredential;
    }
//
//    public Consumer<ClientOptions> ConfigureClientOptionsCallback;
}