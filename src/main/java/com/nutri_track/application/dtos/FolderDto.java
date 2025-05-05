package com.nutri_track.application.dtos;

import com.nutri_track.domain.entities.Folder;

import java.util.Set;
import java.util.stream.Collectors;

public class FolderDto extends DriveItemDto {
    public Set<Object> children;

    public FolderDto(Folder folder) {
        super(folder);
        this.children = folder.children()
                .stream()
                .map(DriveDtoFactory::create)
                .collect(Collectors.toUnmodifiableSet());
    }
}
