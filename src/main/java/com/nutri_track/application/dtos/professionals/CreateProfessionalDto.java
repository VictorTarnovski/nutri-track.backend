package com.nutri_track.application.dtos.professionals;

import com.nutri_track.application.dtos.AddressDto;
import com.nutri_track.application.dtos.person.CreatePersonDto;

import java.time.OffsetDateTime;

public class CreateProfessionalDto extends CreatePersonDto {
    public CreateProfessionalDto(
            String document,
            String firstName,
            String lastName,
            OffsetDateTime birthDate,
            AddressDto address) {
        super(document, firstName, lastName, birthDate, address);
    }
}
