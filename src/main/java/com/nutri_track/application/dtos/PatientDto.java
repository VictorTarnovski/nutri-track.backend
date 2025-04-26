package com.nutri_track.application.dtos;

import com.nutri_track.domain.entities.Patient;

public class PatientDto extends PersonDto {
    public PatientDto(Patient patient) {
        super(patient);
    }
}
