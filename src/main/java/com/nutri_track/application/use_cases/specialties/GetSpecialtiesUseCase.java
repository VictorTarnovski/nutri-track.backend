package com.nutri_track.application.use_cases.specialties;

import com.nutri_track.application.dtos.specialties.GetSpecialtiesDto;
import com.nutri_track.domain.value_objects.Specialty;
import com.nutri_track.domain.repositories.SpecialtyRepository;
import com.nutri_track.domain.specifications.specialties.SpecialtyHasIdInRangeSpecification;
import com.nutri_track.domain.specifications.specialties.SpecialtyIsNotNullSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class GetSpecialtiesUseCase {
    private final SpecialtyRepository professionalRepository;

    public GetSpecialtiesUseCase(SpecialtyRepository professionalRepository) {
       this.professionalRepository = professionalRepository;
    }

    public Page<Specialty> execute(GetSpecialtiesDto dto) {
        Specification<Specialty> spec = new SpecialtyIsNotNullSpecification();

        if (dto.ids().isPresent()) {
            spec = spec.and(
                    new SpecialtyHasIdInRangeSpecification(dto.ids().get())
            );
        }

        var pageable = PageRequest.of(dto.page(), dto.pageSize());
        return professionalRepository.findAll(spec, pageable);
    }
}
