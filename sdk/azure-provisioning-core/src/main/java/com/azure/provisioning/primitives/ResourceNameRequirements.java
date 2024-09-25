package com.azure.provisioning.primitives;

public class ResourceNameRequirements {
    private final int minLength;
    private final int maxLength;
    private final ResourceNameCharacters validCharacters;

    public ResourceNameRequirements(int minLength, int maxLength, ResourceNameCharacters validCharacters) {
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.validCharacters = validCharacters;
    }

    public int getMinLength() {
        return minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public ResourceNameCharacters getValidCharacters() {
        return validCharacters;
    }
}