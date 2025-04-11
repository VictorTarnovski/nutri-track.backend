package com.nutri_track.domain.specifications;

import com.nutri_track.domain.entities.Professional;

public class ProfessionalHasDocumentSpecification extends PersonHasDocumentSpecification<Professional> {
    public ProfessionalHasDocumentSpecification(String document) {
        super(document);
    }
}
