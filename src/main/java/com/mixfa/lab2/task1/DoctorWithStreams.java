package com.mixfa.lab2.task1;

public class DoctorWithStreams extends DoctorWithArrayList {

    public DoctorWithStreams(String name, String profession) {
        super(name, profession);
    }

    @Override
    public int getVisitorsCount() {
        return super.getVisitorsCount();
    }

    @Override
    public Appointment[] appointmentWithFewestNumberOfVisitors() {
        var appointment =
                this.getAppointments()
                        .stream()
                        .min(Appointment::compareTo)
                        .orElse(null);

        return appointment == null ? null : new Appointment[]{appointment};
    }

    @Override
    public Appointment[] sortByDateReversed() {
        return this.getAppointments()
                .stream()
                .sorted(Appointment.revercedDateComparator)
                .toArray(Appointment[]::new);
    }

    @Override
    public Appointment[] sortByVisitorsCount() {
        return this.getAppointments()
                .stream()
                .sorted(Appointment::compareTo)
                .toArray(Appointment[]::new);
    }
}
