package com.azure.provisioning.generator.model;

import java.lang.reflect.Type;

public abstract class ModelBase {
    private Type armType;
    private String provisioningPackage;
    private String name;
    private String description;
    private Specification spec;
    private boolean isExternal;
    private String baseDir;

    public ModelBase(String name) {
        this.name = name;
    }

    public ModelBase(String name, String provisioningPackage) {
        this.name = name;
        this.provisioningPackage = provisioningPackage;
    }

    public ModelBase(String name, String provisioningPackage, Type armType, String description) {
        this.name = name;
        this.provisioningPackage = provisioningPackage;
        this.armType = armType;
        this.description = description;
        this.spec = null;
        this.isExternal = false;
    }

    public Type getArmType() {
        return armType;
    }

    public void setArmType(Type armType) {
        this.armType = armType;
    }

    public String getProvisioningPackage() {
        return provisioningPackage;
    }

    public void setProvisioningPackage(String provisioningPackage) {
        this.provisioningPackage = provisioningPackage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Specification getSpec() {
        return spec;
    }

    public void setSpec(Specification spec) {
        this.spec = spec;
    }

    public boolean isExternal() {
        return isExternal;
    }

    protected void setExternal(boolean isExternal) {
        this.isExternal = isExternal;
    }

    public void generate() {
        // Generate code for this model type.
    }

    public String getTypeReference() {
        return name;
    }

    /**
     * Check for common issues.
     */
    public void lint() {
        if (isExternal) {
            return;
        }
        if (name.contains("ACL")) {
            warn(getTypeReference() + " contains 'ACL'.");
        }
        // if (description == null) { warn("Missing a description."); }
    }

    /**
     * Print warnings.
     *
     * @param message The warning.
     */
    protected void warn(String message) {
        System.out.println("  >> " + getTypeReference() + ": " + message);
    }

    @Override
    public String toString() {
        return "<" + getTypeReference() + ">";
    }
}