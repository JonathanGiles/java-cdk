package com.azure.provisioning;

import com.azure.provisioning.expressions.*;

import java.util.Collections;
import java.util.List;

public class BicepOutput extends BicepVariable {
    /**
     * Creates a new BicepOutput.
     *
     * @param name Name of the output.
     * @param type Type of the output.
     * @param context Optional provisioning context.
     */
    public BicepOutput(String name, Expression type, ProvisioningContext context) {
        super(name, type, null, context);
    }

    /**
     * Creates a new BicepOutput.
     *
     * @param name Name of the output.
     * @param type Type of the output.
     * @param context Optional provisioning context.
     */
    public BicepOutput(String name, Class<?> type, ProvisioningContext context) {
        this(name, new TypeExpression(type), context);
    }

    @Override
    public List<Statement> compile(ProvisioningContext context) {
        OutputStatement stmt = BicepSyntax.Declare.output(getResourceName(), getBicepType(), getValue().compile());
        if (getDescription() != null) {
            stmt = BicepSyntax.decorate(stmt, "description", BicepSyntax.value(getDescription()));
        }
        return Collections.singletonList(stmt);
    }
}