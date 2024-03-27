package com.mixfa.lab2.task1;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        var doctor = new DoctorI18N("Misha", DoctorI18N.Profession.DENTIST);

        System.out.println(doctor.toI18NString(Locale.of("ua")));
        System.out.println(doctor.toI18NString(Locale.of("en")));
    }
}
