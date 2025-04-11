package com.nutri_track.domain.exceptions;

import com.nutri_track.domain.entities.Appointment;

public class CancelledAppointmentConfirmationException extends NutriTrackRuntimeException {
    public CancelledAppointmentConfirmationException(Appointment appointment) {
        super("Cannot confirm " + appointment + " because it is canceled");
    }
}
