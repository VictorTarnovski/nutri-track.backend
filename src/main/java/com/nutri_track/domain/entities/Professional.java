package com.nutri_track.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "professionals")
@SequenceGenerator(name = "professional_seq", sequenceName = "professional_sequence", allocationSize = 1)
public class Professional extends Person {
    protected Professional() {
        super();
    }

    public Professional(String document, String firstName, String lastName) {
        super(document, firstName, lastName);
    }
}
