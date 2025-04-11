package com.nutri_track.application.use_cases;

import com.nutri_track.domain.entities.Professional;
import com.nutri_track.domain.exceptions.ProfessionalNotFoundException;
import com.nutri_track.domain.repositories.ProfessionalRepository;
import com.nutri_track.domain.specifications.ProfessionalHasIdSpecification;
import org.springframework.stereotype.Component;

@Component
public class GetProfessionalUseCase {
    private final ProfessionalRepository professionalRepository;

    public GetProfessionalUseCase(ProfessionalRepository professionalRepository) {
       this.professionalRepository = professionalRepository;
    }

    public Professional execute(long id) {
        var spec = new ProfessionalHasIdSpecification(id);
        return professionalRepository
                .findOne(spec)
                .orElseThrow(() -> new ProfessionalNotFoundException(id));
    }
}
