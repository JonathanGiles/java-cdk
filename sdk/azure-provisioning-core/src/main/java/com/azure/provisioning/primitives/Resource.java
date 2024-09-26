package com.azure.provisioning.primitives;

import com.azure.provisioning.BicepValue;
import com.azure.provisioning.BicepValueBase;
import com.azure.provisioning.ProvisioningContext;
import com.azure.provisioning.ProvisioningPlan;
import com.azure.provisioning.expressions.*;
import com.azure.provisioning.expressions.Expression;
import com.azure.provisioning.expressions.Statement;

import java.beans.*;
import java.util.*;

public abstract class Resource extends NamedProvisioningConstruct {
    private final ResourceType resourceType;
    private String resourceVersion;
    private boolean isExistingResource = false;
    private final List<Resource> dependsOn = new ArrayList<>();

    public Resource(String resourceName, ResourceType resourceType, String resourceVersion, ProvisioningContext context) {
        super(resourceName, context);
        this.resourceType = resourceType;
        this.resourceVersion = resourceVersion;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public String getResourceVersion() {
        return resourceVersion;
    }

    public void setResourceVersion(String resourceVersion) {
        this.resourceVersion = resourceVersion;
    }

    public boolean isExistingResource() {
        return isExistingResource;
    }

    protected void setExistingResource(boolean existingResource) {
        isExistingResource = existingResource;
    }

    public List<Resource> getDependsOn() {
        return dependsOn;
    }

    public ProvisioningPlan build(ProvisioningContext context) {
//        if (context == null) {
//            context = getDefaultProvisioningContext();
//        }
        return context.getDefaultInfrastructure().build(context);
    }

    @Override
    public void validate(ProvisioningContext context) {
        super.validate(context);

        if (resourceVersion == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " resource " + getResourceName() + " must have resourceVersion specified.");
        }

        if (!dependsOn.isEmpty() && (isExistingResource || getExpressionOverride() != null)) {
            throw new IllegalStateException(getClass().getSimpleName() + " resource " + getResourceName() + " cannot have dependencies if it's an existing resource or an expression override.");
        }

        if (isExistingResource) {
            BicepValueBase name = getProvisioningProperties().get("Name");
            if (name != null && name.isRequired()) {
                requireProperty(name);
            }
        } else {
            validateProperties();
        }
    }

    @Override
    public List<Statement> compile(ProvisioningContext context) {
        if (getExpressionOverride() != null) {
            return Collections.singletonList(new ExprStatement(getExpressionOverride()));
        }

        Expression body = compileProperties();

        if (!dependsOn.isEmpty()) {
            if (!(body instanceof ObjectExpression)) {
                throw new IllegalStateException(getClass().getSimpleName() + " resource " + getResourceName() + " cannot have dependencies if it's an existing resource or an expression override.");
            }

            ArrayExpression dependencies = new ArrayExpression(dependsOn.stream().map(r -> BicepSyntax.var(r.getResourceName())).toArray(Expression[]::new));
            body = new ObjectExpression(((ObjectExpression) body).addProperty(new PropertyExpression("dependsOn", dependencies)));
        }

        ResourceStatement resource = BicepSyntax.declareResource(getResourceName(), resourceType + "@" + resourceVersion, body);
        if (isExistingResource) {
            resource.setExisting(true);
        }

        return Collections.singletonList(resource);
    }

//    @EditorBrowsable(EditorBrowsableState.NEVER)
    public ResourceNameRequirements getResourceNameRequirements() {
        return new ResourceNameRequirements(1, 24, ResourceNameCharacters.LOWERCASE_LETTERS);
    }
}