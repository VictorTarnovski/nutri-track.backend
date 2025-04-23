package com.nutri_track.domain.specifications;

import com.nutri_track.domain.value_objects.Specialty;

public class SpecialtyHasIdSpecification extends HasIdSpecification<Specialty> {
    public SpecialtyHasIdSpecification(long specialtyId) {
        super(specialtyId);
    }
}
