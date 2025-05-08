package com.nutri_track.domain.specifications.drive.file;

import com.nutri_track.domain.entities.File;
import com.nutri_track.domain.specifications.drive.DriveItemHasIdSpecification;

import java.util.UUID;

public class FileHasIdSpecification extends DriveItemHasIdSpecification<File> {
    public FileHasIdSpecification(UUID id) {
        super(id);
    }
}
