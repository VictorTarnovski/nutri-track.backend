package com.nutri_track.application.use_cases;

import com.nutri_track.domain.value_objects.Specialty;
import com.nutri_track.domain.exceptions.SpecialtyNotFoundException;
import com.nutri_track.domain.repositories.SpecialtyRepository;
import com.nutri_track.domain.specifications.SpecialtyHasIdSpecification;
import org.springframework.stereotype.Service;

@Service
public class GetSpecialtyUseCase {
    private final SpecialtyRepository specialtyRepository;

    public GetSpecialtyUseCase(SpecialtyRepository specialtyRepository) {
       this.specialtyRepository = specialtyRepository;
    }

    public Specialty execute(long id) {
        var spec = new SpecialtyHasIdSpecification(id);
        return specialtyRepository
                .findOne(spec)
                .orElseThrow(() -> new SpecialtyNotFoundException(id));
    }
}
