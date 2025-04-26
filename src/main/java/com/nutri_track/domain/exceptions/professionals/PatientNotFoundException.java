package com.nutri_track.domain.exceptions.professionals;

import com.nutri_track.domain.exceptions.NutriTrackRuntimeException;

public class PatientNotFoundException extends NutriTrackRuntimeException {
    public PatientNotFoundException(long patientId) {
        super("Patient#" + patientId + " was not found");
    }
}
