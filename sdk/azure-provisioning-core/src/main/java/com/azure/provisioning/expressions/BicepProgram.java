package com.azure.provisioning.expressions;

public class BicepProgram {
    private final Statement[] body;
    private String moduleName;

    public BicepProgram(Statement... body) {
        this.body = body;
    }

    public Statement[] getBody() {
        return body;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    @Override
    public String toString() {
        BicepWriter writer = new BicepWriter();
        for (Statement stmt : body) {
            writer = writer.append(stmt).appendLine();
        }
        return writer.toString();
    }
}