package com.mixfa.lab2.task1;

import java.util.Locale;
import java.util.ResourceBundle;

public class DoctorI18N extends DoctorWithStreams implements Internationalized {
    private static final String BUNDLE_NAME = "doctor";

    public DoctorI18N(String name, Profession profession) {
        super(name, profession.toString());
    }

    @Override
    public void addAppointment(Appointment appointment) {
        if (!(appointment instanceof Internationalized))
            throw new IllegalArgumentException("Appointment should be instance of AppointmentI18N");
        super.addAppointment(appointment);
    }

    @Override
    public String toI18NString(Locale locale) {
        var bundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
        var format = bundle.getString("format");

        var profession = Profession.valueOf(getProfession()).toI18NString(locale);

        var localizedString = String.format(locale, format, getName(), profession);

        var appointments = getAppointments();
        if (appointments.isEmpty())
            return localizedString;

        StringBuilder localizedStringBuilder = new StringBuilder(localizedString)
                .append('\n');

        for (Appointment appointment : appointments)
            if ((appointment instanceof Internationalized appointmentI18N)) {
                localizedStringBuilder.append(appointmentI18N.toI18NString(locale));
                localizedStringBuilder.append('\n');
            }

        return localizedStringBuilder.toString();
    }

    public enum Profession implements Internationalized {
        SURGEON,
        DENTIST,
        CARDIOLOGIST;

        @Override
        public String toI18NString(Locale locale) {
            return ResourceBundle.getBundle(BUNDLE_NAME, locale).getString(this.toString());
        }

        private static final String BUNDLE_NAME = "profession";
    }
}
