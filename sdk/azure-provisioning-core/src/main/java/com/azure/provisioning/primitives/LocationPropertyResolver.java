package com.azure.provisioning.primitives;

import com.azure.core.AzureLocation;
import com.azure.provisioning.*;
import com.azure.provisioning.expressions.BicepFunction;
import com.azure.provisioning.expressions.TypeExpression;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LocationPropertyResolver extends PropertyResolver {

    @Override
    public void resolveProperties(ProvisioningContext context, ProvisioningConstruct construct) {
        BicepValueBase location = construct.getProvisioningProperties().get("Location");
        if (location != null) {
            if (location.getKind() == BicepValueKind.UNSET && !location.isOutput() &&
                (!(construct instanceof Resource) || !((Resource) construct).isExistingResource())) {
                BicepParameter param = getOrCreateLocationParameter(context, construct);
                construct.setProvisioningProperty("Location", param);
            }
        }
    }

    protected BicepValue<AzureLocation> getDefaultLocation(ProvisioningContext context, ProvisioningConstruct construct) {
        return !(construct instanceof ResourceGroup) ?
            BicepFunction.getResourceGroup().getLocation() :
            BicepFunction.getDeployment().getLocation();
    }

    private BicepParameter getOrCreateLocationParameter(ProvisioningContext context, ProvisioningConstruct construct) {
        BicepValue<AzureLocation> location = getDefaultLocation(context, construct);
        String expression = location.compile().toString();

        Infrastructure infra = Optional.ofNullable(construct.getParentInfrastructure())
            .orElseThrow(() -> new IllegalStateException("Construct must be added to an Infrastructure instance before resolving properties."));
        Map<String, BicepParameter> existing = new HashMap<>();
        infra.getResources().stream()
            .filter(BicepParameter.class::isInstance)
            .map(BicepParameter.class::cast)
            .filter(p -> p.getResourceName().startsWith("location"))
            .forEach(p -> existing.put(p.getResourceName(), p));

        for (BicepParameter p : existing.values()) {
            if (p.getBicepType() instanceof TypeExpression) {
                TypeExpression type = (TypeExpression) p.getBicepType();
                if (type.getType() == String.class && p.getValue().compile().toString().equals(expression)) {
                    return p;
                }
            }
        }

        String name = "location";
        if (existing.containsKey(name)) {
            boolean increment = true;

            if (construct instanceof NamedProvisioningConstruct) {
                NamedProvisioningConstruct resource = (NamedProvisioningConstruct) construct;
                name = name + "_" + resource.getResourceName();
                increment = existing.containsKey(name);
            }

            if (increment) {
                for (int i = 2; ; i++) {
                    String proposed = name + "_" + i;
                    if (!existing.containsKey(proposed)) {
                        name = proposed;
                        break;
                    }
                }
            }
        }

        BicepParameter param = new BicepParameter(name, String.class);
        param.setDescription("The location for the resource(s) to be deployed.");
        param.setValue(location);
        infra.add(param);
        return param;
    }
}