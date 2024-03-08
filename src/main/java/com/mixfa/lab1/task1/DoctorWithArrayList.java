package com.mixfa.lab1.task1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DoctorWithArrayList extends AbstractDoctor {
    private final String name;
    private final String profession;
    private final ArrayList<Appointment> appointments = new ArrayList<>();

    public DoctorWithArrayList(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    @Override
    public Appointment[] sortByDateReversed() {
        appointments.sort((a1, a2) -> a2.getDate().compareTo(a1.getDate())); // using list method sort
        return appointments.toArray(new Appointment[0]);
    }

    @Override
    public Appointment[] sortByVisitorsCount() {
        Collections.sort(appointments); // using same method, but via Collections class
        return appointments.toArray(new Appointment[0]);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getProfession() {
        return profession;
    }

    @Override
    public Collection<Appointment> getAppointments() {
        return appointments;
    }

    @Override
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

}
