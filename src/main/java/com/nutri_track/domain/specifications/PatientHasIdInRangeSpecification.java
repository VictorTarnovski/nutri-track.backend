package com.nutri_track.domain.specifications;

import com.nutri_track.domain.entities.Patient;

import java.util.List;

public class PatientHasIdInRangeSpecification extends HasIdInRangeSpecification<Patient> {
    public PatientHasIdInRangeSpecification(List<Long> patientIds) {
        super(patientIds);
    }
}
