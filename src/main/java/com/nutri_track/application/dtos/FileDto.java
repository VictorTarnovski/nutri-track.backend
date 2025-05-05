package com.nutri_track.application.dtos;

import com.nutri_track.domain.entities.File;

public class FileDto extends DriveItemDto {
    public String name;
    public String path;

    public FileDto(File file) {
        super(file);
        this.name = file.name();
        this.path = file.location().path();
    }
}
