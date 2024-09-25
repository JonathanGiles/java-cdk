package com.azure.provisioning.expressions;

import com.azure.core.*;
import com.azure.provisioning.BicepValue;
import com.azure.resourcemanager.resources.models.Tenant;

import java.util.Arrays;

public class BicepFunction {

    public static BicepValue<String> getUniqueString(BicepValue<String>... values) {
        if (values.length < 1) {
            throw new IllegalArgumentException("getUniqueString requires at least one value.");
        }
        return BicepSyntax.call("uniqueString", Arrays.stream(values).map(BicepValue::compile).toArray(Expression[]::new));
    }

    public static BicepValue<String> take(BicepValue<String> text, BicepValue<Integer> size) {
        return BicepSyntax.call("take", text.compile(), size.compile());
    }

    public static BicepValue<String> createGuid(BicepValue<String>... values) {
        if (values.length < 1) {
            throw new IllegalArgumentException("createGuid requires at least one value.");
        }
        return BicepSyntax.call("guid", Arrays.stream(values).map(BicepValue::compile).toArray(Expression[]::new));
    }

    public static BicepValue<ResourceIdentifier> getSubscriptionResourceId(BicepValue<String>... values) {
        if (values.length < 2) {
            throw new IllegalArgumentException("getSubscriptionResourceId requires at least two values.");
        }
        return BicepSyntax.call("subscriptionResourceId", Arrays.stream(values).map(BicepValue::compile).toArray(Expression[]::new));
    }

    public static ArmDeployment getDeployment() {
        return ArmDeployment.fromExpression(BicepSyntax.call("deployment"));
    }

    public static Subscription getSubscription() {
        return Subscription.fromExpression(BicepSyntax.call("subscription"));
    }

    public static Tenant getTenant() {
        return Tenant.fromExpression(BicepSyntax.call("tenant"));
    }

    public static ResourceGroup getResourceGroup() {
        return ResourceGroup.fromExpression(BicepSyntax.call("resourceGroup"));
    }

    public static BicepValue<Object> parseJson(BicepValue<Object> value) {
        return BicepSyntax.call("json", value.compile());
    }

    public static BicepValue<String> asString(BicepValue<Object> value) {
        return BicepSyntax.call("string", value.compile());
    }

    public static BicepValue<String> toLower(BicepValue<Object> value) {
        return BicepSyntax.call("toLower", value.compile());
    }

    public static BicepValue<String> toUpper(BicepValue<Object> value) {
        return BicepSyntax.call("toUpper", value.compile());
    }

    public static BicepValue<String> concat(BicepValue<String>... values) {
        if (values.length < 1) {
            throw new IllegalArgumentException("concat requires at least one value.");
        }
        return BicepSyntax.call("concat", Arrays.stream(values).map(BicepValue::compile).toArray(Expression[]::new));
    }

    public static BicepValue<String> interpolate(FormattableString text) {
        if (text == null) {
            return BicepSyntax.nullValue();
        }

        BicepValue<Object>[] values = new BicepValue[text.getArgumentCount()];
        for (int i = 0; i < text.getArgumentCount(); i++) {
            Object arg = text.getArgument(i);
            if (arg instanceof BicepValue) {
                values[i] = (BicepValue<Object>) arg;
            } else if (arg instanceof BicepVariable) {
                values[i] = BicepSyntax.var(((BicepVariable) arg).getResourceName());
            } else {
                values[i] = new BicepValue<>(arg != null ? arg.toString() : "");
            }
        }

        BicepValue<String> result = BicepSyntax.interpolate(text.getFormat(), Arrays.stream(values).map(BicepValue::compile).toArray(Expression[]::new));
        result.setSecure(Arrays.stream(values).anyMatch(BicepValue::isSecure));

        return result;
    }
}