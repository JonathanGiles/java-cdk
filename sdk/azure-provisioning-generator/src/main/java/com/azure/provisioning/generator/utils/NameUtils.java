package com.azure.provisioning.generator.utils;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class NameUtils {
    private static final Pattern CASE_SPLIT = Pattern.compile("[_\\- ]");

    public static String toPascalCase(String name) {
        if (name == null || name.trim().isEmpty()) {
            return name;
        }

        // Preserve leading underscores and treat them like
        // uppercase characters by calling 'CamelCase()' on the rest.
        if (name.charAt(0) == '_') {
            return '_' + toCamelCase(name.substring(1));
        }

        return CASE_SPLIT.splitAsStream(name)
                .filter(s -> s != null && !s.isEmpty())
                .map(s -> formatCase(s, false))
                .collect(Collectors.joining());
    }

    public static String toCamelCase(String name) {
        if (name == null || name.trim().isEmpty()) {
            return name;
        }

        // Remove leading underscores.
        if (name.charAt(0) == '_') {
            return toCamelCase(name.substring(1));
        }

        String[] splits = CASE_SPLIT.split(name);
        if (splits.length == 0) {
            return "";
        }

        splits[0] = formatCase(splits[0], true);
        for (int i = 1; i != splits.length; i++) {
            splits[i] = formatCase(splits[i], false);
        }
        return String.join("", splits);
    }

    private static String formatCase(String name, boolean toLower) {
        if (name == null || name.isEmpty()) {
            return name;
        }

        int length = name.length();
        char c0 = name.charAt(0);
        if ((length < 2)
                || ((length == 2) && Character.isUpperCase(c0) && Character.isUpperCase(name.charAt(1)))) {
            return toLower ? name.toLowerCase() : name.toUpperCase();
        } else {
            return  (toLower ? Character.toLowerCase(c0) : Character.toUpperCase(c0)) + name.substring(1);
        }
    }

    private NameUtils() {

    }


}
