package com.nutri_track.domain.exceptions;

import com.nutri_track.domain.entities.File;

public class FileAlreadyCreatedException extends NutriTrackRuntimeException {
    public FileAlreadyCreatedException(File file) {
        super("File with name '" + file.name() +"' already created!");
    }
}
