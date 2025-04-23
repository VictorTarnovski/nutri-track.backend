package com.nutri_track.domain.value_objects;

import com.nutri_track.domain.entities.AbstractAggregateRoot;
import com.nutri_track.domain.entities.AbstractEntity;
import com.nutri_track.domain.entities.Professional;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "specialties")
@SequenceGenerator(name = "specialty_seq", sequenceName = "specialty_sequence", allocationSize = 1)
public class Specialty extends AbstractAggregateRoot implements Comparable<Specialty> {
    private String name;

    @ManyToMany
    @JoinTable(
            name = "professional_specialty",
            joinColumns = @JoinColumn(name = "specialty_id"),
            inverseJoinColumns = @JoinColumn(name = "professional_id"))
    private Set<Professional> professionals;

    protected Specialty() {
        super();
    }

    protected Specialty(String name, Set<Professional> professionals) {
        super();
        this.name = name;
        this.professionals = professionals;
    }

    public String name() {
        return this.name;
    }

    public Set<Professional> professionals() {
        return this.professionals;
    }

    @Override
    public int compareTo(Specialty o) {
        return this.name.compareTo(o.name());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return ((Specialty) o).name().equals(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
