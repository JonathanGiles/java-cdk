package com.azure.provisioning.implementation.resolvers;

import com.azure.provisioning.ProvisioningOutput;
import com.azure.provisioning.ProvisioningParameter;
import com.azure.provisioning.ProvisioningContext;
import com.azure.provisioning.primitives.Provisionable;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrderingInfrastructureResolver implements InfrastructureResolver {
    @Override
    public List<Provisionable> resolveResources(ProvisioningContext context, List<Provisionable> resources) {
        return resources.stream()
            .sorted(Comparator.comparingInt(construct -> {
                if (construct instanceof ProvisioningParameter) {
                    return 0;
                } else if (construct instanceof ProvisioningOutput) {
                    return 2;
                } else {
                    return 1;
                }
            }))
            .collect(Collectors.toList());
    }
}