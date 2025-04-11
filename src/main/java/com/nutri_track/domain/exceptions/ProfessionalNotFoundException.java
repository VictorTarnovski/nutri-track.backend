package com.nutri_track.domain.exceptions;

public class ProfessionalNotFoundException extends NutriTrackRuntimeException {
    public ProfessionalNotFoundException(long professionalId) {
        super("Professional#" + professionalId + " was not found");
    }
}
