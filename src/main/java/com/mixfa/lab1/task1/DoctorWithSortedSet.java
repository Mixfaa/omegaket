package com.mixfa.lab1.task1;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

public class DoctorWithSortedSet extends AbstractDoctor {
    private final String name;
    private final String profession;
    private final SortedSet<Appointment> appointments = new TreeSet<>(Appointment::compareTo);

    public DoctorWithSortedSet(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    @Override
    public Appointment[] appointmentWithFewestNumberOfVisitors() {
        return appointments.isEmpty() ? null : new Appointment[]{appointments.last()};
    }

    @Override
    public Appointment[] sortByDateReversed() {
        var sortedByDateReversed = new TreeSet<Appointment>((a1, a2) -> a2.getDate().compareTo(a1.getDate()));
        sortedByDateReversed.addAll(appointments);
        return sortedByDateReversed.toArray(new Appointment[0]);
    }

    @Override
    public Appointment[] sortByVisitorsCount() {
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
