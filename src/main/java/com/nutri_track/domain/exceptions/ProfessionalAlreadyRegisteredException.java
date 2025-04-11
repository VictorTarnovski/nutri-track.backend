package com.nutri_track.domain.exceptions;

import com.nutri_track.domain.entities.Professional;

public class ProfessionalAlreadyRegisteredException extends NutriTrackRuntimeException {
    public ProfessionalAlreadyRegisteredException(Professional professional) {
        super("Professional with document '" + professional.document() +"' already registered!");
    }
}