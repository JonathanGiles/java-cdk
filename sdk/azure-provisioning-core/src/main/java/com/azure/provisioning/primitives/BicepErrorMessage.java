package com.azure.provisioning.primitives;

public class BicepErrorMessage {
    private String code;
    private Integer columnNumber;
    private String filePath;
    private Boolean isError;
    private Integer lineNumber;
    private String message;
    private String rawText;

    // Internal constructor
    BicepErrorMessage() { }

    public String getCode() {
        return code;
    }

    public Integer getColumnNumber() {
        return columnNumber;
    }

    public String getFilePath() {
        return filePath;
    }

    public Boolean getIsError() {
        return isError;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public String getMessage() {
        return message;
    }

    public String getRawText() {
        return rawText;
    }

    @Override
    public String toString() {
        return rawText;
    }
}