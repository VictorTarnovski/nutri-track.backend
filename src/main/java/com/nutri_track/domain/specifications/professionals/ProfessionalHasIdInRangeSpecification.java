package com.nutri_track.domain.specifications.professionals;

import com.nutri_track.domain.entities.Professional;
import com.nutri_track.domain.specifications.HasIdInRangeSpecification;

import java.util.List;

public class ProfessionalHasIdInRangeSpecification extends HasIdInRangeSpecification<Professional> {
    public ProfessionalHasIdInRangeSpecification(List<Long> professionalIds) {
        super(professionalIds);
    }
}
