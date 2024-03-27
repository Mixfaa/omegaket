package com.mixfa.lab2.task4;

import java.util.regex.Pattern;

public class PasswordValidator {
    private static final Pattern pattern = Pattern.compile("^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\s:])(\\S){8,}$");

    public static boolean isPasswordValid(String password) {
        return pattern.matcher(password).matches();
    }
}