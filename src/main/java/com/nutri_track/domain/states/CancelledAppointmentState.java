package com.nutri_track.domain.states;

import com.nutri_track.domain.entities.Appointment;
import com.nutri_track.domain.exceptions.CancelledAppointmentConfirmationException;

public class CancelledAppointmentState extends AppointmentState implements IAppointmentState {
    public String name() {
        return "CANCELLED";
    }

    public void confirm(Appointment appointment) {
        throw new CancelledAppointmentConfirmationException(appointment);
    }

    public void cancel(Appointment appointment) {}
}
