package com.azure.provisioning;

import com.azure.provisioning.expressions.Expression;
import com.azure.provisioning.expressions.TypeExpression;
import com.azure.provisioning.expressions.BicepSyntax;
import com.azure.provisioning.expressions.Statement;
import com.azure.provisioning.expressions.VariableStatement;
import com.azure.provisioning.primitives.NamedProvisioningConstruct;

import java.util.Collections;
import java.util.List;

public class BicepVariable extends NamedProvisioningConstruct {
    private BicepValueBase value;
    private String description;
    private final Expression bicepType;

    public BicepValueBase getValue() {
        return value;
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

    protected BicepVariable(String name, Expression type, BicepValue<Object> value, ProvisioningContext context) {
        super(name, context);
        this.bicepType = type;
        // FIXME "value" should be the name of the property, not a hardcoded string. C# uses `nameof` to determine this
        this.value = BicepValue.defineProperty(this, "value", null, BicepValue.from(value));
    }

    public BicepVariable(String name, Class<?> type, ProvisioningContext context) {
        this(name, new TypeExpression(type), null, context);
    }

    @Override
    public List<Statement> compile(ProvisioningContext context) {
        VariableStatement stmt = BicepSyntax.Declare.var(getResourceName(), value.compile());
        if (description != null) {
            stmt = BicepSyntax.decorate(stmt, "description", BicepSyntax.value(description));
        }
        return Collections.singletonList(stmt);
    }
}