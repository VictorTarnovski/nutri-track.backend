package com.nutri_track.domain.value_objects.builders;

import com.nutri_track.domain.value_objects.Address;

public class AddressBuilder {
    //region fields
    private String line1;
    private String line2;
    private String city;
    private String region;
    private String postalCode;
    private String countryCode;

    //endregion

    //region constructors
    public AddressBuilder() {}

    public static AddressBuilder from(Address address) {
        return new AddressBuilder()
                .withLine1(address.line1())
                .withLine2(address.line2())
                .withCity(address.city())
                .withRegion(address.region())
                .withPostalCode(address.postalCode())
                .withCountryCode(address.countryCode());
    }

    //endregion

    //region methods
    public AddressBuilder withLine1(String line1) {
        this.line1 = line1;
        return this;
    }

    public AddressBuilder withLine2(String line2) {
        this.line2 = line2;
        return this;
    }

    public AddressBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public AddressBuilder withRegion(String region) {
        this.region = region;
        return this;
    }

    public AddressBuilder withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public AddressBuilder withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public Address build() {
        return new Address(
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
