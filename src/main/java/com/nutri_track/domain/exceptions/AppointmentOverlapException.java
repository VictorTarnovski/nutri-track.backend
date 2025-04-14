package com.nutri_track.domain.exceptions;

public class AppointmentOverlapException extends NutriTrackRuntimeException {
    public AppointmentOverlapException() {
        super("Cannot schedule appointment because it overlaps other schedules");
    }
}
