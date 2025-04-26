package com.nutri_track.domain.exceptions.appointments;

import com.nutri_track.domain.exceptions.NutriTrackRuntimeException;

public class AppointmentScheduleInPastException extends NutriTrackRuntimeException {
    public AppointmentScheduleInPastException() {
        super("Cannot schedule Appointment in past");
    }
}
