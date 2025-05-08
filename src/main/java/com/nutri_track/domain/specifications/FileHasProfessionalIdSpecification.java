package com.nutri_track.domain.specifications;

import com.nutri_track.domain.entities.File;
import com.nutri_track.domain.specifications.drive.DriveItemHasProfessionalIdSpecification;

public class FileHasProfessionalIdSpecification extends DriveItemHasProfessionalIdSpecification<File> {
    public FileHasProfessionalIdSpecification(long professionalId) {
        super(professionalId);
    }
}
