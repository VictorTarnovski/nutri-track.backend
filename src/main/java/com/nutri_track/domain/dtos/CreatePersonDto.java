package com.nutri_track.domain.dtos;

import jakarta.validation.Valid;
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

    @NotNull
    @Valid
    protected AddressDto address;

    public CreatePersonDto(
            String document,
            String firstName,
            String lastName,
            AddressDto address) {
        this.document = document;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
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

    public AddressDto address() {
        return this.address;
    }

}
