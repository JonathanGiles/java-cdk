//package com.azure.provisioning.storage;
//
//import com.azure.provisioning.ProvisioningContext;
//
//public class StorageResources {
//
//    /**
//     * Create a new Azure Storage account.
//     *
//     * @param resourceName The friendly name of the Storage account that by default is used as a prefix for the Azure name.
//     * @param context An optional ProvisioningContext.
//     * @param infrastructureVersion Determines the version of the resource to create. It always defaults to the latest, but you can hard code it for long term stability.
//     * @return A new StorageAccount instance.
//     */
//    public static StorageAccount createAccount(String resourceName, ProvisioningContext context, Integer infrastructureVersion) {
//        if (infrastructureVersion == null) {
//            infrastructureVersion = 2;
//        }
//
//        switch (infrastructureVersion) {
//            case 1:
//                return new StorageAccount(resourceName, context)
//                        .setKind(StorageKind.STORAGE_V2)
//                        .setSku(new StorageSku(StorageSkuName.STANDARD_LRS));
//            case 2:
//                return new StorageAccount(resourceName, context)
//                        .setKind(StorageKind.STORAGE_V2)
//                        .setSku(new StorageSku(StorageSkuName.STANDARD_LRS))
//                        .setHnsEnabled(true)
//                        .setAllowBlobPublicAccess(false);
//            default:
//                throw new IllegalArgumentException("Expected a value between 1 and 2 inclusive, not " + infrastructureVersion);
//        }
//    }
//}