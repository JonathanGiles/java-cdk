package com.azure.provisioning.generator.utils;

import com.azure.core.management.ProxyResource;
import com.azure.core.util.ExpandableStringEnum;
import com.azure.provisioning.BicepList;
import com.azure.provisioning.generator.model.DictionaryModel;
import com.azure.provisioning.generator.model.ListModel;
import com.azure.provisioning.generator.model.Property;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

public class ReflectionUtils {

    public static boolean isSimpleType(Type type) {

        if (type.equals(String.class)
                || type.equals(Integer.class)
                || type.equals(Long.class)
                || type.equals(Double.class)
                || type.equals(Float.class)
                || type.equals(Boolean.class)
                || type.equals(Character.class)
                || type.equals(Byte.class)
                || type.equals(Short.class)
                || type.equals(Void.class)
                || type.equals(int.class)
                || type.equals(long.class)
                || type.equals(double.class)
                || type.equals(float.class)
                || type.equals(boolean.class)
                || type.equals(char.class)
                || type.equals(byte.class)
                || type.equals(short.class)
                || type.equals(void.class)) {
            return true;
        }
        return false;
    }

    public static boolean isResourceType(Class<?> type) {
        Class<?> currentType = type;
        while (currentType != Object.class) {
            if (currentType == ProxyResource.class) {
                return true;
            }
            currentType = currentType.getSuperclass();
        }
        return false;
    }

    public static boolean isPropertiesTypes(Field field) {
        return field.getName().endsWith("Properties");
    }

    public static boolean isEnumType(Class<?> type) {
        Class<?> currentType = type;
        if (type.isEnum()) {
            return true;
        }

        while (currentType != Object.class) {
            if (currentType == ExpandableStringEnum.class) {
                return true;
            }
            currentType = currentType.getSuperclass();
        }
        return false;
    }

    public static List<String> getEnumValues(Class<?> type) {
        if (type.isEnum()) {
            return Arrays.stream(type.getEnumConstants()).map(val -> val.toString()).collect(Collectors.toUnmodifiableList());
        }

        return Arrays.stream(type.getDeclaredFields())
                .map(field -> field.getName())
                .collect(Collectors.toUnmodifiableList());
    }

    public static Set<String> getImportPackages(Set<Property> properties) {
        return properties.stream()
                .filter(property -> !property.getPropertyType().getProvisioningPackage().equals("java.lang"))
                .flatMap(property -> {
                    List<String> imports = new ArrayList<>();
                    if (property.getPropertyType() instanceof ListModel) {
                        imports.add(List.class.getPackageName() + ".List");
                        imports.add(((ListModel) property.getPropertyType()).getElementType().getProvisioningPackage() + "." + ((ListModel) property.getPropertyType()).getElementType().getName());
                        imports.add("com.azure.provisioning.BicepList");
                        return imports.stream();
                    }
                    if (property.getPropertyType() instanceof DictionaryModel) {
                        imports.add(Map.class.getPackageName() + ".Map");
                        imports.add(((DictionaryModel) property.getPropertyType()).getElementType().getProvisioningPackage() + "." + ((DictionaryModel) property.getPropertyType()).getElementType().getName());
                        imports.add("com.azure.provisioning.BicepDictionary");
                        return imports.stream();
                    }
                    imports.add(property.getPropertyType().getProvisioningPackage() + "." + property.getPropertyType().getName());
                    return imports.stream();
                })
                .collect(Collectors.toSet());
    }

}
