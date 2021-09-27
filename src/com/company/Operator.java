package com.company;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADDITION("+", Integer::sum),
    SUBTRACTION("-", (a, b) -> a - b),
    MULTIPLICATION("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> a / b);

    private final String meaning;
    private final BiFunction<Integer, Integer, Integer> operation;

    Operator(String meaning, BiFunction<Integer, Integer, Integer> operation) {
        this.meaning = meaning;
        this.operation = operation;
    }

    public static Operator convert(String action) {
        return Arrays.stream(values())
                .filter(v -> v.meaning.equals(action))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Unexpected value: " + action));
    }

    public int calculate(int a, int b) {
        return operation.apply(a, b);
    }


}
