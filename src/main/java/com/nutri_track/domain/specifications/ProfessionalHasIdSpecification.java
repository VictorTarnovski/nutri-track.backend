package com.nutri_track.domain.specifications;

import com.nutri_track.domain.entities.Professional;

public class ProfessionalHasIdSpecification extends HasIdSpecification<Professional> {
    public ProfessionalHasIdSpecification(long professionalId) {
        super(professionalId);
    }
}
