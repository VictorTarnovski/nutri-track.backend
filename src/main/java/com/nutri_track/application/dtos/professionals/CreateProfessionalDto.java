package com.nutri_track.application.dtos.professionals;

import com.nutri_track.application.dtos.AddressDto;
import com.nutri_track.application.dtos.person.CreatePersonDto;

public class CreateProfessionalDto extends CreatePersonDto {
    public CreateProfessionalDto(
            String document,
            String firstName,
            String lastName,
            AddressDto address) {
        super(document, firstName, lastName, address);
    }
}
