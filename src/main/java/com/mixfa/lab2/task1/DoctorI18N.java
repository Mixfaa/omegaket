package com.mixfa.lab2.task1;

import java.time.Duration;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Gatherers;

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

    public List<Appointment> regexSearch(String regex, Locale locale) {
        var pattern = Pattern.compile(regex);

        return getAppointments()
                .stream()
                .filter((appointment -> {
                    if (appointment instanceof Internationalized i18n)
                        return pattern.matcher(i18n.toI18NString(locale)).find();
                    return pattern.matcher(appointment.toString()).find();
                }))
                .toList();
    }

    public Optional<List<Appointment>> findAppointmentsWithLeastPeriod() {
        return getAppointments()
                .stream()
                .gather(Gatherers.windowSliding(2))
                .min((o1, o2) -> {
                    var duration1 = Duration
                            .between(o1.get(0).getDate().toInstant(),
                                    o1.get(1).getDate().toInstant());
                    var duration2 = Duration
                            .between(o2.get(0).getDate().toInstant(),
                                    o2.get(1).getDate().toInstant());

                    return duration1.compareTo(duration2);
                });
    }

    public List<Appointment> regexSearch(String regex) {
        return regexSearch(regex, Locale.getDefault());
    }

    public void sortByAlphabet(Locale locale) {
        ((ArrayList<Appointment>) getAppointments())
                .sort(Internationalized.makeAlphabetComparator(locale));
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
                .append(" \n{\n");

        for (Appointment appointment : appointments)
            if ((appointment instanceof Internationalized appointmentI18N)) {
                localizedStringBuilder.append('\t');
                localizedStringBuilder.append(appointmentI18N.toI18NString(locale));
                localizedStringBuilder.append('\n');
            }

        return localizedStringBuilder
                .append("} ")
                .toString();
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
