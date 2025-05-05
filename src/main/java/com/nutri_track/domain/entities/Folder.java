package com.nutri_track.domain.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
@DiscriminatorValue("inode/directory")
public class Folder extends DriveItem {
    @OneToMany(mappedBy = "parent")
    private Set<DriveItem> children;

    private Folder() {
        super();
    }

    public Folder(String name, Professional professional, Folder parent) {
        super(name, professional, parent);
    }

    public Set<DriveItem> children() {
        return this.children;
    }
}
