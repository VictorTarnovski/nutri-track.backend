package com.nutri_track.domain.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;
    protected final OffsetDateTime createdAt;
    protected OffsetDateTime updatedAt;

    protected AbstractEntity() {
        this.createdAt = Instant.now().atOffset(ZoneOffset.UTC);
        this.updatedAt = Instant.now().atOffset(ZoneOffset.UTC);
    }

    public Long id() {
        return this.id;
    }

    public OffsetDateTime createdAt() {
        return this.createdAt;
    }

    public OffsetDateTime updatedAt() {
        return this.updatedAt;
    }
}

