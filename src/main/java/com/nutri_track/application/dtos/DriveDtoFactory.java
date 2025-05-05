package com.nutri_track.application.dtos;

import com.nutri_track.domain.entities.DriveItem;
import com.nutri_track.domain.entities.File;
import com.nutri_track.domain.entities.Folder;

public class DriveDtoFactory {
    public static Object create(DriveItem driveItem) {
        if(driveItem.getClass() == Folder.class) {
            return new FolderDto((Folder) driveItem);
        }

        return new FileDto((File) driveItem);
    }
}
