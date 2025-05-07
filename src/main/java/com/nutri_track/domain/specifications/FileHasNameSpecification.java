package com.nutri_track.domain.specifications;

import com.nutri_track.domain.entities.File;

public class FileHasNameSpecification extends DriveItemHasNameSpecification<File> {
    public FileHasNameSpecification(String name) {
        super(name);
    }
}
