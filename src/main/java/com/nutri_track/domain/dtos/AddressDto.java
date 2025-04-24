package com.nutri_track.domain.dtos;

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
    public String line3;
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
    public String recipientName;
    public String organization;

    public AddressDto(Address address){
        this.line1 = address.line1();
        this.line2 = address.line2();
        this.line3 = address.line3().get();
        this.city = address.city();
        this.region = address.region();
        this.postalCode = address.postalCode();
        this.countryCode = address.countryCode();
        this.recipientName = address.recipientName().get();
        this.organization = address.organization().get();
    }

    public Address toAddress() {
        return new AddressBuilder()
                .withLine1(line1)
                .withLine2(line2)
                .withLine3(line3)
                .withCity(city)
                .withRegion(region)
                .withPostalCode(postalCode)
                .withCountryCode(countryCode)
                .withRecipientName(recipientName)
                .withOrganization(organization)
                .build();
    }
}

