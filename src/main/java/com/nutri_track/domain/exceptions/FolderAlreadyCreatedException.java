package com.nutri_track.domain.exceptions;

import com.nutri_track.domain.entities.Folder;

public class FolderAlreadyCreatedException extends NutriTrackRuntimeException {
    public FolderAlreadyCreatedException(Folder folder) {
        super("Folder with name '" + folder.name() +"' already created!");
    }
}
