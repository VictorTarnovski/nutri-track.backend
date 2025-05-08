package com.nutri_track.application.dtos;

import com.nutri_track.domain.entities.File;
import jakarta.persistence.DiscriminatorValue;

public class FileDto extends DriveItemDto {
    public String name;
    public String path;
    public String mimeType;

    public FileDto(File file) {
        super(file);
        this.name = file.name();
        this.path = file.path();
        this.mimeType = mimeType(file);
    }

    private String mimeType(File file) {
        DiscriminatorValue mimeType = file.getClass().getAnnotation(DiscriminatorValue.class);
        return mimeType == null ? null : mimeType.value();
    }
}
