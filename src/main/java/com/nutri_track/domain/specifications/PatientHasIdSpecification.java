package com.nutri_track.domain.specifications;

import com.nutri_track.domain.entities.Patient;

public class PatientHasIdSpecification extends HasIdSpecification<Patient> {
    public PatientHasIdSpecification(long patientId) {
        super(patientId);
    }
}
