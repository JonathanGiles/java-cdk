package com.azure.provisioning.implementation.bicep.syntax;

public class CommentStatement extends Statement {
    private final String comment;

    public CommentStatement(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    @Override
    BicepWriter write(BicepWriter writer) {
        return writer.append("// ").append(comment).appendLine();
    }
}