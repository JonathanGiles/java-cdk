package com.azure.provisioning.primitives;

import com.azure.provisioning.Lazy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AzCliBicepTool extends ExternalBicepTool {
    private static final String AZ_CLI_NAME = System.getProperty("os.name").startsWith("Windows") ? "az.cmd" : "az";

    private static final Lazy<String> AZ_CLI_PATH = new Lazy<>(() -> {
        try {
            return findPath(AZ_CLI_NAME).orElseThrow(() -> new IllegalStateException("Azure CLI `" + AZ_CLI_NAME + "` not found on PATH."));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    });

    @Override
    public String getToolFullPath() {
        return AZ_CLI_PATH.getValue();
    }

    @Override
    protected String getLinterArguments(String bicepPath) {
        return "bicep lint --file " + bicepPath;
    }

    @Override
    protected String getArmBuildArguments(String bicepPath) {
        return "bicep build --file " + bicepPath + " --stdout";
    }
}