package com.nutri_track.domain.exceptions.appointments;

import com.nutri_track.domain.entities.Appointment;
import com.nutri_track.domain.exceptions.NutriTrackRuntimeException;

public class CancelledAppointmentConfirmationException extends NutriTrackRuntimeException {
    public CancelledAppointmentConfirmationException(Appointment appointment) {
        super("Cannot confirm " + appointment + " because it is canceled");
    }
}
