package com.nutri_track.domain.specifications;

import com.nutri_track.domain.entities.Professional;

import java.util.List;

public class ProfessionalHasIdInRangeSpecification extends HasIdInRangeSpecification<Professional> {
    public ProfessionalHasIdInRangeSpecification(List<Long> professionalIds) {
        super(professionalIds);
    }
}
