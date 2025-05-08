package com.nutri_track.domain.specifications.drive.folder;

import com.nutri_track.domain.entities.Folder;
import com.nutri_track.domain.specifications.drive.DriveItemHasParentSpecification;

public class FolderHasParentSpecification extends DriveItemHasParentSpecification<Folder> {
    public FolderHasParentSpecification(Folder parent) {
        super(parent);
    }
}
