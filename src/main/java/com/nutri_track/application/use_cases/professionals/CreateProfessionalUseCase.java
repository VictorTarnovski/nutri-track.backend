package com.nutri_track.application.use_cases.professionals;

import com.nutri_track.domain.entities.Professional;
import com.nutri_track.domain.exceptions.ProfessionalAlreadyRegisteredException;
import com.nutri_track.domain.repositories.ProfessionalRepository;
import com.nutri_track.domain.specifications.ProfessionalHasDocumentSpecification;
import com.nutri_track.domain.specifications.ProfessionalHasIdSpecification;
import com.nutri_track.application.dtos.professionals.CreateProfessionalDto;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CreateProfessionalUseCase {
    private final ProfessionalRepository professionalRepository;

    public CreateProfessionalUseCase(ProfessionalRepository professionalRepository) {
        this.professionalRepository = professionalRepository;
    }

    public Professional execute(CreateProfessionalDto dto) {
        Specification<Professional> spec = new ProfessionalHasDocumentSpecification(dto.document());
        var existingProfessional = professionalRepository.findOne(spec);
        if (existingProfessional.isPresent()) {
            throw new ProfessionalAlreadyRegisteredException(existingProfessional.get());
        }

        var professional = new Professional(
                dto.document(),
                dto.firstName(),
                dto.lastName(),
                dto.address().toAddress()
        );
        professionalRepository.save(professional);
        spec = new ProfessionalHasIdSpecification(professional.id());
        return professionalRepository.findOne(spec).get();
    }
}