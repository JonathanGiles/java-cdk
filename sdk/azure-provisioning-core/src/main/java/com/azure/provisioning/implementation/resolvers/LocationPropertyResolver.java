package com.azure.provisioning.implementation.resolvers;

import com.azure.core.management.Region;
import com.azure.provisioning.*;
import com.azure.provisioning.implementation.bicep.syntax.TypeExpression;
import com.azure.provisioning.primitives.NamedProvisioningConstruct;
import com.azure.provisioning.primitives.ProvisioningConstruct;
import com.azure.provisioning.primitives.Resource;

import java.util.HashMap;
import java.util.Map;

public class LocationPropertyResolver extends PropertyResolver {

    @Override
    public void resolveProperties(ProvisioningContext context, ProvisioningConstruct construct) {
        BicepValueBase location = construct.getProvisioningProperties().get("Location");
        if (location != null) {
            if (location.getKind() == BicepValueKind.UNSET && !location.isOutput() &&
                (!(construct instanceof Resource) || !((Resource) construct).isExistingResource())) {
                ProvisioningParameter param = getOrCreateLocationParameter(context, construct);
//                construct.setProvisioningProperty("Location", param);
                // FIXME this is a temporary implementation
                throw new RuntimeException("Not implemented");
            }
        }
    }

    protected BicepValue<Region> getDefaultLocation(ProvisioningContext context, ProvisioningConstruct construct) {
        // FIXME this is a temporary implementation
        throw new RuntimeException("Not implemented");
//        return !(construct instanceof ResourceGroup) ?
//            BicepFunction.getResourceGroup().getLocation() :
//            BicepFunction.getDeployment().getLocation();
    }

    private ProvisioningParameter getOrCreateLocationParameter(ProvisioningContext context, ProvisioningConstruct construct) {
        BicepValue<Region> location = getDefaultLocation(context, construct);
        String expression = location.compile().toString();

        Infrastructure infra = construct.getParentInfrastructure().orElseThrow(() -> new IllegalStateException("Construct must be added to an Infrastructure instance before resolving properties."));
        Map<String, ProvisioningParameter> existing = new HashMap<>();
        infra.getResources().stream()
            .filter(ProvisioningParameter.class::isInstance)
            .map(ProvisioningParameter.class::cast)
            .filter(p -> p.getIdentifierName().startsWith("location"))
            .forEach(p -> existing.put(p.getIdentifierName(), p));

        for (ProvisioningParameter p : existing.values()) {
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
                name = name + "_" + resource.getIdentifierName();
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

        ProvisioningParameter param = new ProvisioningParameter(name, String.class);
        param.setDescription("The location for the resource(s) to be deployed.");
        param.setValue(location);
        infra.add(param);
        return param;
    }
}