package com.azure.provisioning.generator.model;

import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.util.List;

public class Property {
    private final TypeModel parent;
    private Field armMember;
    private final Parameter armParameter;
    private String name;
    private ModelBase propertyType;
    private String description;
    private List<String> path;
    private boolean isReadOnly;
    private boolean isRequired;
    private boolean isSecure;
    private boolean generateDefaultValue;
    private boolean hideAccessors;


    public Property(TypeModel parent, ModelBase propertyType) {
        this(parent, propertyType, null, null);
    }

    public Property(TypeModel parent, ModelBase propertyType, Field armMember, Parameter armParameter) {
        this.parent = parent;
        this.armMember = armMember;
        this.armParameter = armParameter;
        this.name = armParameter != null ? toPascalCase(armParameter.getName()) : toPascalCase(armMember.getName());
        this.propertyType = propertyType;
        this.description = parent.getSpec().getDocComments();
        this.isReadOnly = false;
        this.isRequired = false;
        this.isSecure = false;
        this.generateDefaultValue = false;
        this.hideAccessors = false;
    }

    public TypeModel getParent() {
        return parent;
    }

    public Field getArmMember() {
        return armMember;
    }

    public void setArmMember(Field armMember) {
        this.armMember = armMember;
    }

    public Parameter getArmParameter() {
        return armParameter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ModelBase getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(ModelBase propertyType) {
        this.propertyType = propertyType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getPath() {
        return path;
    }

    public void setPath(List<String> path) {
        this.path = path;
    }

    public boolean isReadOnly() {
        return isReadOnly;
    }

    public void setReadOnly(boolean readOnly) {
        isReadOnly = readOnly;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean required) {
        isRequired = required;
    }

    public boolean isSecure() {
        return isSecure;
    }

    public void setSecure(boolean secure) {
        isSecure = secure;
    }

    public boolean isGenerateDefaultValue() {
        return generateDefaultValue;
    }

    public void setGenerateDefaultValue(boolean generateDefaultValue) {
        this.generateDefaultValue = generateDefaultValue;
    }

    public boolean isHideAccessors() {
        return hideAccessors;
    }

    public void setHideAccessors(boolean hideAccessors) {
        this.hideAccessors = hideAccessors;
    }

    public String getFieldName() {
        return "_" + toCamelCase(name);
    }

    public String getBicepTypeReference() {
        return getBicepType(propertyType);
    }

    private static String getBicepType(ModelBase type) {
        if (type == null) {
            return "BicepValue<Object>";
        } else if (type instanceof DictionaryModel && isCollection(((DictionaryModel) type).getElementType())) {
            return "BicepDictionary<" + getBicepType(((DictionaryModel) type).getElementType()) + ">";
        } else if (type instanceof DictionaryModel) {
            return "BicepDictionary<" + ((DictionaryModel) type).getElementType().getTypeReference() + ">";
        } else if (type instanceof ListModel && isCollection(((ListModel) type).getElementType())) {
            return "BicepList<" + getBicepType(((ListModel) type).getElementType()) + ">";
        } else if (type instanceof ListModel) {
            return "BicepList<" + ((ListModel) type).getElementType().getTypeReference() + ">";
        } else {
            return "BicepValue<" + type.getTypeReference() + ">";
        }
    }

    private static boolean isCollection(ModelBase type) {
        return type instanceof DictionaryModel || type instanceof ListModel;
    }

    private static String toPascalCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private static String toCamelCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    @Override
    public String toString() {
        return "<Property " + (parent != null ? parent.getSpec().getName() : "") + "::" + (parent != null ? parent.getName() : "") + "." + name + " : " + (propertyType != null ? propertyType.getName() : "") + ">";
    }
}