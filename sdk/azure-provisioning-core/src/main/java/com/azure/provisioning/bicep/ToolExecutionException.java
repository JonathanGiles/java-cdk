package com.azure.provisioning.bicep;

public class ToolExecutionException extends Exception {
    private final ToolResult toolResult;

    public ToolExecutionException(ToolResult toolResult) {
        this.toolResult = toolResult;
    }

    public ToolResult getToolResult() {
        return toolResult;
    }

    @Override
    public String toString() {
        String errorMessage = toolResult.getError().orElse(null);
        String ouput = toolResult.getOutput().orElse(null);
        return "Linting failed with exit code " + toolResult.getExitCode() +
            (errorMessage != null ? " and error: " + errorMessage : "") +
            (ouput != null ? "\nTool output: " + ouput : "");
    }
}