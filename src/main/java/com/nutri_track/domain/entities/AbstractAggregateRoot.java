package com.nutri_track.domain.entities;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractAggregateRoot extends AbstractEntity {
    protected AbstractAggregateRoot() {
        super();
    }
}
