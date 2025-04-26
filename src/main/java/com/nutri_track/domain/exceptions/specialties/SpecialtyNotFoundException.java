package com.nutri_track.domain.exceptions.specialties;

import com.nutri_track.domain.exceptions.NutriTrackRuntimeException;

public class SpecialtyNotFoundException extends NutriTrackRuntimeException {
    public SpecialtyNotFoundException(long specialtyId) {
        super("Specialty#" + specialtyId + " was not found");
    }
}
