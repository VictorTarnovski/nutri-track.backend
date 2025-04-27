package com.nutri_track.application.dtos.patients;

import com.nutri_track.application.dtos.AddressDto;
import com.nutri_track.application.dtos.person.CreatePersonDto;

import java.time.OffsetDateTime;

public class CreatePatientDto extends CreatePersonDto {
    public CreatePatientDto(
            String document,
            String firstName,
            String lastName,
            OffsetDateTime birthDate,
            AddressDto address) {
        super(document, firstName, lastName, birthDate, address);
    }
}
