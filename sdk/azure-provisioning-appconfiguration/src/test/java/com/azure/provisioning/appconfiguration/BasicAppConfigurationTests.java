package com.azure.provisioning.appconfiguration;

import com.azure.provisioning.*;
import com.azure.provisioning.bicep.BicepErrorMessage;
import com.azure.provisioning.implementation.bicep.syntax.BicepFunction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class BasicAppConfigurationTests { // extends ProvisioningTestBase {

//    public BasicAppConfigurationTests(boolean async) {
//        super(async);
//    }

    @Test
//    @DisplayName("https://github.com/Azure/azure-quickstart-templates/blob/master/quickstarts/microsoft.appconfiguration/app-configuration-store-ff/main.bicep")
    public void createAppConfigAndFeatureFlag() throws ExecutionException, InterruptedException {
//        try (Trycep test = createBicepTest()) {
//            test.define(ctx -> {
//                Infrastructure infra = new Infrastructure();
//
//                ProvisioningParameter featureFlagKey = new ProvisioningParameter("featureFlagKey", String.class);
//                featureFlagKey.setValue("FeatureFlagSample");
//                featureFlagKey.setDescription("Specifies the key of the feature flag.");
//                infra.add(featureFlagKey);
//
//                ConfigurationStoreResource configStore = new ConfigurationStoreResource("configStore", ConfigurationStoreResource.ResourceVersions.V2022_05_01);
//                configStore.setSkuName("Standard");
//                infra.add(configStore);
//
//                ProvisioningVariable flag = new ProvisioningVariable("flag", Object.class);
//                flag.setValue(new BicepDictionary() {{
//
//                    put("id", featureFlagKey);
//                    put("description", "A simple feature flag.");
//                    put("enabled", true);
//                }});
//                infra.add(flag);
//
//                KeyValueResource featureFlag = new KeyValueResource("featureFlag", KeyValueResource.ResourceVersions.V2022_05_01);
//                featureFlag.setParent(configStore);
//                featureFlag.setName(BicepFunction.interpolate(".appconfig.featureflag~2F" + featureFlagKey));
//                featureFlag.setContentType("application/vnd.microsoft.appconfig.ff+json;charset=utf-8");
//                featureFlag.setValue(BicepFunction.asString(flag));
//                infra.add(featureFlag);
//
//                return infra;
//            })
//            .compare("""
//                @description('Specifies the key of the feature flag.')
//                param featureFlagKey string = 'FeatureFlagSample'
//
//                @description('The location for the resource(s) to be deployed.')
//                param location string = resourceGroup().location
//
//                resource configStore 'Microsoft.AppConfiguration/configurationStores@2022-05-01' = {
//                  name: take('configStore-${uniqueString(resourceGroup().id)}', 50)
//                  location: location
//                  sku: {
//                    name: 'Standard'
//                  }
//                }
//
//                var flag = {
//                  id: featureFlagKey
//                  description: 'A simple feature flag.'
//                  enabled: true
//                }
//
//                resource featureFlag 'Microsoft.AppConfiguration/configurationStores/keyValues@2022-05-01' = {
//                  name: '.appconfig.featureflag~2F${featureFlagKey}'
//                  properties: {
//                    contentType: 'application/vnd.microsoft.appconfig.ff+json;charset=utf-8'
//                    value: string(flag)
//                  }
//                  parent: configStore
//                }
//                """)
//            .lint()
//            .validateAndDeployAsync()
//            .get();
//        }

        Infrastructure infra = new Infrastructure();

        ProvisioningParameter featureFlagKey = new ProvisioningParameter("featureFlagKey", String.class);
        featureFlagKey.setValue("FeatureFlagSample");
        featureFlagKey.setDescription("Specifies the key of the feature flag.");
        infra.add(featureFlagKey);

        ConfigurationStoreResource configStore = new ConfigurationStoreResource("configStore", ConfigurationStoreResource.ResourceVersions.V2022_05_01);
//        configStore.setSkuName("Standard"); // FIXME missing completely
        configStore.setEndpoint("Testing");
        infra.add(configStore);

        // FIXME - this is currently printing `var flag = null`
        ProvisioningVariable flag = new ProvisioningVariable("flag", Object.class);
        flag.setValue(BicepValue.from(new BicepDictionary<>() {{ // FIXME I've added an explicit cast here with the BicepValue.from call
            put("id", featureFlagKey);
            put("description", "A simple feature flag.");
            put("enabled", true);
        }}));
        infra.add(flag);

        KeyValueResource featureFlag = new KeyValueResource("featureFlag", KeyValueResource.ResourceVersions.V2022_05_01);
//        featureFlag.setParent(configStore); // FIXME Parent is missing
//        featureFlag.setResourceGroupName(BicepFunction.interpolate(".appconfig.featureflag~2F{featureFlagKey}").getValue()); // FIXME need interpolation, should output `name: '.appconfig.featureflag~2F${featureFlagKey}'`
        featureFlag.setContentType("application/vnd.microsoft.appconfig.ff+json;charset=utf-8");
        featureFlag.setValue(BicepFunction.asString(flag));
        infra.add(featureFlag);

        ProvisioningPlan plan = infra.build();
        plan.print(System.out);
//        List<BicepErrorMessage> messages = plan.lint();

//        return infra;
    }
}