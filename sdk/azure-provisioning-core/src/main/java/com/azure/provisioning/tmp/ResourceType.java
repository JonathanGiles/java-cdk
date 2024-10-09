/*
Converted (temporarily) by Jonathan from:
https://github.com/Azure/azure-sdk-for-net/blob/main/sdk/core/Azure.Core/src/ResourceType.cs
*/

package com.azure.provisioning.tmp;

import java.util.Objects;

/**
 * Structure representing a resource type.
 * <p>
 * See <a href="https://docs.microsoft.com/en-us/azure/azure-resource-manager/management/resource-providers-and-types">Resource Providers and Types</a> for more info.
 */
public final class ResourceType {
    private static final String SEPARATOR = "/";
    public static final String RESOURCE_NAMESPACE = "Microsoft.Resources";

    public static final ResourceType TENANTS = new ResourceType(RESOURCE_NAMESPACE, "tenants", "Microsoft.Resources/tenants");
    public static final ResourceType SUBSCRIPTIONS = new ResourceType(RESOURCE_NAMESPACE, "subscriptions", "Microsoft.Resources/subscriptions");
    public static final ResourceType RESOURCE_GROUPS = new ResourceType(RESOURCE_NAMESPACE, "resourceGroups", "Microsoft.Resources/resourceGroups");
    public static final ResourceType PROVIDERS = new ResourceType(RESOURCE_NAMESPACE, "providers", "Microsoft.Resources/providers");

    private final String stringValue;
    private final String namespace;
    private final String type;

    /**
     * Initializes a new instance of the {@code ResourceType} class.
     *
     * @param resourceType The resource type string to convert.
     */
    public ResourceType(String resourceType) {
        if (resourceType == null || resourceType.trim().isEmpty()) {
            throw new IllegalArgumentException("resourceType cannot be null or whitespace");
        }

        int index = resourceType.indexOf(SEPARATOR);
        if (index == -1 || resourceType.length() < 3) {
            throw new IllegalArgumentException("Invalid resourceType format");
        }

        this.stringValue = resourceType;
        this.namespace = resourceType.substring(0, index);
        this.type = resourceType.substring(index + 1);
    }

    private ResourceType(String providerNamespace, String name) {
        this.namespace = providerNamespace;
        this.type = name;
        this.stringValue = providerNamespace + "/" + name;
    }

    private ResourceType(String providerNamespace, String name, String fullName) {
        this.namespace = providerNamespace;
        this.type = name;
        this.stringValue = fullName;
    }

    public ResourceType appendChild(String childType) {
        return new ResourceType(namespace, type + SEPARATOR + childType);
    }

    /**
     * Gets the last resource type name.
     *
     * @return The last resource type name.
     */
    public String getLastType() {
        return type.substring(type.lastIndexOf(SEPARATOR) + 1);
    }

    /**
     * Gets the resource type Namespace.
     *
     * @return The resource type Namespace.
     */
    public String getNamespace() {
        return namespace;
    }

    /**
     * Gets the resource Type.
     *
     * @return The resource Type.
     */
    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ResourceType that = (ResourceType) obj;
        return stringValue.equalsIgnoreCase(that.stringValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stringValue.toLowerCase());
    }

    @Override
    public String toString() {
        return stringValue;
    }
}