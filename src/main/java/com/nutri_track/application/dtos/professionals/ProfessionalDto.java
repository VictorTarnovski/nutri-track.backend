package com.nutri_track.application.dtos.professionals;

import com.nutri_track.application.dtos.person.PersonDto;
import com.nutri_track.application.dtos.specialties.SpecialtyDto;
import com.nutri_track.domain.entities.Professional;

import java.util.Set;
import java.util.stream.Collectors;

public class ProfessionalDto extends PersonDto {
    public Set<SpecialtyDto> specialties;

    public ProfessionalDto(Professional professional) {
        super(professional);
        this.specialties = professional.specialties()
                .stream()
                .map(SpecialtyDto::new)
                .collect(Collectors.toUnmodifiableSet());
    }
}