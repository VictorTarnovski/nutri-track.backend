package com.nutri_track.domain.dtos;

public class CreateProfessionalDto extends CreatePersonDto {
    public CreateProfessionalDto(String document, String firstName, String lastName, AddressDto address) {
        super(document, firstName, lastName, address);
    }
}
