package com.azure.provisioning.implementation.bicep.syntax;

import com.azure.provisioning.BicepValue;
import com.azure.provisioning.ProvisioningVariable;
import com.azure.provisioning.primitives.ProvisioningConstruct;

import java.util.Arrays;

public class BicepFunction {

//    public static BicepValue<String> getUniqueString(BicepValue<String>... values) {
//        if (values.length < 1) {
//            throw new IllegalArgumentException("getUniqueString requires at least one value.");
//        }
//        final Expression[] expressions = Arrays.stream(values).map(BicepValue::compile).toArray(Expression[]::new);
//        return new BicepValue<>(BicepSyntax.call("uniqueString", expressions));
//    }
//
//    public static BicepValue<String> take(BicepValue<String> text, BicepValue<Integer> size) {
//        return new BicepValue<>(BicepSyntax.call("take", text.compile(), size.compile()));
//    }
//
//    public static BicepValue<String> createGuid(BicepValue<String>... values) {
//        if (values.length < 1) {
//            throw new IllegalArgumentException("createGuid requires at least one value.");
//        }
//        return new BicepValue<>(BicepSyntax.call("guid", Arrays.stream(values).map(BicepValue::compile).toArray(Expression[]::new)));
//    }
//
//    public static BicepValue<ResourceIdentifier> getSubscriptionResourceId(BicepValue<String>... values) {
//        if (values.length < 2) {
//            throw new IllegalArgumentException("getSubscriptionResourceId requires at least two values.");
//        }
//        return new BicepValue<>(BicepSyntax.call("subscriptionResourceId", Arrays.stream(values).map(BicepValue::compile).toArray(Expression[]::new)));
//    }
//
//    public static ArmDeployment getDeployment() {
//        return ArmDeployment.fromExpression(BicepSyntax.call("deployment"));
//    }
//
//    public static Subscription getSubscription() {
//        return Subscription.fromExpression(BicepSyntax.call("subscription"));
//    }

//    public static Tenant getTenant() {
//        return Tenant.fromExpression(BicepSyntax.call("tenant"));
//    }
//
//    public static ResourceGroup getResourceGroup() {
//        return ResourceGroup.fromExpression(BicepSyntax.call("resourceGroup"));
//    }

//    public static BicepValue<Object> parseJson(BicepValue<Object> value) {
//        return new BicepValue<>(BicepSyntax.call("json", value.compile()));
//    }
//

    public static BicepValue<String> asString(ProvisioningConstruct construct) {
        return asString(BicepValue.from(construct));
    }

    public static BicepValue<String> asString(BicepValue<Object> value) {
        BicepSyntax.call("string", value.compile());
        return null;
//        return BicepValue.from(BicepSyntax.call("string", value.compile()));
    }
//
//    public static BicepValue<String> toLower(BicepValue<Object> value) {
//        return new BicepValue<>(BicepSyntax.call("toLower", value.compile()));
//    }
//
//    public static BicepValue<String> toUpper(BicepValue<Object> value) {
//        return new BicepValue<>(BicepSyntax.call("toUpper", value.compile()));
//    }
//
//    public static BicepValue<String> concat(BicepValue<String>... values) {
//        if (values.length < 1) {
//            throw new IllegalArgumentException("concat requires at least one value.");
//        }
//        return new BicepValue<>(BicepSyntax.call("concat", Arrays.stream(values).map(BicepValue::compile).toArray(Expression[]::new)));
//    }

    public static BicepValue<String> interpolate(String format, Expression... args) {
        if (format == null) {
            return BicepSyntax.nullValue().toBicepValue();
        }

        BicepValue<Object>[] values = new BicepValue[args.length];
        for (int i = 0; i < args.length; i++) {
            Object arg = args[i];
            if (arg instanceof BicepValue) {
                throw new RuntimeException("HOW?!?");
//                values[i] = (BicepValue<Object>) arg;
            } else if (arg instanceof ProvisioningVariable) {
                throw new RuntimeException("HOW?!?");
//                values[i] = BicepSyntax.var(((ProvisioningVariable) arg).getIdentifierName());
            } else {
                values[i] = BicepValue.from(arg != null ? arg.toString() : "");
            }
        }

        BicepValue<String> result = BicepSyntax.interpolate(format, Arrays.stream(values).map(BicepValue::compile).toArray(Expression[]::new)).toBicepValue();
        result.setSecure(Arrays.stream(values).anyMatch(BicepValue::isSecure));

        return result;
    }
}