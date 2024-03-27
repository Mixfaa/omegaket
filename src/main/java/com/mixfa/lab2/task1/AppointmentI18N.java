package com.mixfa.lab2.task1;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class AppointmentI18N extends Appointment implements Internationalized {
    private final ZonedDateTime dateTime;
    private static final String BUNDLE_NAME = "appointment";

    public AppointmentI18N(Date date, Shift shift, int visitorsCount) {
        super(date, shift.toString(), visitorsCount);

        var defaultZoneId = ZoneId.systemDefault();
        this.dateTime = ZonedDateTime.of(LocalDateTime.ofInstant(date.toInstant(), defaultZoneId), defaultZoneId);
    }

    @Override
    public String toI18NString(Locale locale) {
        var bundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);

        var format = bundle.getString("format");
        var shift = Shift.valueOf(getShift()).toI18NString(locale);

        var formattedTime = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.FULL)
                .withLocale(locale)
                .format(dateTime);

        var visitorsCountFormatted = NumberFormat
                .getInstance(locale)
                .format(getVisitorsCount());

        return String.format(locale, format, formattedTime, visitorsCountFormatted, shift);
    }


    public enum Shift implements Internationalized {
        NIGHT,
        DAY;

        @Override
        public String toI18NString(Locale locale) {
            return ResourceBundle.getBundle(BUNDLE_NAME, locale).getString(this.toString());
        }

        private static final String BUNDLE_NAME = "shift";
    }
}
