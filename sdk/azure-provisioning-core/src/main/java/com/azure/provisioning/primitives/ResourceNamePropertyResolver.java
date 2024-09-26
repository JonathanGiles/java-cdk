package com.azure.provisioning.primitives;

import com.azure.provisioning.BicepValue;
import com.azure.provisioning.BicepValueBase;
import com.azure.provisioning.BicepValueKind;
import com.azure.provisioning.ProvisioningContext;

public abstract class ResourceNamePropertyResolver extends PropertyResolver {
    @Override
    public void resolveProperties(ProvisioningContext context, ProvisioningConstruct construct) {
        if (!(construct instanceof Resource)) {
            return;
        }

        Resource resource = (Resource) construct;
        BicepValueBase name = resource.getProvisioningProperties().get("Name");
        if (name != null && name.getKind() == BicepValueKind.UNSET && !name.isOutput()) {
            BicepValue<String> resolved = resolveName(context, resource, resource.getResourceNameRequirements());
            if (resolved != null) {
                construct.setProvisioningProperty(name, resolved);
            }
        }
    }

    public abstract BicepValue<String> resolveName(ProvisioningContext context, Resource resource, ResourceNameRequirements requirements);

    protected static String sanitizeText(String text, ResourceNameCharacters validCharacters) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        StringBuilder builder = new StringBuilder(text.length());
        for (char ch : text.toCharArray()) {
            if ((validCharacters.getValue() & ResourceNameCharacters.LOWERCASE_LETTERS.getValue()) != 0 && Character.isLowerCase(ch) ||
                (validCharacters.getValue() & ResourceNameCharacters.UPPERCASE_LETTERS.getValue()) != 0 && Character.isUpperCase(ch) ||
                (validCharacters.getValue() & ResourceNameCharacters.NUMBERS.getValue()) != 0 && Character.isDigit(ch) ||
                (validCharacters.getValue() & ResourceNameCharacters.HYPHEN.getValue()) != 0 && ch == '-' ||
                (validCharacters.getValue() & ResourceNameCharacters.UNDERSCORE.getValue()) != 0 && ch == '_' ||
                (validCharacters.getValue() & ResourceNameCharacters.PERIOD.getValue()) != 0 && ch == '.' ||
                (validCharacters.getValue() & ResourceNameCharacters.PARENTHESES.getValue()) != 0 && (ch == '(' || ch == ')')) {
                builder.append(ch);
            } else if ((validCharacters.getValue() & ResourceNameCharacters.LOWERCASE_LETTERS.getValue()) != 0 && Character.isUpperCase(ch)) {
                builder.append(Character.toLowerCase(ch));
            } else if ((validCharacters.getValue() & ResourceNameCharacters.UPPERCASE_LETTERS.getValue()) != 0 && Character.isLowerCase(ch)) {
                builder.append(Character.toUpperCase(ch));
            }
        }
        return builder.toString();
    }
}