package com.azure.provisioning;

import com.azure.provisioning.primitives.BicepErrorMessage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProvisioningPlanTests extends ProvisioningTestBase {

    public ProvisioningPlanTests(boolean async) {
        super(async);
    }

    @Test
    public void lintClean() {
        if (skipTools) { return; }

        StorageAccount resource = StorageResources.createAccount("storage");

        // Lint
        ProvisioningPlan plan = resource.build();
        List<BicepErrorMessage> messages = plan.lint();
        assertEquals(0, messages.size());
    }

    @Test
    public void lintWarn() {
        if (skipTools) { return; }

        BicepParameter param = new BicepParameter("endpoint", String.class);

        // Lint
        ProvisioningPlan plan = param.getParentInfrastructure().build();
        List<BicepErrorMessage> messages = plan.lint();

        // Make sure it warns about the unused param
        assertEquals(1, messages.size());
        assertFalse(messages.get(0).isError());
        assertEquals("no-unused-params", messages.get(0).getCode());
        assertTrue(messages.get(0).getMessage().contains("endpoint"));
    }

    @Test
    public void lintError() {
        if (skipTools) { return; }

        // Use a string as the default value for a param typed int
        BicepParameter param = new BicepParameter("bar", Integer.class);
        param.setValue("Hello, World.");

        ProvisioningPlan plan = param.getParentInfrastructure().build();
        List<BicepErrorMessage> messages = plan.lint();

        // Ignore the "unused param" first warning and make sure we get a type error
        assertEquals(2, messages.size());
        assertTrue(messages.get(1).isError());
        assertEquals("BCP033", messages.get(1).getCode());
        assertTrue(messages.get(1).getMessage().contains("int"));
    }

    @Test
    public void getArmTemplate() {
        if (skipTools) { return; }

        StorageAccount resource = StorageResources.createAccount("storage");

        ProvisioningPlan plan = resource.build();
        String arm = plan.compileArmTemplate();

        // Trim to just the resources section so we don't get tripped up
        // by generator version metadata that depends upon the locally
        // installed tool
        String resources = JsonParser.parseString(arm).getAsJsonObject().get("resources").toString();

        assertEquals(
            """
            [
                {
                  "type": "Microsoft.Storage/storageAccounts",
                  "apiVersion": "2023-01-01",
                  "name": "[take(format('storage{0}', uniqueString(resourceGroup().id)), 24)]",
                  "kind": "StorageV2",
                  "location": "[resourceGroup().location]",
                  "sku": {
                    "name": "Standard_LRS"
                  },
                  "properties": {
                    "allowBlobPublicAccess": false,
                    "isHnsEnabled": true
                  }
                }
              ]
            """,
            resources);
    }
}