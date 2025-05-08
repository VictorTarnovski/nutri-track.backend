package com.nutri_track.domain.specifications.drive.file;

import com.nutri_track.domain.entities.File;
import com.nutri_track.domain.entities.Folder;
import com.nutri_track.domain.specifications.drive.DriveItemHasParentSpecification;

public class FileHasParentSpecification extends DriveItemHasParentSpecification<File> {
    public FileHasParentSpecification(Folder parent) {
        super(parent);
    }
}
