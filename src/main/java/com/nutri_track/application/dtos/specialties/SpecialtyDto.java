package com.nutri_track.application.dtos.specialties;

import com.nutri_track.application.dtos.EntityDto;
import com.nutri_track.domain.value_objects.Specialty;

public class SpecialtyDto extends EntityDto {
    public String name;

    public SpecialtyDto(Specialty specialty) {
        super(specialty.id());
        this.name = specialty.name();
    }
}
