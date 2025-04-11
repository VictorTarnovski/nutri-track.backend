package com.nutri_track.domain.dtos;

public class CreatePatientDto extends CreatePersonDto {
    public CreatePatientDto(String document, String firstName, String lastName) {
        super(document, firstName, lastName);
    }
}
