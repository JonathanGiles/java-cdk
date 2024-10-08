package com.azure.provisioning;

import com.azure.core.management.Region;
import com.azure.provisioning.bicep.BicepErrorMessage;
import com.azure.resourcemanager.AzureResourceManager;
import com.azure.provisioning.primitives.ProvisioningConstruct;
import com.azure.resourcemanager.resources.models.ResourceGroup;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class Trycep implements AutoCloseable {
    private final ProvisioningTestBase test;
    private Region resourceLocation = Region.US_WEST2;
    private TestProvisioningContextProvider contextProvider;
    private ProvisioningPlan plan;
    private Map<String, String> bicepModules;
    private String tempDir;
    private String armTemplate;
    private ResourceGroup resourceGroup;

    public Trycep(ProvisioningTestBase test) {
        this.test = test;
        this.contextProvider = new TestProvisioningContextProvider(test);
    }

    public Trycep define(ProvisioningConstruct resource) {
        ProvisioningContext.PROVIDER = contextProvider;
        plan = resource.getParentInfrastructure().orElse(contextProvider.getProvisioningContext().getDefaultInfrastructure()).build();
        return this;
    }

    public Trycep define(Consumer<Trycep> action) {
        ProvisioningContext.PROVIDER = contextProvider;
        action.accept(this);
        plan = contextProvider.getProvisioningContext().getDefaultInfrastructure().build();
        return this;
    }

    public Trycep define(Function<Trycep, Infrastructure> action) {
        plan = action.apply(this).build();
        return this;
    }

    private ProvisioningPlan getPlan() {
        if (plan == null) {
            throw new IllegalStateException("No ProvisioningPlan was provided. Did you call define?");
        }
        return plan;
    }

    public Trycep compare(File expectedBicepFile) {
        try {
            return compare(Files.readString(expectedBicepFile.toPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Trycep compare(String expectedBicep) {
        bicepModules = getPlan().compile();
        Assertions.assertEquals(1, bicepModules.size(), "Expected exactly one bicep module");
        String bicep = bicepModules.get("main.bicep");
        if (!expectedBicep.equals(bicep)) {
            System.out.println("Actual:");
            System.out.println(bicep);
        }
        Assertions.assertEquals(expectedBicep, bicep);
        return this;
    }

    public Trycep compare(Map<String, String> expectedBicepModules) {
        bicepModules = getPlan().compile();
        Assertions.assertEquals(expectedBicepModules.size(), bicepModules.size(), "Module count mismatch");
        for (String name : expectedBicepModules.keySet()) {
            String expected = expectedBicepModules.get(name);
            String actual = bicepModules.get(name);
            Assertions.assertNotNull(actual, "Module not found: " + name);
            if (!expected.equals(actual)) {
                System.out.println("Actual " + name + ":");
                System.out.println(actual);
            }
            Assertions.assertEquals(expected, actual, "Module content mismatch: " + name);
        }
        return this;
    }

    private void saveBicep() throws IOException {
        if (tempDir == null) {
            Path path = Files.createTempDirectory("bicep");
            tempDir = path.toString();
            plan.save(tempDir);
        }
    }

    private String getArmTemplate() throws IOException {
        if (test.skipTools) {
            return "";
        }
        if (armTemplate == null) {
            saveBicep();
            armTemplate = getPlan().compileArmTemplate(tempDir);
        }
        return armTemplate;
    }

    public Trycep compareArm(String expectedArm) throws IOException {
        if (test.skipTools) {
            return this;
        }
        String arm = getArmTemplate();
        if (!expectedArm.equals(arm)) {
            System.out.println("Actual:");
            System.out.println(arm);
        }
        Assertions.assertEquals(expectedArm, arm);
        return this;
    }

    public Trycep lint(Consumer<List<BicepErrorMessage>> check, List<String> ignore) throws IOException {
        if (test.skipTools) {
            return this;
        }
        saveBicep();
        List<BicepErrorMessage> messages = getPlan().lint(tempDir);
        if (check != null) {
            check.accept(messages);
        } else if (!messages.isEmpty()) {
            List<BicepErrorMessage> remaining = messages;
            if (ignore != null) {
                remaining.removeAll(ignore);
            }
            Assertions.assertTrue(remaining.isEmpty(), "Unexpected warnings: " + remaining);
        }
        return this;
    }

    private void createResourceGroup() {
        if (test.skipLiveCalls) {
            return;
        }
        if (resourceGroup != null) {
            return;
        }
        ProvisioningContext context = contextProvider.getProvisioningContext();
        AzureResourceManager client = context.getArmClient();
        String name = "rg-test-can-delete-" + UUID.randomUUID();
        resourceGroup = client.resourceGroups().define(name)
            .withRegion(resourceLocation)
            .create();
    }

    public void validate(Consumer<String> validate) {
        throw new RuntimeException("Not implemented");
//        if (test.skipLiveCalls) {
//            return;
//        }
//        ProvisioningPlan plan = getPlan();
//        createResourceGroup();
//        String result = plan.validateInResourceGroup(resourceGroup.name(), contextProvider.getProvisioningContext().getArmClient());
//        if (validate != null) {
//            validate.accept(result);
//        } else if (result != null) {
//            Assertions.fail("Validation failed: " + result);
//        }
    }

    public void deploy(Consumer<String> validate) {
        throw new RuntimeException("Not implemented");
//        if (test.skipLiveCalls) {
//            return;
//        }
//        ProvisioningPlan plan = getPlan();
//        createResourceGroup();
//        String result = plan.deployToResourceGroup(resourceGroup.name(), contextProvider.getProvisioningContext().getArmClient());
//        if (validate != null) {
//            validate.accept(result);
//        } else if (result != null) {
//            Assertions.fail("Deployment failed: " + result);
//        }
    }

    public void verifyLiveResource(Function<String, Boolean> validate) {
        if (test.skipLiveCalls) {
            return;
        }
        if (resourceGroup == null) {
            deploy(null);
        }
        validate.apply(resourceGroup.name());
    }

    public void validateAndDeploy(Function<String, Boolean> validate) {
        validate(null);
        deploy(null);
        if (validate != null) {
            verifyLiveResource(validate);
        }
    }

    @Override
    public void close() throws Exception {
        if (resourceGroup != null) {
            // FIXME there isn't a delete method on the ResourceGroup class that I am using
//            resourceGroup.delete();
            resourceGroup = null;
            throw new RuntimeException("Not implemented");
        }
        if (tempDir != null) {
            Files.delete(Paths.get(tempDir));
            tempDir = null;
        }
    }
}