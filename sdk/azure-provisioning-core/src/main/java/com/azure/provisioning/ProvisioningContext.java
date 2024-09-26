package com.azure.provisioning;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.provisioning.primitives.*;

import com.azure.core.credential.TokenCredential;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.Random;
import java.util.function.Supplier;

public class ProvisioningContext {

    private static final ProvisioningContextProvider PROVIDER = new LocalProvisioningContextProvider();

    private static final Supplier<Infrastructure> DEFAULT_INFRASTRUCTURE_PROVIDER = () -> new Infrastructure("main");

    private static final Supplier<TokenCredential> DEFAULT_CREDENTIAL_PROVIDER = () -> new DefaultAzureCredentialBuilder().build();

    private Infrastructure defaultInfrastructure;
//    private ArmClient _armClient;
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

    private final List<PropertyResolver> propertyResolvers = new ArrayList<PropertyResolver>() {{
        add(new DynamicResourceNamePropertyResolver());
        add(new LocationPropertyResolver());
    }};

    private List<InfrastructureResolver> infrastructureResolvers = new ArrayList<InfrastructureResolver>() {{
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

    //    public ArmClient getArmClient() {
//        if (_armClient == null) {
//            ArmClientOptions options = new ArmClientOptions();
//            if (ConfigureClientOptionsCallback != null) {
//                ConfigureClientOptionsCallback.accept(options);
//            }
//            _armClient = new ArmClient(getDefaultArmCredential(), getDefaultSubscriptionId(), options);
//        }
//        return _armClient;
//    }
//
//    public void setArmClient(ArmClient armClient) {
//        this._armClient = armClient;
//    }

//    public String getDefaultSubscriptionId() {
//        return System.getenv("AZURE_SUBSCRIPTION_ID");
//    }
//
//    public TokenCredential getDefaultCredential() {
//        return DefaultCredential;
//    }
//
//    public void setDefaultCredential(TokenCredential defaultCredential) {
//        this.DefaultCredential = defaultCredential;
//    }
//
//    public TokenCredential getDefaultArmCredential() {
//        if (_defaultArmCredential == null) {
//            _defaultArmCredential = DEFAULT_CREDENTIAL_PROVIDER.get();
//        }
//        return _defaultArmCredential;
//    }
//
//    public void setDefaultArmCredential(TokenCredential defaultArmCredential) {
//        this._defaultArmCredential = defaultArmCredential;
//    }
//
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