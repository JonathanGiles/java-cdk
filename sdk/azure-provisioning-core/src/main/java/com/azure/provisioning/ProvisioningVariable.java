package com.azure.provisioning;

import com.azure.provisioning.implementation.bicep.syntax.Expression;
import com.azure.provisioning.implementation.bicep.syntax.TypeExpression;
import com.azure.provisioning.implementation.bicep.syntax.BicepSyntax;
import com.azure.provisioning.implementation.bicep.syntax.Statement;
import com.azure.provisioning.implementation.bicep.syntax.VariableStatement;
import com.azure.provisioning.primitives.NamedProvisioningConstruct;

import java.util.Collections;
import java.util.List;

public class ProvisioningVariable extends NamedProvisioningConstruct {
    private BicepValueBase value;
    private String description;
    private final Expression bicepType;

    public BicepValueBase getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value.assign(BicepValue.from(value));
    }

    public void setValue(BicepValueBase value) {
        this.value.assign(value);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Expression getBicepType() {
        return bicepType;
    }

    protected ProvisioningVariable(String name, Expression type, BicepValue<Object> value) {
        super(name);
        this.bicepType = type;
        this.value = BicepValue.defineProperty(this, "Value", null, value == null ? null : BicepValue.from(value));
    }

    public ProvisioningVariable(String name, Class<?> type) {
        this(name, new TypeExpression(type), null);
    }

    @Override
    public List<Statement> compile(ProvisioningContext context) {
        VariableStatement stmt = BicepSyntax.Declare.var(getIdentifierName(), value.compile());
        if (description != null) {
            stmt = BicepSyntax.decorate(stmt, "description", BicepSyntax.value(description));
        }
        return Collections.singletonList(stmt);
    }
}