package com.nutri_track.domain.exceptions.appointments;

import com.nutri_track.domain.exceptions.NutriTrackRuntimeException;

public class AppointmentNotFoundException extends NutriTrackRuntimeException {
    public AppointmentNotFoundException(long appointmentId) {
        super("Appointment#" + appointmentId + " was not found");
    }
}
