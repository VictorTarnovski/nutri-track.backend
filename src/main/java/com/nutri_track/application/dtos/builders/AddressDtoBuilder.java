package com.nutri_track.application.dtos.builders;

import com.nutri_track.application.dtos.AddressDto;

public class AddressDtoBuilder {
    //region fields
    private String line1;
    private String line2;
    private String city;
    private String region;
    private String postalCode;
    private String countryCode;

    //endregion

    //region methods
    public AddressDtoBuilder withLine1(String line1) {
        this.line1 = line1;
        return this;
    }

    public AddressDtoBuilder withLine2(String line2) {
        this.line2 = line2;
        return this;
    }

    public AddressDtoBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public AddressDtoBuilder withRegion(String region) {
        this.region = region;
        return this;
    }

    public AddressDtoBuilder withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public AddressDtoBuilder withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public AddressDto build() {
        return new AddressDto(
                line1,
                line2,
                city,
                region,
                postalCode,
                countryCode
        );
    }

    //endregion
}
