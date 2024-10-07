package com.azure.provisioning.generator;

import com.azure.provisioning.generator.model.Specification;
import com.azure.provisioning.generator.specifications.AppConfigurationSpecification;
import com.azure.resourcemanager.appconfiguration.AppConfigurationManager;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final File BASE_DIR = new File(System.getProperty("user.dir"));

    private final List<Specification> specifications = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.specifications
                .add(new AppConfigurationSpecification("AppConfiguration",
                        "com.azure.provisioning.appconfiguration", AppConfigurationManager.class, null,
                        "Microsoft.AppConfiguration", List.of()));
        main.generate();
    }

    private void generate() {
        Map<String, String> failures = new HashMap<>();
        specifications.forEach(spec -> {
            try {
                System.out.println("Generating " + spec.getName());
                spec.build();
            } catch (Exception e) {
                failures.put(spec.getName(), e.getMessage());
                e.printStackTrace();
            }
        });
        System.out.println("Finished generating all specifications");
        if (!failures.isEmpty()) {
            failures.forEach((key, value) -> {
                System.out.println(key + ": " + value);
            });
        }
    }
}
