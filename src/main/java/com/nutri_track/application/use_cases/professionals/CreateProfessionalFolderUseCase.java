package com.nutri_track.application.use_cases.professionals;

import com.nutri_track.domain.entities.Folder;
import com.nutri_track.domain.exceptions.FolderAlreadyCreatedException;
import com.nutri_track.domain.exceptions.professionals.ProfessionalNotFoundException;
import com.nutri_track.domain.repositories.FolderRepository;
import com.nutri_track.domain.repositories.ProfessionalRepository;
import com.nutri_track.domain.specifications.*;
import com.nutri_track.domain.specifications.professionals.ProfessionalHasIdSpecification;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateProfessionalFolderUseCase {
    private final ProfessionalRepository professionalRepository;
    private final FolderRepository folderRepository;

    public CreateProfessionalFolderUseCase(
            ProfessionalRepository professionalRepository,
            FolderRepository folderRepository) {
        this.professionalRepository = professionalRepository;
        this.folderRepository = folderRepository;
    }

    public void execute(long professionalId, String name, UUID parentId) {
        var professionalSpec = new ProfessionalHasIdSpecification(professionalId);
        var professional = professionalRepository
                .findOne(professionalSpec)
                .orElseThrow(() -> new ProfessionalNotFoundException(professionalId));

        Folder parent = null;

        if (parentId != null) {
            var spec = new FolderHasIdSpecification(parentId);
            var opt = folderRepository.findOne(spec);
            if (opt.isPresent()) {
                parent = opt.get();
            }
        }

        var folderSpec = new FolderHasNameSpecification(name)
                .and(new FolderHasProfessionalIdSpecification(professionalId))
                .and(new FolderHasParentSpecification(parent));

        var existingFolder = folderRepository.findOne(folderSpec);
        if (existingFolder.isPresent()) {
            throw new FolderAlreadyCreatedException(existingFolder.get());
        }

        var folder = new Folder(name, professional, parent);
        folderRepository.save(folder);
    }
}
