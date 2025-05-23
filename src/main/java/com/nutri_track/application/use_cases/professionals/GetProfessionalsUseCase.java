package com.nutri_track.application.use_cases.professionals;

import com.nutri_track.application.dtos.professionals.GetProfessionalsDto;
import com.nutri_track.domain.entities.Professional;
import com.nutri_track.domain.repositories.ProfessionalRepository;
import com.nutri_track.domain.specifications.professionals.ProfessionalHasIdInRangeSpecification;
import com.nutri_track.domain.specifications.professionals.ProfessionalHasSpecialtiesSpecification;
import com.nutri_track.domain.specifications.professionals.ProfessionalIsNotNullSpecification;
import com.nutri_track.domain.specifications.professionals.ProfessionalSearchSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class GetProfessionalsUseCase {
    private final ProfessionalRepository professionalRepository;

    public GetProfessionalsUseCase(ProfessionalRepository professionalRepository) {
       this.professionalRepository = professionalRepository;
    }

    public Page<Professional> execute(GetProfessionalsDto dto) {
        Specification<Professional> spec = new ProfessionalIsNotNullSpecification();

        if (dto.ids().isPresent()) {
            spec = spec.and(
                    new ProfessionalHasIdInRangeSpecification(dto.ids().get())
            );
        }

        if (dto.specialtyIds().isPresent()) {
            spec = spec.and(
              new ProfessionalHasSpecialtiesSpecification(dto.specialtyIds().get())
            );
        }

        if (dto.search().isPresent()) {
            spec = spec.and(
                    new ProfessionalSearchSpecification(dto.search().get())
            );
        }

        var pageable = PageRequest.of(dto.page(), dto.pageSize());
        return professionalRepository.findAll(spec, pageable);
    }
}
