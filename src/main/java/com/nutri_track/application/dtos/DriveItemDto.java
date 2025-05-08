package com.nutri_track.application.dtos;

import com.nutri_track.domain.entities.DriveItem;

import java.util.UUID;

public class DriveItemDto {
    public UUID id;
    public String name;

    public DriveItemDto(DriveItem driveItem) {
        id = driveItem.id();
        name = driveItem.name();
    }
}
