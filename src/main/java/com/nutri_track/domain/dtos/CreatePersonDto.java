package com.nutri_track.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreatePersonDto {
    @NotNull
    @NotBlank
    protected String document;
    @NotNull
    @NotBlank
    protected String firstName;
    @NotNull
    @NotBlank
    protected String lastName;

    public CreatePersonDto(String document, String firstName, String lastName) {
        this.document = document;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String document() {
        return this.document;
    }

    public String firstName() {
        return this.firstName;
    }

    public String lastName() {
        return this.lastName;
    }

}
