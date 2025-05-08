package com.nutri_track.domain.specifications.drive.folder;

import com.nutri_track.domain.entities.Folder;
import com.nutri_track.domain.specifications.drive.DriveItemHasIdSpecification;

import java.util.UUID;

public class FolderHasIdSpecification extends DriveItemHasIdSpecification<Folder> {
    public FolderHasIdSpecification(UUID fileId) {
        super(fileId);
    }
}
