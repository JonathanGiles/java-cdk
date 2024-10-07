package com.azure.provisioning.generator.specifications;

import com.azure.provisioning.generator.model.Specification;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Represents the specification for App Configuration in the Azure provisioning model.
 */
public class AppConfigurationSpecification extends Specification {
    private List<String> configurations;

    /**
     * Constructs a new AppConfigurationSpecification.
     *
     * @param name Name of the specification.
     * @param namespace Namespace of the specification.
     * @param configurations List of configurations.
     */
    public AppConfigurationSpecification(String name, String namespace, List<String> configurations) {
        super(name, namespace);
        this.configurations = configurations;
    }

    public AppConfigurationSpecification(String name, String namespace, Type armType, String description, String providerName, List<String> configurations) {
        super(name, namespace, armType, description, providerName);
        this.configurations = configurations;
    }

    /**
     * Gets the list of configurations.
     *
     * @return the list of configurations.
     */
    public List<String> getConfigurations() {
        return configurations;
    }

    /**
     * Sets the list of configurations.
     *
     * @param configurations the list of configurations.
     */
    public void setConfigurations(List<String> configurations) {
        this.configurations = configurations;
    }

    @Override
    public String getTypeReference() {
        return getName();
    }

    @Override
    protected void customize() {

    }
}