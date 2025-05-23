package com.nutri_track.application.use_cases.patients;

import com.nutri_track.domain.entities.Patient;
import com.nutri_track.domain.exceptions.professionals.PatientAlreadyRegisteredException;
import com.nutri_track.domain.repositories.PatientRepository;
import com.nutri_track.domain.specifications.patients.PatientHasDocumentSpecification;
import com.nutri_track.domain.specifications.patients.PatientHasIdSpecification;
import com.nutri_track.application.dtos.patients.CreatePatientDto;
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
                dto.birthDate(),
                dto.address().toAddress()
        );
        patientRepository.save(patient);
        spec = new PatientHasIdSpecification(patient.id());
        return patientRepository.findOne(spec).get();
    }
}