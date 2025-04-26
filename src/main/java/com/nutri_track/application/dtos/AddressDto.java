package com.nutri_track.application.dtos;

import com.nutri_track.domain.value_objects.Address;
import com.nutri_track.domain.value_objects.builders.AddressBuilder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AddressDto {
    @NotNull
    @NotBlank
    public String line1;
    @NotNull
    @NotBlank
    public String line2;
    @NotNull
    @NotBlank
    public String city;
    @NotNull
    @NotBlank
    public String region;
    @NotNull
    @NotBlank
    public String postalCode;
    @NotNull
    @NotBlank
    public String countryCode;

    public AddressDto(
            String line1,
            String line2,
            String city,
            String region,
            String postalCode,
            String countryCode
    ) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.region = region;
        this.postalCode = postalCode;
        this.countryCode = countryCode;
    }

    public Address toAddress() {
        return new AddressBuilder()
                .withLine1(line1)
                .withLine2(line2)
                .withCity(city)
                .withRegion(region)
                .withPostalCode(postalCode)
                .withCountryCode(countryCode)
                .build();
    }
}
