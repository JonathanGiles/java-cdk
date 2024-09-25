package com.azure.provisioning;

import com.azure.provisioning.expressions.Expression;
import com.azure.provisioning.expressions.TypeExpression;
import com.azure.provisioning.expressions.BicepSyntax;
import com.azure.provisioning.expressions.Statement;
import com.azure.provisioning.expressions.ParameterStatement;

import java.util.Collections;
import java.util.List;

public class BicepParameter extends BicepVariable {
    private boolean isSecure = false;

    public boolean isSecure() {
        return isSecure || getValue().isSecure();
    }

    public void setSecure(boolean isSecure) {
        this.isSecure = isSecure;
    }

    public BicepParameter(String name, Expression type, ProvisioningContext context) {
        super(name, type, null, context);
    }

    public BicepParameter(String name, Class<?> type, ProvisioningContext context) {
        this(name, new TypeExpression(type), context);
    }

    @Override
    protected List<Statement> compile(ProvisioningContext context) {
        ParameterStatement stmt = BicepSyntax.Declare.param(getResourceName(), getBicepType(), getValue().getKind() == BicepValueKind.UNSET ? null : getValue().compile());
        if (isSecure()) {
            stmt = stmt.decorate("secure");
        }
        if (getDescription() != null) {
            stmt = stmt.decorate("description", BicepSyntax.value(getDescription()));
        }
        return Collections.singletonList(stmt);
    }
}