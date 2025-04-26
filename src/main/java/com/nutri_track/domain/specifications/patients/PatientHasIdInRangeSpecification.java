package com.nutri_track.domain.specifications.patients;

import com.nutri_track.domain.entities.Patient;
import com.nutri_track.domain.specifications.HasIdInRangeSpecification;

import java.util.List;

public class PatientHasIdInRangeSpecification extends HasIdInRangeSpecification<Patient> {
    public PatientHasIdInRangeSpecification(List<Long> patientIds) {
        super(patientIds);
    }
}
