package com.mixfa.lab1.task6;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Task6 {
    private static BigInteger powByMultiply(BigInteger integer, int pow) {
        var result = integer.multiply(integer);

        for (int i = 2; i < pow; i++)
            result = result.multiply(integer);

        return result;
    }

    public static void main(String[] args) {
        var bigInteger = new BigInteger(32, new SecureRandom());

        System.out.println("Pow 8 by BigInteger::pow\n = " + bigInteger.pow(8));
        System.out.println("Pow 8 by multiply\n = " + powByMultiply(bigInteger, 8));
    }
}
