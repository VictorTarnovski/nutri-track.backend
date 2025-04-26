package com.nutri_track.domain.exceptions.professionals;

import com.nutri_track.domain.entities.Patient;
import com.nutri_track.domain.exceptions.NutriTrackRuntimeException;

public class PatientAlreadyRegisteredException extends NutriTrackRuntimeException {
    public PatientAlreadyRegisteredException(Patient patient) {
        super("Patient with document '" + patient.document() +"' already registered!");
    }
}
