package com.nutri_track.domain.entities;

import com.nutri_track.domain.value_objects.Address;
import jakarta.persistence.*;

import java.util.Optional;

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
            @AttributeOverride(name = "line3", column = @Column(name = "address_line3")),
            @AttributeOverride(name = "city", column = @Column(name = "address_city")),
            @AttributeOverride(name = "region", column = @Column(name = "address_region")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "address_postalCode")),
            @AttributeOverride(name = "countryCode", column = @Column(name = "address_countryCode")),
            @AttributeOverride(name = "recipientName", column = @Column(name = "address_recipientName")),
            @AttributeOverride(name = "organization", column = @Column(name = "address_organization"))
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
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
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

    public Optional<String> addressLine3() {
        return address.line3();
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

    public Optional<String> recipientName() {
        return address.recipientName();
    }

    public Optional<String> organization() {
        return address.organization();
    }

    //endregion

    //endregion

    //region setters
    public void changeAddress(Address address) {
        this.address = address;
    }

    //endregion
}
