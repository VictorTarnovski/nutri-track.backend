package com.nutri_track.domain.specifications;

import com.nutri_track.domain.entities.File;

public class FileHasProfessionalIdSpecification extends DriveItemHasProfessionalIdSpecification<File> {
    public FileHasProfessionalIdSpecification(long professionalId) {
        super(professionalId);
    }
}
