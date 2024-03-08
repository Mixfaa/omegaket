package com.mixfa.lab1.task3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Task3 {
    public static Result doJob_raw(List<BigInteger> list) {
        boolean sort;

        do {
            sort = false;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).abs().compareTo(list.get(i + 1).abs()) > 0) {
                    var value = list.get(i);
                    var nextValue = list.get(i + 1);

                    list.set(i, nextValue);
                    list.set(i + 1, value);

                    sort = true;
                }
            }

        }
        while (sort);

        BigInteger result = BigInteger.ONE;

        for (BigInteger integer : list) {
            if (integer.compareTo(BigInteger.ZERO) > 0)
                result = result.multiply(integer);
        }

        return new Result(list, result);
    }

    public static Result doJob_collections(List<BigInteger> list) {
        list.sort(Comparator.comparing(BigInteger::abs));

        var listCopy = new ArrayList<>(list);
        listCopy.removeIf((bigInt) -> bigInt.compareTo(BigInteger.ZERO) <= 0);

        final BigInteger[] result = {BigInteger.ONE};
        listCopy.forEach((bigInt) -> result[0] = result[0].multiply(bigInt));
        return new Result(list, result[0]);
    }


    public static Result doJob_streams(List<BigInteger> list) {
        var sortedList = list.stream().sorted(Comparator.comparing(BigInteger::abs)).toList();

        final BigInteger[] result = {BigInteger.ONE};
        list.stream()
                .filter((bigInt) -> bigInt.compareTo(BigInteger.ZERO) > 0)
                .forEach((bigInt) -> result[0] = result[0].multiply(bigInt));

        return new Result(sortedList, result[0]);
    }


    public record Result(
            List<BigInteger> sortedList, BigInteger result
    ) {
    }
}
