package com.nutri_track.application.use_cases.patients;

import com.nutri_track.domain.entities.Patient;
import com.nutri_track.domain.exceptions.professionals.PatientNotFoundException;
import com.nutri_track.domain.repositories.PatientRepository;
import com.nutri_track.domain.specifications.patients.PatientHasIdSpecification;
import org.springframework.stereotype.Service;

@Service
public class GetPatientUseCase {
    private final PatientRepository patientRepository;

    public GetPatientUseCase(PatientRepository patientRepository) {
       this.patientRepository = patientRepository;
    }

    public Patient execute(long id) {
        var spec = new PatientHasIdSpecification(id);
        return patientRepository
                .findOne(spec)
                .orElseThrow(() -> new PatientNotFoundException(id));
    }
}
