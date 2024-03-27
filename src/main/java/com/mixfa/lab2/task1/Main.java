package com.mixfa.lab2.task1;

import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        var doctor = new DoctorI18N("Misha", DoctorI18N.Profession.DENTIST);
        doctor.addAppointment(
                new AppointmentI18N(new Date(), AppointmentI18N.Shift.NIGHT, 2)
        );
        doctor.addAppointment(
                new AppointmentI18N(new Date(), AppointmentI18N.Shift.DAY, 1)
        );


        System.out.println(doctor.findAppointmentsWithLeastPeriod());
        System.out.println(doctor.regexSearch("ніч", Locale.of("ua")));

        System.out.println(doctor.toI18NString(Locale.of("ua")));
        doctor.sortByAlphabet(Locale.of("ua"));
        System.out.println(doctor.toI18NString(Locale.of("ua")));

    }
}
