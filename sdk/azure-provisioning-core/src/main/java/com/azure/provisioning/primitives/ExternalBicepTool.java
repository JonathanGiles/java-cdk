package com.azure.provisioning.primitives;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class ExternalBicepTool {
    public abstract String getToolFullPath();
    protected abstract String getLinterArguments(String bicepPath);
    protected abstract String getArmBuildArguments(String bicepPath);

    public static ExternalBicepTool findBestTool() {
        return new AzCliBicepTool();
    }

    public List<BicepErrorMessage> lint(String bicepPath) {
        List<BicepErrorMessage> messages = new ArrayList<>();
        try {
            ToolResult result = runAndBlock(getToolFullPath(), getLinterArguments(bicepPath));
            if (result.getExitCode() != 0 && result.getExitCode() != 1) {
                throw new IllegalStateException("Linting failed with exit code " + result.getExitCode() + " and error: " + result.getError().get());
            }

            try (BufferedReader reader = new BufferedReader(new StringReader(result.getError().orElse("")))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (!line.isEmpty()) {
                        messages.add(new BicepErrorMessage(line));
                    }
                }
            }
        } catch (IOException e) {
            //fixme
            e.printStackTrace();
        }
        return messages;
    }

    public String getArmTemplate(String bicepPath) {
        try {
            ToolResult result = runAndBlock(getToolFullPath(), getArmBuildArguments(bicepPath));
            if (result.getExitCode() != 0 || result.getOutput().isPresent()) {
                throw new IllegalStateException("Building ARM Template failed with exit code " + result.getExitCode() + " and error: " + result.getError().get());
            }
            return result.getOutput().orElse("");
        } catch (IOException e) {
            // FIXME
            e.printStackTrace();
        }
        return "";
    }

    private static ToolResult runAndBlock(String path, String arguments) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(path, arguments); // FIXME this might not be right
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        String output;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            output = reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }
        int exitCode = 0;
        try {
            exitCode = process.waitFor();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new ToolResult(exitCode, output, null);
    }

    protected static Optional<String> findPath(String toolName) throws IOException {
        String[] paths = System.getenv("PATH").split(System.getProperty("path.separator"));
        for (String path : paths) {
            String fullPath = Paths.get(path, toolName).toString();
            if (Files.exists(Paths.get(fullPath))) {
                return Optional.of(fullPath);
            }
        }
        return Optional.empty();
    }
}