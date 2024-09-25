package com.azure.provisioning.expressions;

public enum BinaryOperator {
    AND("&&"),
    OR("||"),
    COALESCE("??"),
    EQUAL("=="),
    EQUAL_IGNORE_CASE("=~"),
    NOT_EQUAL("!="),
    NOT_EQUAL_IGNORE_CASE("!~"),
    GREATER(">"),
    GREATER_OR_EQUAL(">="),
    LESS("<"),
    LESS_OR_EQUAL("<="),
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    MODULO("%");

    private final String symbol;

    BinaryOperator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}