package lab1.task1;

import com.mixfa.lab1.task1.Appointment;
import com.mixfa.lab1.task1.DoctorWithStreams;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.Collator;
import java.util.Calendar;
import java.util.Date;

public class Task1Test {
    @Test
    public void test() {
        var doctor = new DoctorWithStreams("Ravik", "surgeon");

        var appointment1 = new Appointment(new Date(1945, Calendar.FEBRUARY, 1), "night", 1);
        var appointment2 = new Appointment(new Date(2000, Calendar.FEBRUARY, 1), "night", 2);
        var appointment3 = new Appointment(new Date(2015, Calendar.FEBRUARY, 1), "night", 3);

        doctor.addAppointment(appointment1);
        doctor.addAppointment(appointment2);
        doctor.addAppointment(appointment3);

        Assertions.assertArrayEquals(doctor.appointmentWithFewestNumberOfVisitors(), new Appointment[]{appointment1});

        Assertions.assertArrayEquals(doctor.sortByDateReversed(), new Appointment[]{
                appointment3, appointment2, appointment1
        });

        Assertions.assertArrayEquals(doctor.sortByVisitorsCount(),
                new Appointment[]{
                        appointment1, appointment2, appointment3
                });
    }
}
