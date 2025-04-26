package com.nutri_track.domain.specifications.professionals;

import com.nutri_track.domain.entities.Professional;
import com.nutri_track.domain.specifications.person.PersonHasDocumentSpecification;

public class ProfessionalHasDocumentSpecification extends PersonHasDocumentSpecification<Professional> {
    public ProfessionalHasDocumentSpecification(String document) {
        super(document);
    }
}
