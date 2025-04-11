package com.nutri_track.domain.exceptions;

public class AppointmentNotFoundException extends NutriTrackRuntimeException {
    public AppointmentNotFoundException(long appointmentId) {
        super("Appointment#" + appointmentId + " was not found");
    }
}
