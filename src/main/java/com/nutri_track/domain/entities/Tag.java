package com.nutri_track.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tags")
@SequenceGenerator(name = "tag_seq", sequenceName = "tag_sequence", allocationSize = 1)
public class Tag extends AbstractAggregateRoot {

    private String name;

    protected Tag() {
        super();
    }

    public Tag(String name) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }
}
