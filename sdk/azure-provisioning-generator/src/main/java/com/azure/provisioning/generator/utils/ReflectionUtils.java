package com.azure.provisioning.generator.utils;

import java.lang.reflect.Type;

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
}
