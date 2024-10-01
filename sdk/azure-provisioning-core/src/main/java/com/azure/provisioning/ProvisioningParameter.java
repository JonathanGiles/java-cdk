package com.azure.provisioning;

import com.azure.provisioning.implementation.bicep.syntax.Expression;
import com.azure.provisioning.implementation.bicep.syntax.TypeExpression;
import com.azure.provisioning.implementation.bicep.syntax.BicepSyntax;
import com.azure.provisioning.implementation.bicep.syntax.Statement;
import com.azure.provisioning.implementation.bicep.syntax.ParameterStatement;

import java.util.Collections;
import java.util.List;

public class ProvisioningParameter extends ProvisioningVariable {
    private boolean isSecure = false;

    public boolean isSecure() {
        return isSecure || getValue().isSecure();
    }

    public void setSecure(boolean isSecure) {
        this.isSecure = isSecure;
    }

    public ProvisioningParameter(String name, Class<?> type) {
        this(name, type, null);
    }

    public ProvisioningParameter(String name, Class<?> type, ProvisioningContext context) {
        this(name, new TypeExpression(type), context);
    }

    public ProvisioningParameter(String name, Expression type) {
        this(name, type, null);
    }

    public ProvisioningParameter(String name, Expression type, ProvisioningContext context) {
        super(name, type, null, context);
    }

    @Override
    public List<Statement> compile(ProvisioningContext context) {
        ParameterStatement stmt = BicepSyntax.Declare.param(getResourceName(), getBicepType(), getValue().getKind() == BicepValueKind.UNSET ? null : getValue().compile());
        if (isSecure()) {
            stmt = BicepSyntax.decorate(stmt, "secure");
        }
        if (getDescription() != null) {
            stmt = BicepSyntax.decorate(stmt, "description", BicepSyntax.value(getDescription()));
        }
        return Collections.singletonList(stmt);
    }
}