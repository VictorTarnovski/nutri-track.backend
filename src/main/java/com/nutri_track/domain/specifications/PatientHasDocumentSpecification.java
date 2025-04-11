package com.nutri_track.domain.specifications;

import com.nutri_track.domain.entities.Patient;

public class PatientHasDocumentSpecification extends PersonHasDocumentSpecification<Patient> {
    public PatientHasDocumentSpecification(String document) {
        super(document);
    }
}
