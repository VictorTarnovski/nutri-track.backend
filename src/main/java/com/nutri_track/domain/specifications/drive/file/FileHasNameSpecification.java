package com.nutri_track.domain.specifications.drive.file;

import com.nutri_track.domain.entities.File;
import com.nutri_track.domain.specifications.drive.DriveItemHasNameSpecification;

public class FileHasNameSpecification extends DriveItemHasNameSpecification<File> {
    public FileHasNameSpecification(String name) {
        super(name);
    }
}
