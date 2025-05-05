package com.nutri_track.domain.entities;

import com.nutri_track.domain.value_objects.FileLocation;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("application/octet-stream")
public class File extends DriveItem {
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "path", column = @Column(name = "location_path")),
            @AttributeOverride(name = "storage", column = @Column(name = "location_storage"))
    })
    private FileLocation location;

    protected File() {
        super();
    }

    public File(
            String name,
            FileLocation location,
            Professional professional,
            Folder parent) {
        super(name, professional, parent);
        if (location == null) throw new IllegalArgumentException("location must not be null");
        this.location = location;
    }

    public FileLocation location() {
        return this.location;
    }
}
