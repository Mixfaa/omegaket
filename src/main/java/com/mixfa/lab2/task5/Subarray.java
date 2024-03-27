package com.mixfa.lab2.task5;

import java.util.Arrays;
import java.util.Scanner;

public class Subarray {
    public static String[] stringBetweenDigits(String string) {
        return Arrays.stream(string.split("(\\d+)"))
                .filter((str) -> !str.isEmpty())
                .toArray(String[]::new);
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var list = stringBetweenDigits(scanner.nextLine());
        System.out.println(Arrays.toString(list));
    }
}