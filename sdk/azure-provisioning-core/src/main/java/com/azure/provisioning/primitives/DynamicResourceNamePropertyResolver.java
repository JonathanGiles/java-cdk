package com.azure.provisioning.primitives;

import com.azure.provisioning.BicepValue;
import com.azure.provisioning.ProvisioningContext;
import com.azure.provisioning.expressions.BicepFunction;
import com.azure.resourcemanager.resources.models.ResourceGroup;

public class DynamicResourceNamePropertyResolver extends ResourceNamePropertyResolver {
    @Override
    public BicepValue<String> resolveName(ProvisioningContext context, Resource resource, ResourceNameRequirements requirements) {
//        String prefix = sanitizeText(resource.getResourceName(), requirements.getValidCharacters());
//        String separator = getSeparator(requirements.getValidCharacters());
//        BicepValue<String> suffix = getUniqueSuffix(context, resource);
//        return BicepFunction.take(BicepFunction.interpolate(prefix + separator + suffix), requirements.getMaxLength());
        throw new RuntimeException("Not implemented");
    }

    private String getSeparator(ResourceNameCharacters validCharacters) {
        if ((validCharacters.getValue() & ResourceNameCharacters.HYPHEN.getValue()) != 0) {
            return "-";
        } else if ((validCharacters.getValue() & ResourceNameCharacters.UNDERSCORE.getValue()) != 0) {
            return "_";
        } else if ((validCharacters.getValue() & ResourceNameCharacters.PERIOD.getValue()) != 0) {
            return ".";
        }
        return "";
    }

    protected BicepValue<String> getUniqueSuffix(ProvisioningContext context, Resource resource) {
//        return BicepFunction.getUniqueString(
//            !(resource instanceof ResourceGroup) ?
//                BicepFunction.getResourceGroup().getId() :
//                BicepFunction.getDeployment().getId()
//        );

        throw new RuntimeException("Not implemented");
    }
}