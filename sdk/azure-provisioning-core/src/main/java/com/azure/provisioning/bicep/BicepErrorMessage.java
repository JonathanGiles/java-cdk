package com.azure.provisioning.bicep;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents an error or warning from an external Bicep processing tool.
 * The {@code rawText} will always be present and the other members will
 * optionally be available if we are able to parse the message.
 */
public class BicepErrorMessage {
    private final String rawText;
    private final String filePath;
    private final Integer lineNumber;
    private final Integer columnNumber;
    private final Boolean isError;
    private final String code;
    private final String message;
    private final boolean parsed;

    private static final Pattern LINTER_REGEX = Pattern.compile(
        "^(?:(?:WARNING|ERROR): )?(?<file>.+?)\\((?<line>\\d+),(?<col>\\d+)\\) : (?<kind>Warning|Error) (?<code>[^:]+?): (?<message>.+)$"
    );

    /**
     * Constructs a new {@code BicepErrorMessage} instance.
     *
     * @param text The raw text of the Bicep tool message.
     */
    public BicepErrorMessage(String text) {
        this.rawText = text;
        Matcher match = LINTER_REGEX.matcher(text);
        this.parsed = match.matches();
        if (this.parsed) {
            this.filePath = match.group("file");
            this.lineNumber = Integer.parseInt(match.group("line"));
            this.columnNumber = Integer.parseInt(match.group("col"));
            this.isError = "Error".equals(match.group("kind"));
            this.code = match.group("code");
            this.message = match.group("message");
        } else {
            this.filePath = null;
            this.lineNumber = null;
            this.columnNumber = null;
            this.isError = null;
            this.code = null;
            this.message = null;
        }
    }

    /**
     * Gets the raw text of the Bicep tool message.
     *
     * @return The raw text.
     */
    public String getRawText() {
        return rawText;
    }

    /**
     * Gets the optional file path containing the error.
     * If this is not provided then defer to the {@code rawText}.
     *
     * @return The file path, or {@code null} if not available.
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Gets the optional line number in {@code filePath} containing the error.
     * If this is not provided then defer to the {@code rawText}.
     *
     * @return The line number, or {@code null} if not available.
     */
    public Integer getLineNumber() {
        return lineNumber;
    }

    /**
     * Gets the optional column number in {@code filePath} containing the error.
     * If this is not provided then defer to the {@code rawText}.
     *
     * @return The column number, or {@code null} if not available.
     */
    public Integer getColumnNumber() {
        return columnNumber;
    }

    /**
     * Gets whether the message is an error.
     *
     * @return {@code true} if the message is an error, {@code false} if it is a warning, or {@code null} if not available.
     */
    public Boolean isError() {
        return isError;
    }

    /**
     * Gets the optional error code describing the error.
     * If this is not provided then defer to the {@code rawText}.
     *
     * @return The error code, or {@code null} if not available.
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the optional error message explaining the error.
     * If this is not provided then defer to the {@code rawText}.
     *
     * @return The error message, or {@code null} if not available.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Returns a string representation of the error message.
     *
     * @return A string representation of the error message.
     */
    @Override
    public String toString() {
        if (!parsed) {
            return rawText;
        }
        return String.format("%s %s: %s(%d,%d): %s",
            isError ? "Error" : "Warning",
            code,
            filePath,
            lineNumber,
            columnNumber,
            message
        );
    }
}