package com.nutri_track.domain.entities;

import com.nutri_track.domain.value_objects.Address;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "patients")
@SequenceGenerator(name = "patients_seq", sequenceName = "patients_sequence", allocationSize = 1)
public class Patient extends Person {
    protected Patient() {
        super();
    }

    public Patient(String document, String firstName, String lastName, Address address) {
        super(document, firstName, lastName, address);
    }
}
