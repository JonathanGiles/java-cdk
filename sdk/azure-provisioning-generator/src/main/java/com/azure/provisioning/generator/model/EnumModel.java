package com.azure.provisioning.generator.model;

import com.azure.provisioning.generator.Main;
import com.azure.provisioning.generator.utils.IndentWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Represents an enumeration model in the Azure provisioning model.
 */
public class EnumModel extends ModelBase {
    private final List<String> values;

    /**
     * Constructs a new EnumModel.
     *
     * @param name Name of the enum.
     * @param namespace Namespace of the enum.
     * @param values List of enum values.
     */
    public EnumModel(String name, String namespace, List<String> values) {
        super(name, namespace, null, null);
        this.values = values;
    }

    /**
     * Gets the list of enum values.
     *
     * @return the list of enum values.
     */
    public List<String> getValues() {
        return values;
    }

    @Override
    public String getTypeReference() {
        return getName();
    }


    @Override
    public void generate() {
        try {
            System.out.println("Generating enum " + getName());
            IndentWriter writer = new IndentWriter();
            writer.writeLine("// Copyright (c) Microsoft Corporation. All rights reserved.");
            writer.writeLine("// Licensed under the MIT License.");
            writer.writeLine();
            writer.writeLine("package " + getProvisioningPackage() + ";");
            writer.writeLine();
            writer.writeLine("public enum " + getName() + " {");
            writer.indent();

            for (int i = 0; i < values.size(); i++) {
                writer.writeLine();
                if (i == values.size() - 1) {
                    writer.writeLine(values.get(i) + ";");
                } else {
                    writer.writeLine(values.get(i) + ",");
                }
            }

            writer.unindent();
            writer.writeLine("}");
            saveFile(writer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveFile(String content) {
        Path path = Paths.get(Main.BASE_DIR.getPath() + "/" + getProvisioningPackage().replace(".", "/") + "/", getName() + ".java");
        try {
            System.out.println("Writing to " + path);
            Files.createDirectories(path.getParent());
            Files.write(path, content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}