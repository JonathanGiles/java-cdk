package com.azure.provisioning.generator.model;

import com.azure.provisioning.generator.utils.IndentWriter;
import com.azure.provisioning.generator.utils.NameUtils;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Represents a resource in the Azure provisioning model.
 */
public class Resource extends TypeModel {
    private String resourceType;
    private String resourceNamespace;
    private String defaultResourceVersion;
    private List<String> resourceVersions;
    private NameRequirements nameRequirements;
    private boolean generateRoleAssignment = false;
    private Resource parentResource;
    private SimpleModel getKeysType;
    private boolean getKeysIsList;

    public Resource(Specification spec, Type armType) {
        super(spec, armType, ((Class<?>) armType).getSimpleName(), ((Class<?>) armType).getPackageName(), "");
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceNamespace() {
        return resourceNamespace;
    }

    public void setResourceNamespace(String resourceNamespace) {
        this.resourceNamespace = resourceNamespace;
    }

    public String getDefaultResourceVersion() {
        return defaultResourceVersion;
    }

    public void setDefaultResourceVersion(String defaultResourceVersion) {
        this.defaultResourceVersion = defaultResourceVersion;
    }

    public List<String> getResourceVersions() {
        return resourceVersions;
    }

    public void setResourceVersions(List<String> resourceVersions) {
        this.resourceVersions = resourceVersions;
    }

    public NameRequirements getNameRequirements() {
        return nameRequirements;
    }

    public void setNameRequirements(NameRequirements nameRequirements) {
        this.nameRequirements = nameRequirements;
    }

    public boolean isGenerateRoleAssignment() {
        return generateRoleAssignment;
    }

    public void setGenerateRoleAssignment(boolean generateRoleAssignment) {
        this.generateRoleAssignment = generateRoleAssignment;
    }

    public Resource getParentResource() {
        return parentResource;
    }

    public void setParentResource(Resource parentResource) {
        this.parentResource = parentResource;
    }

    public SimpleModel getGetKeysType() {
        return getKeysType;
    }

    public void setGetKeysType(SimpleModel getKeysType) {
        this.getKeysType = getKeysType;
    }

    public boolean isGetKeysIsList() {
        return getKeysIsList;
    }

    public void setGetKeysIsList(boolean getKeysIsList) {
        this.getKeysIsList = getKeysIsList;
    }

    @Override
    public String toString() {
        return "<Resource " + getSpec().getName() + "::" + getName() + ">";
    }

    @Override
    public void lint() {
        super.lint();
        if (defaultResourceVersion == null) {
            warn(resourceType + " has no DefaultResourceVersion.");
        } else if (resourceVersions == null) {
            warn(resourceType + " has no ResourceVersions.");
        }
    }

    @Override
    public void generate() {
        IndentWriter writer = new IndentWriter();
        String className = this.getName().replace("Inner", "") + "Resource";
        System.out.println("Generating resource " + className);
        writer.writeLine("// Copyright (c) Microsoft Corporation. All rights reserved.");
        writer.writeLine("// Licensed under the MIT License.");
        writer.writeLine();
        writer.writeLine("package " + this.getProvisioningPackage() + ";");
        writer.writeLine("public class " + className + " extends Resource {");
        writeProperties(writer);

        writeGetterSetterMethods(className, writer);
        writer.writeLine("}");
        this.getSpec().writeToFile(className, writer.toString());
    }

    private void writeGetterSetterMethods(String className, IndentWriter writer) {
        writer.indent();
        writer.writeLine();
        this.getProperties().forEach(property -> {
            writeGetter(writer, property);

            writer.writeLine();

            writeSetter(writer, property, className);
        });
        writer.unindent();
    }

    private void writeSetter(IndentWriter writer, Property property, String className) {
        writer.writeLine("public " + className + " set" + NameUtils.toPascalCase(property.getName()) + "(BicepValue<" + property.getPropertyType().getName() + "> " + property.getName() + ") {");
        writer.indent();
        writer.writeLine("this." + property.getName() + " = " + property.getName() + ";");
        writer.unindent();
        writer.writeLine("}");
    }

    private static void writeGetter(IndentWriter writer, Property property) {
        writer.writeLine("public BicepValue<" + property.getPropertyType().getName() + "> " + "get" + NameUtils.toPascalCase(property.getName()) + "() {");
        writer.indent();
        writer.writeLine("return this." + property.getName() + ";");
        writer.unindent();
        writer.writeLine("}");
    }

    private void writeProperties(IndentWriter writer) {
        writer.indent();
        writer.writeLine();
        this.getProperties().forEach(property -> {
            writer.writeLine("private BicepValue<" + property.getPropertyType().getName() + "> " + property.getName() + ";");
        });
        writer.unindent();
    }

    // Placeholder methods for collectNamespaces, warn, and fromExpression
    protected Set<String> collectNamespaces() {
        return new HashSet<>();
    }

    protected void warn(String message) {
        // Implementation for warning
    }

    protected boolean fromExpression() {
        return false;
    }
}