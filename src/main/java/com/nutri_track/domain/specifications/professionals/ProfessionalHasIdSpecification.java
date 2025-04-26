package com.nutri_track.domain.specifications.professionals;

import com.nutri_track.domain.entities.Professional;
import com.nutri_track.domain.specifications.HasIdSpecification;

public class ProfessionalHasIdSpecification extends HasIdSpecification<Professional> {
    public ProfessionalHasIdSpecification(long professionalId) {
        super(professionalId);
    }
}
