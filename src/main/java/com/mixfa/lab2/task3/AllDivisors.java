package com.mixfa.lab2.task3;

import java.util.stream.IntStream;

public class AllDivisors {
    public static int[] findAllDivisors(int n) {
        return IntStream.range(1, n + 1)
                .filter((value -> n % value == 0))
                .toArray();
    }
}
