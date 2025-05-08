package com.nutri_track.domain.specifications;

import com.nutri_track.domain.entities.Folder;
import com.nutri_track.domain.specifications.drive.DriveItemHasNameSpecification;

public class FolderHasNameSpecification extends DriveItemHasNameSpecification<Folder> {
    public FolderHasNameSpecification(String name) {
        super(name);
    }
}
