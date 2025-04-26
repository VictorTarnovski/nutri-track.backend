package com.nutri_track.domain.exceptions.professionals;

import com.nutri_track.domain.entities.Professional;
import com.nutri_track.domain.exceptions.NutriTrackRuntimeException;

public class ProfessionalAlreadyRegisteredException extends NutriTrackRuntimeException {
    public ProfessionalAlreadyRegisteredException(Professional professional) {
        super("Professional with document '" + professional.document() +"' already registered!");
    }
}