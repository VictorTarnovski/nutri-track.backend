package com.nutri_track.domain.exceptions.professionals;

import com.nutri_track.domain.exceptions.NutriTrackRuntimeException;

public class ProfessionalNotFoundException extends NutriTrackRuntimeException {
    public ProfessionalNotFoundException(long professionalId) {
        super("Professional#" + professionalId + " was not found");
    }
}
