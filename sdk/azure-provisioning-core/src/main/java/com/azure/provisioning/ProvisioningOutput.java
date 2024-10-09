package com.azure.provisioning;

import com.azure.provisioning.implementation.bicep.syntax.*;

import java.util.Collections;
import java.util.List;

public class ProvisioningOutput extends ProvisioningVariable {
    /**
     * Creates a new BicepOutput.
     *
     * @param name Name of the output.
     * @param type Type of the output.
     */
    public ProvisioningOutput(String name, Expression type) {
        super(name, type, null);
    }

    /**
     * Creates a new BicepOutput.
     *
     * @param name Name of the output.
     * @param type Type of the output.
     * @param context Optional provisioning context.
     */
    public ProvisioningOutput(String name, Class<?> type) {
        this(name, new TypeExpression(type));
    }

    @Override
    public List<Statement> compile(ProvisioningContext context) {
        OutputStatement stmt = BicepSyntax.Declare.output(getIdentifierName(), getBicepType(), getValue().compile());
        if (getDescription() != null) {
            stmt = BicepSyntax.decorate(stmt, "description", BicepSyntax.value(getDescription()));
        }
        return Collections.singletonList(stmt);
    }
}