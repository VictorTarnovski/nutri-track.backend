package com.nutri_track.application.dtos.person;

import com.nutri_track.application.dtos.AddressDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.OffsetDateTime;

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
    @Past
    protected OffsetDateTime birthDate;
    @NotNull
    @Valid
    protected AddressDto address;

    public CreatePersonDto(
            String document,
            String firstName,
            String lastName,
            OffsetDateTime birthDate,
            AddressDto address) {
        this.document = document;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
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

    public OffsetDateTime birthDate() {
        return this.birthDate;
    }

    public AddressDto address() {
        return this.address;
    }

}
