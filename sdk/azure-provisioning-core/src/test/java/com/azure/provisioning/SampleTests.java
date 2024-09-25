package com.azure.provisioning;

import com.azure.core.credential.TokenCredential;
import com.azure.core.http.rest.Response;
import com.azure.core.management.Region;
import com.azure.core.test.annotation.AsyncOnly;
import com.azure.core.test.annotation.LiveOnly;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.provisioning.ProvisioningPlan;
import com.azure.provisioning.ProvisioningTestBase;
import com.azure.provisioning.primitives.BicepOutput;
import com.azure.provisioning.primitives.BicepParameter;
import com.azure.provisioning.primitives.BicepDictionary;
import com.azure.provisioning.primitives.BicepLiteral;
import com.azure.provisioning.primitives.ResourceStatement;
import com.azure.provisioning.primitives.StringLiteral;
import com.azure.provisioning.primitives.IdentifierExpression;
import com.azure.provisioning.primitives.ObjectExpression;
import com.azure.provisioning.primitives.PropertyExpression;
import com.azure.provisioning.storage.StorageAccount;
import com.azure.provisioning.storage.StorageResources;
import com.azure.provisioning.appcontainers.ContainerAppManagedEnvironment;
import com.azure.provisioning.appcontainers.ContainerAppLogsConfiguration;
import com.azure.provisioning.appcontainers.ContainerAppLogAnalyticsConfiguration;
import com.azure.provisioning.appcontainers.ContainerAppWorkloadProfile;
import com.azure.provisioning.containerregistry.ContainerRegistryService;
import com.azure.provisioning.containerregistry.ContainerRegistrySku;
import com.azure.provisioning.containerregistry.ContainerRegistrySkuName;
import com.azure.provisioning.operationalinsights.OperationalInsightsWorkspace;
import com.azure.provisioning.operationalinsights.OperationalInsightsWorkspaceSku;
import com.azure.provisioning.operationalinsights.OperationalInsightsWorkspaceSkuName;
import com.azure.provisioning.roles.ManagedServiceIdentity;
import com.azure.provisioning.roles.ManagedServiceIdentityType;
import com.azure.provisioning.roles.UserAssignedIdentity;
import com.azure.provisioning.roles.UserAssignedIdentityDetails;
import com.azure.provisioning.resources.ResourceGroup;
import com.azure.provisioning.resources.Infrastructure;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.models.BlobServiceProperties;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

@AsyncOnly
@LiveOnly
public class SampleTests extends ProvisioningTestBase {

    public SampleTests(boolean async) {
        super(async);
    }

    @Test
    public void simpleDeploy() throws Exception {
        BlobServiceClient blobs = null;
        BicepOutput endpoint = null;

        try (Trycep test = createBicepTest()) {
            test.define(ctx -> {
                StorageAccount storage = StorageResources.createAccount("storage");
                blobs = new BlobServiceClient(storage.getPrimaryEndpoints().getBlobUri(), new DefaultAzureCredentialBuilder().build());
                endpoint = new BicepOutput("blobs_endpoint", String.class, storage.getPrimaryEndpoints().getBlobUri());
            })
            .compare("""
                @description('The location for the resource(s) to be deployed.')
                param location string = resourceGroup().location

                resource storage 'Microsoft.Storage/storageAccounts@2023-01-01' = {
                  name: take('storage${uniqueString(resourceGroup().id)}', 24)
                  kind: 'StorageV2'
                  location: location
                  sku: {
                    name: 'Standard_LRS'
                  }
                  properties: {
                    allowBlobPublicAccess: false
                    isHnsEnabled: true
                  }
                }

                resource blobs 'Microsoft.Storage/storageAccounts/blobServices@2023-01-01' = {
                  name: 'default'
                  parent: storage
                }

                output blobs_endpoint string = storage.properties.primaryEndpoints.blob
                """)
            .lint()
            .validateAndDeployAsync(deployment -> {
                BlobServiceClient storageClient = new BlobServiceClient(blobs.getBlobContainerClient("default").getBlobContainerUrl(), new DefaultAzureCredentialBuilder().build());
                assertEquals(storageClient.getBlobContainerUrl(), endpoint.getValue());
                Response<BlobServiceProperties> result = storageClient.getProperties();
                assertEquals(200, result.getStatusCode());
            });
        }
    }

    @Test
    public void simpleContainerApp() throws Exception {
        try (Trycep test = createBicepTest()) {
            test.define(ctx -> {
                BicepParameter principalId = new BicepParameter("principalId", String.class, "");
                BicepParameter tags = new BicepParameter("tags", Object.class, new BicepDictionary<>());

                UserAssignedIdentity mi = new UserAssignedIdentity("mi");
                mi.setTags(tags);

                ContainerRegistryService acr = new ContainerRegistryService("acr");
                acr.setSku(new ContainerRegistrySku(ContainerRegistrySkuName.BASIC));
                acr.setTags(tags);
                acr.setIdentity(new ManagedServiceIdentity(ManagedServiceIdentityType.SYSTEM_ASSIGNED_USER_ASSIGNED, Collections.singletonMap(mi.getId(), new UserAssignedIdentityDetails())));

                acr.assignRole("AcrPull", mi);

                OperationalInsightsWorkspace law = new OperationalInsightsWorkspace("law");
                law.setSku(new OperationalInsightsWorkspaceSku(OperationalInsightsWorkspaceSkuName.PER_GB_2018));
                law.setTags(tags);

                ContainerAppManagedEnvironment cae = new ContainerAppManagedEnvironment("cae");
                cae.setWorkloadProfiles(Collections.singletonList(new ContainerAppWorkloadProfile("consumption", "Consumption")));
                cae.setAppLogsConfiguration(new ContainerAppLogsConfiguration("log-analytics", new ContainerAppLogAnalyticsConfiguration(law.getCustomerId(), law.getKeys().getPrimarySharedKey())));
                cae.setTags(tags);

                cae.assignRole("Contributor", mi);

                BicepLiteral aspireDashboard = new BicepLiteral("aspireDashboard", new ResourceStatement("aspireDashboard", new StringLiteral("Microsoft.App/managedEnvironments/dotNetComponents@2024-02-02-preview"), new ObjectExpression(new PropertyExpression("name", "aspire-dashboard"), new PropertyExpression("parent", new IdentifierExpression(cae.getResourceName())), new PropertyExpression("properties", new ObjectExpression(new PropertyExpression("componentType", new StringLiteral("AspireDashboard")))))));

                new BicepOutput("MANAGED_IDENTITY_CLIENT_ID", String.class, mi.getClientId());
                new BicepOutput("MANAGED_IDENTITY_NAME", String.class, mi.getName());
                new BicepOutput("MANAGED_IDENTITY_PRINCIPAL_ID", String.class, mi.getPrincipalId());
                new BicepOutput("LOG_ANALYTICS_WORKSPACE_NAME", String.class, law.getName());
                new BicepOutput("LOG_ANALYTICS_WORKSPACE_ID", String.class, law.getId());
                new BicepOutput("AZURE_CONTAINER_REGISTRY_ENDPOINT", String.class, acr.getLoginServer());
                new BicepOutput("AZURE_CONTAINER_REGISTRY_MANAGED_IDENTITY_ID", String.class, mi.getId());
                new BicepOutput("AZURE_CONTAINER_APPS_ENVIRONMENT_NAME", String.class, cae.getName());
                new BicepOutput("AZURE_CONTAINER_APPS_ENVIRONMENT_ID", String.class, cae.getId());
                new BicepOutput("AZURE_CONTAINER_APPS_ENVIRONMENT_DEFAULT_DOMAIN", String.class, cae.getDefaultDomain());
            })
            .compare("""
                param principalId string = ''

                param tags object = { }

                @description('The location for the resource(s) to be deployed.')
                param location string = resourceGroup().location

                resource mi 'Microsoft.ManagedIdentity/userAssignedIdentities@2023-01-31' = {
                  name: take('mi-${uniqueString(resourceGroup().id)}', 128)
                  location: location
                  tags: tags
                }

                resource acr 'Microsoft.ContainerRegistry/registries@2023-07-01' = {
                  name: take('acr${uniqueString(resourceGroup().id)}', 50)
                  location: location
                  sku: {
                    name: 'Basic'
                  }
                  identity: {
                    type: 'SystemAssigned, UserAssigned'
                    userAssignedIdentities: {
                      '${mi.id}': { }
                    }
                  }
                  tags: tags
                }

                resource acr_mi_AcrPull 'Microsoft.Authorization/roleAssignments@2022-04-01' = {
                  name: guid(acr.id, mi.properties.principalId, subscriptionResourceId('Microsoft.Authorization/roleDefinitions', '7f951dda-4ed3-4680-a7ca-43fe172d538d'))
                  properties: {
                    principalId: mi.properties.principalId
                    roleDefinitionId: subscriptionResourceId('Microsoft.Authorization/roleDefinitions', '7f951dda-4ed3-4680-a7ca-43fe172d538d')
                    principalType: 'ServicePrincipal'
                  }
                  scope: acr
                }

                resource law 'Microsoft.OperationalInsights/workspaces@2022-10-01' = {
                  name: take('law-${uniqueString(resourceGroup().id)}', 63)
                  location: location
                  properties: {
                    sku: {
                      name: 'PerGB2018'
                    }
                  }
                  tags: tags
                }

                resource cae 'Microsoft.App/managedEnvironments@2023-05-01' = {
                  name: take('cae${uniqueString(resourceGroup().id)}', 24)
                  location: location
                  properties: {
                    appLogsConfiguration: {
                      destination: 'log-analytics'
                      logAnalyticsConfiguration: {
                        customerId: law.properties.customerId
                        sharedKey: law.listKeys().primarySharedKey
                      }
                    }
                    workloadProfiles: [
                      {
                        name: 'consumption'
                        workloadProfileType: 'Consumption'
                      }
                    ]
                  }
                  tags: tags
                }

                resource cae_mi_Contributor 'Microsoft.Authorization/roleAssignments@2022-04-01' = {
                  name: guid(cae.id, mi.properties.principalId, subscriptionResourceId('Microsoft.Authorization/roleDefinitions', 'b24988ac-6180-42a0-ab88-20f7382dd24c'))
                  properties: {
                    principalId: mi.properties.principalId
                    roleDefinitionId: subscriptionResourceId('Microsoft.Authorization/roleDefinitions', 'b24988ac-6180-42a0-ab88-20f7382dd24c')
                    principalType: 'ServicePrincipal'
                  }
                  scope: cae
                }

                resource aspireDashboard 'Microsoft.App/managedEnvironments/dotNetComponents@2024-02-02-preview' = {
                  name: 'aspire-dashboard'
                  parent: cae
                  properties: {
                    componentType: 'AspireDashboard'
                  }
                }

                output MANAGED_IDENTITY_CLIENT_ID string = mi.properties.clientId

                output MANAGED_IDENTITY_NAME string = mi.name

                output MANAGED_IDENTITY_PRINCIPAL_ID string = mi.properties.principalId

                output LOG_ANALYTICS_WORKSPACE_NAME string = law.name

                output LOG_ANALYTICS_WORKSPACE_ID string = law.id

                output AZURE_CONTAINER_REGISTRY_ENDPOINT string = acr.properties.loginServer

                output AZURE_CONTAINER_REGISTRY_MANAGED_IDENTITY_ID string = mi.id

                output AZURE_CONTAINER_APPS_ENVIRONMENT_NAME string = cae.name

                output AZURE_CONTAINER_APPS_ENVIRONMENT_ID string = cae.id

                output AZURE_CONTAINER_APPS_ENVIRONMENT_DEFAULT_DOMAIN string = cae.properties.defaultDomain
                """)
            .lint(List.of("no-unused-params", "BCP029"))
            .validateAndDeployAsync();
        }
    }

    @Test
    public void simpleResourceGroup() throws Exception {
        try (Trycep test = createBicepTest()) {
            test.define(ctx -> {
                ResourceGroup rg = new ResourceGroup("rg-test", "2024-03-01");
                Infrastructure group = new Infrastructure("main");
                group.setTargetScope("subscription");
                group.add(rg);
                return group;
            })
            .compare("""
                targetScope = 'subscription'

                @description('The location for the resource(s) to be deployed.')
                param location string = deployment().location

                resource rg-test 'Microsoft.Resources/resourceGroups@2024-03-01' = {
                  name: take('rg-test-${uniqueString(deployment().id)}', 90)
                  location: location
                }
                """)
            .lint()
            .validateAndDeployAsync();
        }
    }
}