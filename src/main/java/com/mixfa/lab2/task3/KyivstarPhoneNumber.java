package com.mixfa.lab2.task3;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;

public class KyivstarPhoneNumber {
    private static final List<UaPhoneOperatorParser> availableParsers = List.of(
            new UaPhoneOperatorParser("\\+\\d{3} (\\d{2}) \\d{3} \\d{2} \\d{2}"), // +380 96 256 67 35
            new UaPhoneOperatorParser("0(\\d{2}) \\d{3} \\d{2} \\d{2}"), // 096 256 67 35
            new UaPhoneOperatorParser("0(\\d{2})\\d{7}"), // 0962566735
            new UaPhoneOperatorParser("\\+380(\\d{2})\\d{7}"), // +380962566735
            new UaPhoneOperatorParser("\\(0(\\d{2})\\) \\d{3} \\d{2} \\d{2}"), // (096) 256 67 35
            new UaPhoneOperatorParser("\\+\\d{3} \\((\\d{2})\\) \\d{3} \\d{2} \\d{2}")); // +380 (96) 256 67 35

    private static final List<String> kyivstarTags = List.of("67", "96");

    public static boolean check(String phoneNumber) {
        for (UaPhoneOperatorParser parser : availableParsers) {

            var operator = parser.getOperator(phoneNumber);
            if (operator.isEmpty()) continue;

            if (kyivstarTags.contains(operator.get()))
                return true;

        }
        return false;
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var phoneNumber = scanner.nextLine();

        if (check(phoneNumber))
            System.out.println("Operator is Kyivstar");
        else
            System.out.println("Kyivstar digits not found");
    }


    private static class UaPhoneOperatorParser {
        private final Pattern pattern;
        private final int operatorGroup;

        public UaPhoneOperatorParser(String regex, int operatorGroup) {
            this.pattern = Pattern.compile(regex);
            this.operatorGroup = operatorGroup;
        }

        public UaPhoneOperatorParser(String regex) {
            this.pattern = Pattern.compile(regex);
            this.operatorGroup = 1;
        }

        Optional<String> getOperator(String number) {
            try {
                var matcher = pattern.matcher(number);
                if (!matcher.find()) return Optional.empty();
                return Optional.ofNullable(matcher.group(operatorGroup));
            } catch (Exception ex) {
                return Optional.empty();
            }
        }
    }
}