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
    private BicepValue<Object> value;
    private String description;
    private final Expression bicepType;

    public BicepValue<Object> getValue() {
        return value;
    }

    public void setValue(BicepValue<Object> value) {
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
        this.value = BicepValue.defineProperty(this, "value", null, value);
    }

    public BicepVariable(String name, Class<?> type, ProvisioningContext context) {
        this(name, new TypeExpression(type), null, context);
    }

    @Override
    protected List<Statement> compile(ProvisioningContext context) {
        VariableStatement stmt = BicepSyntax.Declare.var(getResourceName(), value.compile());
        if (description != null) {
            stmt = stmt.decorate("description", BicepSyntax.value(description));
        }
        return Collections.singletonList(stmt);
    }
}