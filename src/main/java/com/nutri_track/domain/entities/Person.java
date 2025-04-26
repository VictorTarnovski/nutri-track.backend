    package com.nutri_track.domain.entities;

import com.nutri_track.domain.value_objects.Address;
import jakarta.persistence.*;

@MappedSuperclass
public abstract class Person extends AbstractAggregateRoot {
    //region fields
    protected String document;
    protected String firstName;
    protected String lastName;
    
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "line1", column = @Column(name = "address_line1")),
            @AttributeOverride(name = "line2", column = @Column(name = "address_line2")),
            @AttributeOverride(name = "city", column = @Column(name = "address_city")),
            @AttributeOverride(name = "region", column = @Column(name = "address_region")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "address_postalCode")),
            @AttributeOverride(name = "countryCode", column = @Column(name = "address_countryCode")),
    })
    protected Address address;

    //endregion

    //region constructors
    protected Person() {
        super();
    }

    public Person(
            String document,
            String firstName,
            String lastName,
            Address address) {
        super();

        if (document == null) throw new IllegalArgumentException("document must not be null");
        this.document = document;

        if (firstName == null) throw new IllegalArgumentException("firstName must not be null");
        this.firstName = firstName;

        if (lastName == null) throw new IllegalArgumentException("lastName must not be null");
        this.lastName = lastName;

        if (address == null) throw new IllegalArgumentException("address must not be null");
        this.address = address;
    }

    //endregion

    //region getters
    public String document() {
        return this.document;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return  lastName;
    }

    //region address
    public String addressLine1() {
        return address.line1();
    }

    public String addressLine2() {
        return address.line2();
    }

    public String city() {
        return address.city();
    }

    public String region() {
        return address.region();
    }

    public String postalCode() {
        return address.postalCode();
    }

    public String countryCode() {
        return address.countryCode();
    }

    //endregion

    //endregion

    //region setters
    public void changeAddress(Address address) {
        this.address = address;
    }

    //endregion
}
