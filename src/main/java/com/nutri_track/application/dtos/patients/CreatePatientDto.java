package com.nutri_track.application.dtos.patients;

import com.nutri_track.application.dtos.AddressDto;
import com.nutri_track.application.dtos.person.CreatePersonDto;

public class CreatePatientDto extends CreatePersonDto {
    public CreatePatientDto(
            String document,
            String firstName,
            String lastName,
            AddressDto address) {
        super(document, firstName, lastName, address);
    }
}
