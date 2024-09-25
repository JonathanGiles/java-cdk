package com.azure.provisioning.primitives;

import com.azure.provisioning.BicepOutput;
import com.azure.provisioning.BicepParameter;
import com.azure.provisioning.ProvisioningContext;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrderingInfrastructureResolver implements InfrastructureResolver {
    @Override
    public List<Provisionable> resolveResources(ProvisioningContext context, List<Provisionable> resources) {
        return resources.stream()
            .sorted(Comparator.comparingInt(construct -> {
                if (construct instanceof BicepParameter) {
                    return 0;
                } else if (construct instanceof BicepOutput) {
                    return 2;
                } else {
                    return 1;
                }
            }))
            .collect(Collectors.toList());
    }
}