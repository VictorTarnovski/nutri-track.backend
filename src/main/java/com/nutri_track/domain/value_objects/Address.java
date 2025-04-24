package com.nutri_track.domain.value_objects;

import jakarta.persistence.Embeddable;

import java.util.Objects;
import java.util.Optional;

@Embeddable
public class Address implements Comparable<Address> {
    //region fields
    private final String line1;
    private final String line2;
    private final String line3;
    private final String city;
    /**
     * State, Province or Prefecture
     */
    private final String region;
    private final String postalCode;
    /*
     * ISO 3166-1 alpha-2 (e.g., "US", "BR", "JP")
     */
    private final String countryCode;
    /**
     * Optional: for mailing
     */
    private String recipientName;
    /*
     * Optional: for businesses
     */
    private String organization;

    //endregion

    //region constructors
    public Address (
            String line1,
            String line2,
            String line3,
            String city,
            String region,
            String postalCode,
            String countryCode
    ) {
        if(line1 == null) throw new IllegalArgumentException("line1 must not be null");
        this.line1 = line1;

        if(line2 == null) throw new IllegalArgumentException("line2 must not be null");
        this.line2 = line2;

        this.line3 = line3;

        if(city == null) throw new IllegalArgumentException("city must not be null");
        this.city = city;

        if(region == null) throw new IllegalArgumentException("region must not be null");
        this.region = region;

        if(postalCode == null) throw new IllegalArgumentException("postalCode must not be null");
        this.postalCode = postalCode;

        if(countryCode == null) throw new IllegalArgumentException("countryCode must not be null");
        this.countryCode = countryCode;
    }

    public Address (
            String line1,
            String line2,
            String line3,
            String city,
            String region,
            String postalCode,
            String countryCode,
            String recipientName,
            String organization
    ) {
        this(line1, line2, line3, city, region, postalCode, countryCode);
        this.recipientName = recipientName;
        this.organization = organization;
    }

    //endregion

    //region getters
    public String line1() {
        return line1;
    }

    public String line2() {
        return line2;
    }

    public Optional<String> line3() {
        return Optional.ofNullable(line3);
    }

    public String city() {
        return city;
    }

    public String region() {
        return region;
    }

    public String postalCode() {
        return postalCode;
    }

    public String countryCode() {
        return countryCode;
    }

    public Optional<String> recipientName() {
        return Optional.ofNullable(recipientName);
    }

    public Optional<String> organization() {
        return Optional.ofNullable(organization);
    }

    //endregion

    //region methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(line1, address.line1) &&
                Objects.equals(line2, address.line2) &&
                Objects.equals(line3, address.line3) &&
                Objects.equals(city, address.city) &&
                Objects.equals(region, address.region) &&
                Objects.equals(postalCode, address.postalCode) &&
                Objects.equals(countryCode, address.countryCode) &&
                Objects.equals(recipientName, address.recipientName) &&
                Objects.equals(organization, address.organization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line1, line2, line3, city, region, postalCode, countryCode, recipientName, organization);
    }

    @Override
    public int compareTo(Address other) {
        int result = this.line1.compareTo(other.line1);
        if (result != 0) return result;
        result = this.line2.compareTo(other.line2);
        if (result != 0) return result;
        result = this.line3.compareTo(other.line3);
        if (result != 0) return result;
        result = this.city.compareTo(other.city);
        if (result != 0) return result;
        result = this.region.compareTo(other.region);
        if (result != 0) return result;
        result = this.postalCode.compareTo(other.postalCode);
        if (result != 0) return result;
        result = this.countryCode.compareTo(other.countryCode);
        if (result != 0) return result;
        result = this.recipientName.compareTo(other.recipientName);
        if (result != 0) return result;
        return this.organization.compareTo(other.organization);
    }

    //endregion
}