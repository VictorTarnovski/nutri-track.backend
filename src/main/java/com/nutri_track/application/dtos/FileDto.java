package com.nutri_track.application.dtos;

import com.nutri_track.domain.entities.File;

public class FileDto extends DriveItemDto {
    public String name;
    public String path;

    public FileDto(File file) {
        super(file);
        path = file.location().path();
    }
}
