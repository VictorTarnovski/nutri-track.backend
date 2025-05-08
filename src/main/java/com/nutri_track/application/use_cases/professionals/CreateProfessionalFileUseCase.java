package com.nutri_track.application.use_cases.professionals;

import com.nutri_track.domain.entities.File;
import com.nutri_track.domain.entities.Folder;
import com.nutri_track.domain.exceptions.FileAlreadyCreatedException;
import com.nutri_track.domain.exceptions.professionals.ProfessionalNotFoundException;
import com.nutri_track.domain.factories.FileStorageFactory;
import com.nutri_track.domain.repositories.FileRepository;
import com.nutri_track.domain.repositories.FolderRepository;
import com.nutri_track.domain.repositories.ProfessionalRepository;
import com.nutri_track.domain.specifications.drive.file.FileHasNameSpecification;
import com.nutri_track.domain.specifications.drive.file.FileHasParentSpecification;
import com.nutri_track.domain.specifications.drive.file.FileHasProfessionalIdSpecification;
import com.nutri_track.domain.specifications.drive.folder.FolderHasIdSpecification;
import com.nutri_track.domain.specifications.professionals.ProfessionalHasIdSpecification;
import com.nutri_track.domain.value_objects.FileLocation;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class CreateProfessionalFileUseCase {
    private final FileStorageFactory fileStorageFactory;
    private final ProfessionalRepository professionalRepository;
    private final FileRepository fileRepository;
    private final FolderRepository folderRepository;

    public CreateProfessionalFileUseCase(
            FileStorageFactory fileStorageFactory,
            ProfessionalRepository professionalRepository,
            FileRepository fileRepository,
            FolderRepository folderRepository) {
        this.fileStorageFactory = fileStorageFactory;
        this.professionalRepository = professionalRepository;
        this.fileRepository = fileRepository;
        this.folderRepository = folderRepository;
    }

    public void execute(long professionalId, String name, MultipartFile multipartFile, UUID parentId) {
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

        var fileSpec = new FileHasNameSpecification(name)
                .and(new FileHasProfessionalIdSpecification(professionalId))
                .and(new FileHasParentSpecification(parent));

        var existingFile = fileRepository.findOne(fileSpec);
        if (existingFile.isPresent()) {
            throw new FileAlreadyCreatedException(existingFile.get());
        }

        FileLocation location = null;

        try {
            var fileContent = multipartFile.getBytes();
            var fileStorage = fileStorageFactory.create();
            location = fileStorage.store(fileContent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        var file = new File(name, location, professional, parent);
        fileRepository.save(file);
    }
}
