package com.nutri_track.application.use_cases.patients;

import com.nutri_track.application.dtos.patients.GetPatientsDto;
import com.nutri_track.domain.entities.Patient;
import com.nutri_track.domain.repositories.PatientRepository;
import com.nutri_track.domain.specifications.PatientHasIdInRangeSpecification;
import com.nutri_track.domain.specifications.PatientIsNotNullSpecification;
import com.nutri_track.domain.specifications.PatientSearchSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class GetPatientsUseCase {
    private final PatientRepository patientRepository;

    public GetPatientsUseCase(PatientRepository patientRepository) {
       this.patientRepository = patientRepository;
    }

    public Page<Patient> execute(GetPatientsDto dto) {
        Specification<Patient> spec = new PatientIsNotNullSpecification();

        if (dto.ids().isPresent()) {
            spec = spec.and(
                    new PatientHasIdInRangeSpecification(dto.ids().get())
            );
        }

        if (dto.search().isPresent()) {
            spec = spec.and(
                    new PatientSearchSpecification(dto.search().get())
            );
        }

        var pageable = PageRequest.of(dto.page(), dto.pageSize());
        return patientRepository.findAll(spec, pageable);
    }
}
