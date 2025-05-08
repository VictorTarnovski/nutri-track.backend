package com.nutri_track.domain.specifications;

import com.nutri_track.domain.entities.Folder;
import com.nutri_track.domain.specifications.drive.DriveItemHasProfessionalIdSpecification;

public class FolderHasProfessionalIdSpecification extends DriveItemHasProfessionalIdSpecification<Folder> {
    public FolderHasProfessionalIdSpecification(long professionalId) {
        super(professionalId);
    }
}
