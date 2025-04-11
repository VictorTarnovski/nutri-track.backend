package com.nutri_track.domain.states;

import com.nutri_track.domain.entities.Appointment;

public class ConfirmationPendingAppointmentState implements IAppointmentState {
    public String name() {
        return "CONFIRMATION_PENDING";
    }

    public void confirm(Appointment appointment) {
        appointment.setState(new ScheduledAppointmentState().name());
    }

    public void cancel(Appointment appointment) {
        appointment.setState(new CancelledAppointmentState().name());
    }
}
