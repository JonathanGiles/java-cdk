package com.azure.provisioning.implementation.resolvers;

import com.azure.provisioning.BicepValue;
import com.azure.provisioning.ProvisioningContext;
import com.azure.provisioning.primitives.Resource;
import com.azure.provisioning.primitives.ResourceNameCharacters;
import com.azure.provisioning.primitives.ResourceNameRequirements;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StaticResourceNamePropertyResolver extends ResourceNamePropertyResolver {
    private static final char[] LOWER = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] DIGITS = "0123456789".toCharArray();

    @Override
    public BicepValue<String> resolveName(ProvisioningContext context, Resource resource, ResourceNameRequirements requirements) {
        StringBuilder name = new StringBuilder(requirements.getMaxLength());

        name.append(sanitizeText(resource.getIdentifierName(), requirements.getValidCharacters()));
        if (name.length() >= requirements.getMaxLength()) {
            return new BicepValue<>(name.substring(0, requirements.getMaxLength()));
        }

        if ((requirements.getValidCharacters().getValue() & ResourceNameCharacters.HYPHEN.getValue()) != 0) {
            name.append('-');
        } else if ((requirements.getValidCharacters().getValue() & ResourceNameCharacters.UNDERSCORE.getValue()) != 0) {
            name.append('_');
        } else if ((requirements.getValidCharacters().getValue() & ResourceNameCharacters.PERIOD.getValue()) != 0) {
            name.append('.');
        }

        List<Character> chars = new ArrayList<>();
        if ((requirements.getValidCharacters().getValue() & ResourceNameCharacters.LOWERCASE_LETTERS.getValue()) != 0) {
            for (char c : LOWER) {
                chars.add(c);
            }
        }
        if ((requirements.getValidCharacters().getValue() & ResourceNameCharacters.UPPERCASE_LETTERS.getValue()) != 0) {
            for (char c : UPPER) {
                chars.add(c);
            }
        }
        if ((requirements.getValidCharacters().getValue() & ResourceNameCharacters.NUMBERS.getValue()) != 0) {
            for (char c : DIGITS) {
                chars.add(c);
            }
        }

        Random random = new Random();
        while (name.length() < requirements.getMaxLength()) {
            name.append(chars.get(random.nextInt(chars.size())));
        }

        return new BicepValue<>(name.toString());
    }
}