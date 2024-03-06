package com.mixfa.lab1.task2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.regex.Pattern;

public class UaDate {
    private static final Pattern ukranianDatePattern = Pattern.compile("(\\d{2})\\.(\\d{2})\\.(\\d+)");
    private static final String ukrainianDateFormat = "dd.MM.yyyy";

    private static boolean isDateUkranianFormatted(String date) {
        return ukranianDatePattern.matcher(date).matches();
    }

    public static void main(String[] args) throws ParseException {
        var scanner = new Scanner(System.in);
        var dateString = scanner.nextLine();

        if (!isDateUkranianFormatted(dateString)) {
            System.out.println("Date is not Ukrainian formatted");
            return;
        }

        var simpleDateFormat = new SimpleDateFormat(ukrainianDateFormat, Locale.forLanguageTag("ua_UA"));
        Date date = simpleDateFormat.parse(dateString);
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        GregorianCalendar calendar = (GregorianCalendar) new Calendar.Builder().setInstant(date).build() ;
        System.out.println("Date: " + date);
        System.out.println("LocalDate: " + localDate);
        System.out.println("Calendar: " + calendar);
    }
}
