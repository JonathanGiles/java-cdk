package com.azure.provisioning.primitives;

public enum ResourceNameCharacters {
    LOWERCASE_LETTERS(1),
    UPPERCASE_LETTERS(2),
    LETTERS(LOWERCASE_LETTERS.value | UPPERCASE_LETTERS.value),
    NUMBERS(4),
    ALPHANUMERIC(LETTERS.value | NUMBERS.value),
    HYPHEN(8),
    UNDERSCORE(16),
    PERIOD(32),
    PARENTHESES(64);

    private final int value;

    ResourceNameCharacters(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}