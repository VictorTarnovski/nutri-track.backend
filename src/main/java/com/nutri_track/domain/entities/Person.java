package com.nutri_track.domain.entities;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person extends AbstractAggregateRoot {
    protected String document;
    protected String firstName;
    protected String lastName;

    protected Person() {
        super();
    }

    public Person(String document, String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
    }

    public String document() {
        return this.document;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return  lastName;
    }
}
