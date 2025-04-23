package com.nutri_track.domain.exceptions;

public class SpecialtyNotFoundException extends NutriTrackRuntimeException {
    public SpecialtyNotFoundException(long specialtyId) {
        super("Specialty#" + specialtyId + " was not found");
    }
}
