package com.nutri_track.domain.exceptions;

import java.util.UUID;

public class FileNotFoundException extends NutriTrackRuntimeException {
    public FileNotFoundException(UUID id) {
        super("File#'" + id +"' was not found!");
    }
}
