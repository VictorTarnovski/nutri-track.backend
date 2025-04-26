package com.nutri_track.domain.specifications.patients;

import com.nutri_track.domain.entities.Patient;
import com.nutri_track.domain.specifications.person.PersonHasDocumentSpecification;

public class PatientHasDocumentSpecification extends PersonHasDocumentSpecification<Patient> {
    public PatientHasDocumentSpecification(String document) {
        super(document);
    }
}
