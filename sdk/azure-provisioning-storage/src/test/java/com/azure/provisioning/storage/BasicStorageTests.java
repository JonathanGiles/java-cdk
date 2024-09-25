package com.azure.provisioning.storage;

import com.azure.provisioning.ProvisioningTestBase;
import com.azure.provisioning.storage.StorageResources;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BasicStorageTests extends ProvisioningTestBase {

    public BasicStorageTests(boolean async) {
        super(async);
    }

    @Test
    public void createDefault() {
        assertDoesNotThrow(() -> {
            try (Trycep test = createBicepTest()) {
                test.define(StorageResources.createAccount("storage"))
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
                        """)
                    .lint()
                    .validateAndDeployAsync();
            }
        });
    }

    @Test
    public void createSimpleBlobs() {
        assertDoesNotThrow(() -> {
            try (Trycep test = createBicepTest()) {
                test.define(ctx -> {
                    StorageAccount storage = StorageResources.createAccount("storage");
                    BlobService blobs = new BlobService("blobs");
                    blobs.setParent(storage);
                    blobs.setDependsOn(Collections.singletonList(storage));
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
                      dependsOn: [
                        storage
                      ]
                    }
                    """)
                .lint(Collections.singletonList("no-unnecessary-dependson"))
                .validateAndDeployAsync();
            }
        });
    }

    @Test
    public void addStorageRole() {
        assertDoesNotThrow(() -> {
            try (Trycep test = createBicepTest()) {
                test.define(ctx -> {
                    StorageAccount storage = StorageResources.createAccount("storage");
                    UserAssignedIdentity id = new UserAssignedIdentity("id");
                    storage.assignRole(StorageBuiltInRole.STORAGE_BLOB_DATA_READER, id);
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

                    resource id 'Microsoft.ManagedIdentity/userAssignedIdentities@2023-01-31' = {
                      name: take('id-${uniqueString(resourceGroup().id)}', 128)
                      location: location
                    }

                    resource storage_id_StorageBlobDataReader 'Microsoft.Authorization/roleAssignments@2022-04-01' = {
                      name: guid(storage.id, id.properties.principalId, subscriptionResourceId('Microsoft.Authorization/roleDefinitions', '2a2b9908-6ea1-4ae2-8e65-a410df84e7d1'))
                      properties: {
                        principalId: id.properties.principalId
                        roleDefinitionId: subscriptionResourceId('Microsoft.Authorization/roleDefinitions', '2a2b9908-6ea1-4ae2-8e65-a410df84e7d1')
                        principalType: 'ServicePrincipal'
                      }
                      scope: storage
                    }
                    """)
                .lint()
                .validateAndDeployAsync();
            }
        });
    }

    @Test
    public void addStorageRoleWithExplicitPrincipal() {
        assertDoesNotThrow(() -> {
            try (Trycep test = createBicepTest()) {
                test.define(ctx -> {
                    StorageAccount storage = StorageResources.createAccount("storage");
                    UserAssignedIdentity id = new UserAssignedIdentity("id");
                    storage.assignRole(StorageBuiltInRole.STORAGE_BLOB_DATA_READER, RoleManagementPrincipalType.SERVICE_PRINCIPAL, id.getPrincipalId());
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

                    resource id 'Microsoft.ManagedIdentity/userAssignedIdentities@2023-01-31' = {
                      name: take('id-${uniqueString(resourceGroup().id)}', 128)
                      location: location
                    }

                    resource storage_StorageBlobDataReader 'Microsoft.Authorization/roleAssignments@2022-04-01' = {
                      name: guid(storage.id, id.properties.principalId, subscriptionResourceId('Microsoft.Authorization/roleDefinitions', '2a2b9908-6ea1-4ae2-8e65-a410df84e7d1'))
                      properties: {
                        principalId: id.properties.principalId
                        roleDefinitionId: subscriptionResourceId('Microsoft.Authorization/roleDefinitions', '2a2b9908-6ea1-4ae2-8e65-a410df84e7d1')
                        principalType: 'ServicePrincipal'
                      }
                      scope: storage
                    }
                    """)
                .lint()
                .validateAndDeployAsync();
            }
        });
    }

    @Test
    public void getEndpoint() {
        assertDoesNotThrow(() -> {
            try (Trycep test = createBicepTest()) {
                test.define(ctx -> {
                    StorageAccount storage = StorageResources.createAccount("storage");
                    BlobService blobs = new BlobService("blobs");
                    blobs.setParent(storage);
                    new BicepOutput("blobs_endpoint", String.class).setValue(storage.getPrimaryEndpoints().getValue().getBlobUri());
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
                .validateAndDeployAsync();
            }
        });
    }

    @Test
    public void createStandardStorageAccount() {
        assertDoesNotThrow(() -> {
            try (Trycep test = createBicepTest()) {
                test.define(ctx -> {
                    BicepParameter storageAccountType = new BicepParameter("storageAccountType", String.class);
                    storageAccountType.setValue(StorageSkuName.STANDARD_LRS);
                    storageAccountType.setDescription("Storage Account type");

                    StorageAccount sa = new StorageAccount("sa");
                    sa.setSku(new StorageSku().setName(storageAccountType));
                    sa.setKind(StorageKind.STORAGE_V2);

                    new BicepOutput("storageAccountName", String.class).setValue(sa.getName());
                    new BicepOutput("storageAccountId", String.class).setValue(sa.getId());
                })
                .compare("""
                    @description('Storage Account type')
                    param storageAccountType string = 'Standard_LRS'

                    @description('The location for the resource(s) to be deployed.')
                    param location string = resourceGroup().location

                    resource sa 'Microsoft.Storage/storageAccounts@2023-01-01' = {
                      name: take('sa${uniqueString(resourceGroup().id)}', 24)
                      kind: 'StorageV2'
                      location: location
                      sku: {
                        name: storageAccountType
                      }
                    }

                    output storageAccountName string = sa.name

                    output storageAccountId string = sa.id
                    """)
                .lint()
                .validateAndDeployAsync();
            }
        });
    }

    @Test
    public void createStorageAccountAndContainer() {
        assertDoesNotThrow(() -> {
            try (Trycep test = createBicepTest()) {
                test.define(ctx -> {
                    BicepParameter containerName = new BicepParameter("containerName", String.class);
                    containerName.setValue("mycontainer");
                    containerName.setDescription("The container name.");

                    StorageAccount sa = new StorageAccount("sa");
                    sa.setSku(new StorageSku().setName(StorageSkuName.STANDARD_LRS));
                    sa.setKind(StorageKind.STORAGE_V2);
                    sa.setAccessTier(StorageAccountAccessTier.HOT);

                    BlobService blobs = new BlobService("blobs");
                    blobs.setParent(sa);

                    BlobContainer container = new BlobContainer("container", StorageAccount.ResourceVersions.V2023_01_01);
                    container.setParent(blobs);
                    container.setName(containerName);
                })
                .compare("""
                    @description('The container name.')
                    param containerName string = 'mycontainer'

                    @description('The location for the resource(s) to be deployed.')
                    param location string = resourceGroup().location

                    resource sa 'Microsoft.Storage/storageAccounts@2023-01-01' = {
                      name: take('sa${uniqueString(resourceGroup().id)}', 24)
                      kind: 'StorageV2'
                      location: location
                      sku: {
                        name: 'Standard_LRS'
                      }
                      properties: {
                        accessTier: 'Hot'
                      }
                    }

                    resource blobs 'Microsoft.Storage/storageAccounts/blobServices@2023-01-01' = {
                      name: 'default'
                      parent: sa
                    }

                    resource container 'Microsoft.Storage/storageAccounts/blobServices/containers@2023-01-01' = {
                      name: containerName
                      parent: blobs
                    }
                    """)
                .lint()
                .validateAndDeployAsync();
            }
        });
    }

    @Test
    public void createStorageAccountWithServiceEncryption() {
        assertDoesNotThrow(() -> {
            try (Trycep test = createBicepTest()) {
                test.define(ctx -> {
                    BicepParameter storageAccountType = new BicepParameter("storageAccountType", String.class);
                    storageAccountType.setValue(StorageSkuName.STANDARD_LRS);
                    storageAccountType.setDescription("Storage Account type");

                    StorageAccount sa = new StorageAccount("sa");
                    sa.setSku(new StorageSku().setName(storageAccountType));
                    sa.setKind(StorageKind.STORAGE);
                    sa.setEncryption(new StorageAccountEncryption()
                        .setKeySource(StorageAccountKeySource.STORAGE)
                        .setServices(new StorageAccountEncryptionServices()
                            .setBlob(new StorageEncryptionService().setEnabled(true))));

                    new BicepOutput("storageAccountName", String.class).setValue(sa.getName());
                    new BicepOutput("storageAccountId", String.class).setValue(sa.getId());
                })
                .compare("""
                    @description('Storage Account type')
                    param storageAccountType string = 'Standard_LRS'

                    @description('The location for the resource(s) to be deployed.')
                    param location string = resourceGroup().location

                    resource sa 'Microsoft.Storage/storageAccounts@2023-01-01' = {
                      name: take('sa${uniqueString(resourceGroup().id)}', 24)
                      kind: 'Storage'
                      location: location
                      sku: {
                        name: storageAccountType
                      }
                      properties: {
                        encryption: {
                          services: {
                            blob: {
                              enabled: true
                            }
                          }
                          keySource: 'Microsoft.Storage'
                        }
                      }
                    }

                    output storageAccountName string = sa.name

                    output storageAccountId string = sa.id
                    """)
                .lint()
                .validateAndDeployAsync();
            }
        });
    }

    @Test
    public void createFileShare() {
        assertDoesNotThrow(() -> {
            try (Trycep test = createBicepTest()) {
                test.define(ctx -> {
                    StorageAccount sa = new StorageAccount("sa", StorageAccount.ResourceVersions.V2023_01_01);
                    sa.setLocation(AzureLocation.WEST_US2);
                    sa.setSku(new StorageSku().setName(StorageSkuName.STANDARD_LRS));
                    sa.setKind(StorageKind.STORAGE_V2);

                    FileService files = new FileService("files");
                    files.setParent(sa);

                    FileShare share = new FileShare("share", StorageAccount.ResourceVersions.V2023_01_01);
                    share.setParent(files);
                    share.setName("photos");
                })
                .compare("""
                    resource sa 'Microsoft.Storage/storageAccounts@2023-01-01' = {
                      name: take('sa${uniqueString(resourceGroup().id)}', 24)
                      kind: 'StorageV2'
                      location: 'westus2'
                      sku: {
                        name: 'Standard_LRS'
                      }
                    }

                    resource files 'Microsoft.Storage/storageAccounts/fileServices@2023-01-01' = {
                      name: 'default'
                      parent: sa
                    }

                    resource share 'Microsoft.Storage/storageAccounts/fileServices/shares@2023-01-01' = {
                      name: 'photos'
                      parent: files
                    }
                    """)
                .lint()
                .validateAndDeployAsync();
            }
        });
    }
}