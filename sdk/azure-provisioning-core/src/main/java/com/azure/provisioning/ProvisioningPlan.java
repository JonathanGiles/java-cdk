package com.azure.provisioning;

import com.azure.provisioning.expressions.Statement;
import com.azure.provisioning.primitives.BicepErrorMessage;
import com.azure.provisioning.primitives.ExternalBicepTool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProvisioningPlan {
    private static final Lazy<ExternalBicepTool> BicepTool = new Lazy<>(ExternalBicepTool::findBestTool);

    private final ProvisioningContext context;
    private final Infrastructure infrastructure;

    ProvisioningPlan(Infrastructure infrastructure, ProvisioningContext context) {
        this.infrastructure = infrastructure;
        this.context = context;
    }

    public Map<String, String> compile() {
        Map<String, String> source = new HashMap<>();
        for (Map.Entry<String, List<Statement>> entry : infrastructure.compileModules(context).entrySet()) {
            source.put(entry.getKey() + ".bicep", entry.getValue().stream()
                    .map(Statement::toString)
                    .collect(Collectors.joining(System.lineSeparator()))
                    .trim());
        }
        return source;
    }

    public List<String> save(String directoryPath) throws IOException {
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("Directory " + directoryPath + " does not exist");
        }
        List<String> paths = new ArrayList<>();
        for (Map.Entry<String, String> entry : compile().entrySet()) {
            String path = directoryPath + File.separator + entry.getKey();
            try (FileWriter writer = new FileWriter(path)) {
                writer.write(entry.getValue());
            }
            paths.add(path);
        }
        return paths;
    }

    public List<BicepErrorMessage> lint(String optionalDirectoryPath) throws IOException {
        return withOptionalTempBicep(optionalDirectoryPath, BicepTool.getValue()::lint);
    }

    public String compileArmTemplate(String optionalDirectoryPath) throws IOException {
        return withOptionalTempBicep(optionalDirectoryPath, BicepTool.getValue()::getArmTemplate);
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
                    Files.walk(Path.of(dirToCleanup))
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