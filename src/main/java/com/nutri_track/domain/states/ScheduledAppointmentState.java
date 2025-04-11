package com.nutri_track.domain.states;

import com.nutri_track.domain.entities.Appointment;

public class ScheduledAppointmentState extends AppointmentState implements IAppointmentState {
    @Override
    public String name() {
        return "SCHEDULED";
    }

    @Override
    public void confirm(Appointment appointment) {}

    @Override
    public void cancel(Appointment appointment) {
        appointment.setState(new CancelledAppointmentState().name());
    }
}
