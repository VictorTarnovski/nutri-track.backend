package com.nutri_track.application.dtos.patients;

import com.nutri_track.application.dtos.person.PersonDto;
import com.nutri_track.domain.entities.Patient;

public class PatientDto extends PersonDto {
    public PatientDto(Patient patient) {
        super(patient);
    }
}
