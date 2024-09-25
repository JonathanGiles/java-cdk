package com.azure.provisioning;

import com.azure.core.test.annotation.AsyncOnly;
import com.azure.core.test.annotation.LiveOnly;
import com.azure.core.test.implementation.TestingHelpers;
import com.azure.core.test.utils.TestMode;
import com.azure.core.test.utils.TestResourceNamer;
import com.azure.core.util.Configuration;
import com.azure.core.util.logging.ClientLogger;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.provisioning.ProvisioningTestEnvironment;
import com.azure.provisioning.Primitives;
import com.azure.resourcemanager.AzureResourceManager;
import com.azure.resourcemanager.resources.models.ResourceGroup;
import com.azure.resourcemanager.resources.models.ResourceGroupInner;
import com.azure.resourcemanager.testframework.AzureTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

// FIXME
//@AsyncOnly
//@LiveOnly
//@ExtendWith(AzureTestBase.class)
public abstract class ProvisioningTestBase {//extends AzureTestBase<ProvisioningTestEnvironment> {
    protected boolean skipTools;
    protected boolean skipLiveCalls;

    protected ProvisioningTestBase(boolean async, boolean skipTools, boolean skipLiveCalls) {
//        super(async, TestMode.LIVE);
        this.skipTools = skipTools && skipLiveCalls;
        this.skipLiveCalls = skipLiveCalls;
    }

    @BeforeEach
    public void setup() {
        // Ignore the version of the AZ CLI used to generate the ARM template as this will differ based on the environment
//        addJsonPathSanitizer("$.._generator.version");
//        addJsonPathSanitizer("$.._generator.templateHash");
    }

    public Trycep createBicepTest() {
        return new Trycep(this);
    }
//
//    @Override
//    public void globalTimeoutTearDown() {
//        // Turn off global timeout errors because these tests can be much slower
//        // super.globalTimeoutTearDown();
//    }
}