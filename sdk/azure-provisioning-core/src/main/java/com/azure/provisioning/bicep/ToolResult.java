package com.azure.provisioning.bicep;

import java.util.Objects;
import java.util.Optional;

public final class ToolResult {
    private final int exitCode;
    private final String output;
    private final String error;

    public ToolResult(int exitCode, String output, String error) {
        this.exitCode = exitCode;
        this.output = output;
        this.error = error;
    }

    public int getExitCode() {
        return exitCode;
    }

    public Optional<String> getOutput() {
        return Optional.ofNullable(output);
    }

    public Optional<String> getError() {
        return Optional.ofNullable(error);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        ToolResult that = (ToolResult) obj;
        return this.exitCode == that.exitCode &&
            Objects.equals(this.output, that.output) &&
            Objects.equals(this.error, that.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exitCode, output, error);
    }

    @Override
    public String toString() {
        return "ToolResult[" +
            "exitCode=" + exitCode + ", " +
            "output=" + output + ", " +
            "error=" + error + ']';
    }
}