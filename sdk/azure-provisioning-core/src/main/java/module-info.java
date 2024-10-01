module azure.provisioning.core {
    requires transitive com.azure.identity;
    requires transitive com.azure.resourcemanager;

    exports com.azure.provisioning;

}