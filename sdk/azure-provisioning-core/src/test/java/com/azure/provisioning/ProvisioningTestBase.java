//package com.azure.provisioning;
//
//import org.junit.jupiter.api.BeforeEach;
//
//// FIXME
////@AsyncOnly
////@LiveOnly
////@ExtendWith(AzureTestBase.class)
//public abstract class ProvisioningTestBase {//extends AzureTestBase<ProvisioningTestEnvironment> {
//    protected boolean skipTools;
//    protected boolean skipLiveCalls;
//
//    protected ProvisioningTestBase(boolean async) {
//        this(async, false, false);
//    }
//
//    protected ProvisioningTestBase(boolean async, boolean skipTools, boolean skipLiveCalls) {
////        super(async, TestMode.LIVE);
//        this.skipTools = skipTools && skipLiveCalls;
//        this.skipLiveCalls = skipLiveCalls;
//    }
//
//    @BeforeEach
//    public void setup() {
//        // Ignore the version of the AZ CLI used to generate the ARM template as this will differ based on the environment
////        addJsonPathSanitizer("$.._generator.version");
////        addJsonPathSanitizer("$.._generator.templateHash");
//    }
//
//    public Trycep createBicepTest() {
//        return new Trycep(this);
//    }
////
////    @Override
////    public void globalTimeoutTearDown() {
////        // Turn off global timeout errors because these tests can be much slower
////        // super.globalTimeoutTearDown();
////    }
//}