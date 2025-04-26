package com.nutri_track.domain.exceptions.appointments;

import com.nutri_track.domain.exceptions.NutriTrackRuntimeException;

public class AppointmentOverlapException extends NutriTrackRuntimeException {
    public AppointmentOverlapException() {
        super("Cannot schedule appointment because it overlaps other schedules");
    }
}
