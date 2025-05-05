package com.nutri_track.application.dtos;

import com.nutri_track.domain.entities.DriveItem;

public class DriveItemDto {
    public String name;

    public DriveItemDto(DriveItem driveItem) {
        name = driveItem.name();
    }
}
