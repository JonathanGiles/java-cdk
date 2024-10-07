package com.azure.provisioning.generator.utils;

import com.azure.resourcemanager.appconfiguration.fluent.models.ConfigurationStoreInner;
import com.azure.resourcemanager.appconfiguration.fluent.models.KeyValueInner;
import com.azure.resourcemanager.appconfiguration.fluent.models.PrivateEndpointConnectionInner;
import com.azure.resourcemanager.appconfiguration.fluent.models.ReplicaInner;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class ResourceNamespaceMapper {

    private static final Map<Type, String> RESOURCE_NAMESPACES = new HashMap<>() {{
       put(ConfigurationStoreInner.class, "Microsoft.AppConfiguration/configurationStores");
       put(KeyValueInner.class, "Microsoft.AppConfiguration/configurationStores/keyValues");
       put(ReplicaInner.class, "Microsoft.AppConfiguration/configurationStores/replicas");
       put(PrivateEndpointConnectionInner.class, "Microsoft.AppConfiguration/configurationStores/privateEndpointConnections");
    }};

    public static String getNamespace(Type armType) {
        return RESOURCE_NAMESPACES.get(armType);
    }

    private ResourceNamespaceMapper() {

    }
}
