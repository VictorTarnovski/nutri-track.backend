package com.nutri_track.domain.exceptions;

public class AppointmentScheduleInPastException extends NutriTrackRuntimeException {
    public AppointmentScheduleInPastException() {
        super("Cannot schedule Appointment in past");
    }
}
