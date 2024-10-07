package com.azure.provisioning.generator.model;

import java.util.List;

/**
 * Represents an enumeration model in the Azure provisioning model.
 */
public class EnumModel extends ModelBase {
    private final List<String> values;

    /**
     * Constructs a new EnumModel.
     *
     * @param name Name of the enum.
     * @param namespace Namespace of the enum.
     * @param values List of enum values.
     */
    public EnumModel(String name, String namespace, List<String> values) {
        super(name, namespace, null, null);
        this.values = values;
    }

    /**
     * Gets the list of enum values.
     *
     * @return the list of enum values.
     */
    public List<String> getValues() {
        return values;
    }

    @Override
    public String getTypeReference() {
        return getName();
    }
}