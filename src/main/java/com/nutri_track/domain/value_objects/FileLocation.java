package com.nutri_track.domain.value_objects;

import com.nutri_track.domain.enums.FileLocationStorage;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class FileLocation {
    //region fields
    private String path;
    private FileLocationStorage storage;

    //endregion

    //region constructors
    private FileLocation() {}

    private FileLocation(String path, FileLocationStorage storage) {
        if (path == null) throw new IllegalArgumentException("path must not be null");
        this.path = path;

        if (storage == null) throw new IllegalArgumentException("storage must not be null");
        this.storage = storage;
    }

    public static FileLocation forS3(String path) {
        if (!path.contains("s3://"))
            throw new IllegalArgumentException("path must start with \"s3://\"");

        return new FileLocation(path, FileLocationStorage.S3);
    }

    //endregion

    //region getters
    public String path() {
        return this.path;
    }

    //endregion

    //region methods
    public boolean fromS3() {
        return storage == FileLocationStorage.S3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FileLocation)) return false;
        FileLocation fileLocation = (FileLocation) o;
        return storage.equals(fileLocation.storage)
                && path.equals(fileLocation.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storage, path);
    }

    //endregion
}

