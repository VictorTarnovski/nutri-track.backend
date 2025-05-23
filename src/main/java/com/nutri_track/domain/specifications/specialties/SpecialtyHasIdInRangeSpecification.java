package com.nutri_track.domain.specifications.specialties;

import com.nutri_track.domain.specifications.HasIdInRangeSpecification;
import com.nutri_track.domain.value_objects.Specialty;

import java.util.List;

public class SpecialtyHasIdInRangeSpecification extends HasIdInRangeSpecification<Specialty> {
    public SpecialtyHasIdInRangeSpecification(List<Long> specialtyIds) {
        super(specialtyIds);
    }
}
