package com.nutri_track.domain.specifications;

import com.nutri_track.domain.entities.Folder;

import java.util.UUID;

public class FolderHasIdSpecification extends DriveItemHasIdSpecification<Folder> {
    public FolderHasIdSpecification(UUID fileId) {
        super(fileId);
    }
}
