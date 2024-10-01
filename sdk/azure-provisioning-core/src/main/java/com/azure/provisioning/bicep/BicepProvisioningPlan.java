package com.azure.provisioning.bicep;

import com.azure.provisioning.Infrastructure;
import com.azure.provisioning.ProvisioningContext;
import com.azure.provisioning.ProvisioningPlan;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class BicepProvisioningPlan extends ProvisioningPlan {
    private static final Supplier<ExternalBicepTool> bicepTool = ExternalBicepTool::findBestTool;

    public BicepProvisioningPlan(Infrastructure infrastructure, ProvisioningContext context) {
        super(infrastructure, context);
    }

    @Override
    public List<BicepErrorMessage> lint() {
        return lint(null);
    }

    @Override
    public List<BicepErrorMessage> lint(String optionalDirectoryPath) {
        return withOptionalTempBicep(optionalDirectoryPath, bicepPath -> {
            try {
                return bicepTool.get().lint(bicepPath);
            } catch (ToolExecutionException e) {
                e.printStackTrace();
                return Collections.emptyList();
            }
        });
    }

    @Override
    public String compileArmTemplate() {
        return compileArmTemplate(null);
    }

    @Override
    public String compileArmTemplate(String optionalDirectoryPath) {
        return withOptionalTempBicep(optionalDirectoryPath, bicepTool.get()::getArmTemplate);
    }

    private <T> T withOptionalTempBicep(final String optionalPath, final Function<String, T> action) {
        String dirToCleanup = null;
        try {
            String path = optionalPath;
            if (path == null) {
                dirToCleanup = createTempDirectory();
                path = save(dirToCleanup).get(0);
            }
            return action.apply(path);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (dirToCleanup != null) {
                try {
                    Files.walk(Paths.get(dirToCleanup))
                            .sorted(Comparator.reverseOrder())
                            .map(Path::toFile)
                            .forEach(File::delete);
                } catch (IOException ignored) {
                }
            }
        }
    }

    private static String createTempDirectory() throws IOException {
        Path tempDirectory = Files.createTempDirectory("bicep");
        return tempDirectory.toString();
    }
}