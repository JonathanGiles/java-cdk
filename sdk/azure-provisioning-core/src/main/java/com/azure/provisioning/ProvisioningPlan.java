package com.azure.provisioning;

import com.azure.provisioning.bicep.BicepErrorMessage;
import com.azure.provisioning.implementation.bicep.syntax.Statement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public abstract class ProvisioningPlan {

    private final ProvisioningContext context;
    private final Infrastructure infrastructure;

    protected ProvisioningPlan(Infrastructure infrastructure, ProvisioningContext context) {
        this.infrastructure = infrastructure;
        this.context = context;
    }

    protected ProvisioningContext getContext() {
        return context;
    }

    protected Infrastructure getInfrastructure() {
        return infrastructure;
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

    public List<BicepErrorMessage> lint() {
        return lint(null);
    }

    public abstract List<BicepErrorMessage> lint(String optionalDirectoryPath);

    public String compileArmTemplate() {
        return compileArmTemplate(null);
    }

    public abstract String compileArmTemplate(String optionalDirectoryPath);
}