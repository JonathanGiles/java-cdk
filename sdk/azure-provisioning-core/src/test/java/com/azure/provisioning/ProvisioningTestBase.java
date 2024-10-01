package com.azure.provisioning;

import org.junit.jupiter.api.BeforeEach;

public abstract class ProvisioningTestBase {
    protected boolean skipTools;
    protected boolean skipLiveCalls;

    protected ProvisioningTestBase(/*boolean async*/) {
        this(false, false, false);
    }

    protected ProvisioningTestBase(boolean async, boolean skipTools, boolean skipLiveCalls) {
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
}