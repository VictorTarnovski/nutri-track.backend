package com.nutri_track.domain.specifications;

import com.nutri_track.domain.entities.Shift;

public class ShiftHasIdSpecification extends HasIdSpecification<Shift> {
    public ShiftHasIdSpecification(Long shiftId) {
        super(shiftId);
    }
}
