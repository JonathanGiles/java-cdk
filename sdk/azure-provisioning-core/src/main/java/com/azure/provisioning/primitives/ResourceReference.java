package com.azure.provisioning.primitives;

import com.azure.provisioning.BicepValue;
import com.azure.provisioning.BicepValueKind;
import com.azure.provisioning.implementation.bicep.syntax.BicepSyntax;

public class ResourceReference<T extends Resource> {
    private final BicepValue<String> reference;
    private T value;

    public ResourceReference(BicepValue<String> reference) {
        this.reference = reference;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
        reference.setKind(BicepValueKind.EXPRESSION);
        reference.setExpression(value == null ? BicepSyntax.nullValue() : BicepSyntax.var(value.getIdentifierName()));
    }

//    @EditorBrowsable(EditorBrowsableState.NEVER)
    public static <T extends Resource> ResourceReference<T> defineResource(
            Resource construct,
            String propertyName,
            String[] bicepPath,
            boolean isOutput,
            boolean isRequired,
            T defaultValue) {
        BicepValue<String> ref = BicepValue.defineProperty(construct, propertyName, bicepPath, isOutput, isRequired, false, null);
        ResourceReference<T> resource = new ResourceReference<>(ref);
        if (defaultValue != null) {
            resource.setValue(defaultValue);
        }
        return resource;
    }
}