package com.nutri_track.application.use_cases.professionals;

import com.nutri_track.domain.entities.DriveItem;
import com.nutri_track.domain.repositories.DriveItemRepository;
import com.nutri_track.domain.specifications.drive.DriveItemHasParentSpecification;
import com.nutri_track.domain.specifications.drive.DriveItemHasProfessionalIdSpecification;
import com.nutri_track.domain.specifications.drive.DriveItemIsNotNullSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class GetProfessionalDriveUseCase {
    private final DriveItemRepository driveItemRepository;

    public GetProfessionalDriveUseCase(DriveItemRepository driveItemRepository) {
        this.driveItemRepository = driveItemRepository;
    }

    public Set<DriveItem> execute(long professionalId) {
        Specification<DriveItem> spec = new DriveItemIsNotNullSpecification();
        spec = spec.and(new DriveItemHasParentSpecification(null));
        spec = spec.and(new DriveItemHasProfessionalIdSpecification(professionalId));
        return new HashSet<>(driveItemRepository.findAll(spec));
    }
}
