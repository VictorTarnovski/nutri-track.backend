package com.nutri_track.application.use_cases;

import com.nutri_track.domain.entities.Patient;
import com.nutri_track.domain.exceptions.PatientAlreadyRegisteredException;
import com.nutri_track.domain.repositories.PatientRepository;
import com.nutri_track.domain.specifications.PatientHasDocumentSpecification;
import com.nutri_track.domain.specifications.PatientHasIdSpecification;
import com.nutri_track.application.dtos.CreatePatientDto;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CreatePatientUseCase {
    private final PatientRepository patientRepository;

    public CreatePatientUseCase(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient execute(CreatePatientDto dto) {
        Specification<Patient> spec = new PatientHasDocumentSpecification(dto.document());
        var existingPatient = patientRepository.findOne(spec);
        if (existingPatient.isPresent()) {
            throw new PatientAlreadyRegisteredException(existingPatient.get());
        }

        var patient = new Patient(
                dto.document(),
                dto.firstName(),
                dto.lastName(),
                dto.address().toAddress()
        );
        patientRepository.save(patient);
        spec = new PatientHasIdSpecification(patient.id());
        return patientRepository.findOne(spec).get();
    }
}