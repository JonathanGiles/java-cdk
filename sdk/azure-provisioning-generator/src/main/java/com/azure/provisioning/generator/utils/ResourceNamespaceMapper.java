package com.azure.provisioning.generator.utils;

import com.azure.resourcemanager.appconfiguration.fluent.models.ConfigurationStoreInner;
import com.azure.resourcemanager.appconfiguration.fluent.models.KeyValueInner;
import com.azure.resourcemanager.appconfiguration.fluent.models.PrivateEndpointConnectionInner;
import com.azure.resourcemanager.appconfiguration.fluent.models.ReplicaInner;
import com.azure.resourcemanager.storage.fluent.models.*;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class ResourceNamespaceMapper {

    private static final Map<Type, String> RESOURCE_NAMESPACES = new HashMap<>() {{
        put(ConfigurationStoreInner.class, "Microsoft.AppConfiguration/configurationStores");
        put(KeyValueInner.class, "Microsoft.AppConfiguration/configurationStores/keyValues");
        put(ReplicaInner.class, "Microsoft.AppConfiguration/configurationStores/replicas");
        put(PrivateEndpointConnectionInner.class, "Microsoft.AppConfiguration/configurationStores/privateEndpointConnections");

        put(BlobContainerInner.class, "Microsoft.Storage/storageAccounts/blobServices/containers");
        put(BlobInventoryPolicyInner.class, "Microsoft.Storage/storageAccounts/inventoryPolicies");
        put(BlobServicePropertiesInner.class, "Microsoft.Storage/storageAccounts/blobServices");
        put(DeletedAccountInner.class, "Microsoft.Storage/locations/deletedAccounts");
        put(EncryptionScopeInner.class, "Microsoft.Storage/storageAccounts/encryptionScopes");
        put(FileServicePropertiesInner.class, "Microsoft.Storage/storageAccounts/fileServices");
        put(FileShareInner.class, "Microsoft.Storage/storageAccounts/fileServices/shares");
        put(ImmutabilityPolicyInner.class, "Microsoft.Storage/storageAccounts/blobServices/containers/immutabilityPolicies");
        put(ObjectReplicationPolicyInner.class, "Microsoft.Storage/storageAccounts/objectReplicationPolicies");
        put(QueueServicePropertiesInner.class, "Microsoft.Storage/storageAccounts/queueServices");
        put(LocalUserInner.class, "Microsoft.Storage/storageAccounts/localUsers");
        put(ManagementPolicyInner.class, "Microsoft.Storage/storageAccounts/managementPolicies");
        put(StorageAccountMigrationInner.class, "Microsoft.Storage/storageAccounts/accountMigrations");
        put(StorageAccountInner.class, "Microsoft.Storage/storageAccounts");
        put(StorageQueueInner.class, "Microsoft.Storage/storageAccounts/queueServices/queues");
        put(StorageTaskAssignmentInner.class, "Microsoft.Storage/storageAccounts/storageTaskAssignments");
        put(TableInner.class, "Microsoft.Storage/storageAccounts/tableServices/tables");
        put(TableServicePropertiesInner.class, "Microsoft.Storage/storageAccounts/tableServices");



    }};

    public static String getNamespace(Type armType) {
        return RESOURCE_NAMESPACES.get(armType);
    }

    private ResourceNamespaceMapper() {

    }
}
