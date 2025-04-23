package com.nutri_track.domain.entities;

import com.nutri_track.domain.value_objects.Specialty;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "professionals")
@SequenceGenerator(name = "professional_seq", sequenceName = "professional_sequence", allocationSize = 1)
public class Professional extends Person {
    @ManyToMany(mappedBy = "professionals")
    private Set<Specialty> specialties = new HashSet<>();

    protected Professional() {
        super();
    }

    public Professional(String document, String firstName, String lastName) {
        super(document, firstName, lastName);
    }

    public Set<Specialty> specialties() {
        return this.specialties;
    }

    public void addSpecialty(Specialty specialty) {
        try {
            specialties.add(specialty);
        } catch (IllegalArgumentException ignored) {}
    }

    public void removeSpecialty(Specialty specialty) {
        specialties.remove(specialty);
    }
}
