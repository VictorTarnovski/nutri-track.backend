package com.nutri_track.domain.entities;

import jakarta.persistence.*;

import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "drive")
@DiscriminatorColumn(name = "mime_type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class DriveItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @ManyToOne()
    private Folder parent;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professional_id", referencedColumnName = "id")
    private Professional professional;

    //region constructors
    protected DriveItem() { }

    public DriveItem(String name, Professional professional, Folder parent) {
        rename(name);
        if (professional == null) throw new IllegalArgumentException("professional must not be null");
        this.professional = professional;
        this.parent = parent;
    }

    //endregion

    //region getters
    public UUID id() {
        return this.id;
    }

    public String name() {
        return this.name;
    }

    public Long professionalId() {
        return this.professional.id();
    }

    public Optional<UUID> parentId() {
        return parent != null
                ? Optional.of(parent.id())
                : Optional.empty();
    }

    //endregion

    //region setters
    public void rename(String name) {
        if (name == null) throw new IllegalArgumentException("name must not be null");
        this.name = name;
    }

    //endregion
}
