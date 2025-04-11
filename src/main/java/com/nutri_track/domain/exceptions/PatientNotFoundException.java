package com.nutri_track.domain.exceptions;

public class PatientNotFoundException extends NutriTrackRuntimeException {
    public PatientNotFoundException(long patientId) {
        super("Patient#" + patientId + " was not found");
    }
}
