package com.nutri_track.domain.exceptions;

import com.nutri_track.domain.entities.Patient;

public class PatientAlreadyRegisteredException extends NutriTrackRuntimeException {
    public PatientAlreadyRegisteredException(Patient patient) {
        super("Patient with document '" + patient.document() +"' already registered!");
    }
}
