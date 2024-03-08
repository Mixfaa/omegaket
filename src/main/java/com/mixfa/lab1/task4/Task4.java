package com.mixfa.lab1.task4;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Task4 {
    public static int[] findAllDivisors(int n) {
        if (n <= 0) throw new IllegalArgumentException("n must be > 0");
        return IntStream.range(1, n + 1)
                .filter((value -> n % value == 0))
                .toArray();
    }

    public static void main(String[] args) {
        var divisors = findAllDivisors(30);
        System.out.println("Divisors of 30 are: " + Arrays.toString(divisors));
    }
}
