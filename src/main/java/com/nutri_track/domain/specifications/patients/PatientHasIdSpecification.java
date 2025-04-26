package com.nutri_track.domain.specifications.patients;

import com.nutri_track.domain.entities.Patient;
import com.nutri_track.domain.specifications.HasIdSpecification;

public class PatientHasIdSpecification extends HasIdSpecification<Patient> {
    public PatientHasIdSpecification(long patientId) {
        super(patientId);
    }
}
