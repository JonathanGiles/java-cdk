package com.azure.provisioning.primitives;

import com.azure.provisioning.expressions.BicepSyntax;
import com.azure.provisioning.expressions.Expression;

import java.util.Arrays;
import java.util.List;

public class BicepValueReference {
    private final ProvisioningConstruct construct;
    private final String propertyName;
    private final List<String> bicepPath;

    public BicepValueReference(ProvisioningConstruct construct, String propertyName, String... path) {
        this.construct = construct;
        this.propertyName = propertyName;
        this.bicepPath = path != null ? Arrays.asList(path) : null;
    }

    public ProvisioningConstruct getConstruct() {
        return construct;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public List<String> getBicepPath() {
        return bicepPath;
    }

    public Expression getReference() {
        if (!(construct instanceof NamedProvisioningConstruct)) {
            throw new UnsupportedOperationException("Cannot reference a construct without a name yet.");
        }

        NamedProvisioningConstruct named = (NamedProvisioningConstruct) construct;
        Expression target = BicepSyntax.var(named.getResourceName());
        if (bicepPath != null) {
            for (String segment : bicepPath) {
//                target = target.get(segment);
                throw new RuntimeException("Not implemented");
            }
        }
        return target;
    }

    @Override
    public String toString() {
        return "<" + getReference() + " from " + construct.getClass().getSimpleName() + "." + propertyName + ">";
    }
}