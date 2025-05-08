package com.nutri_track.application.use_cases.professionals;

import com.nutri_track.application.dtos.ProfessionalFileDto;
import com.nutri_track.domain.exceptions.FileNotFoundException;
import com.nutri_track.domain.factories.FileStorageFactory;
import com.nutri_track.domain.repositories.FileRepository;
import com.nutri_track.domain.specifications.drive.file.FileHasIdSpecification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class GetProfessionalFileUseCase {
    private final FileRepository fileRepository;
    private final FileStorageFactory fileStorageFactory;

    public GetProfessionalFileUseCase(
            FileRepository fileRepository,
            FileStorageFactory fileStorageFactory) {
        this.fileRepository = fileRepository;
        this.fileStorageFactory = fileStorageFactory;
    }

    public ProfessionalFileDto execute(UUID fileId) {
        var spec = new FileHasIdSpecification(fileId);
        var file = fileRepository.findOne(spec)
                .orElseThrow(() -> new FileNotFoundException(fileId));


        var path = file.path();
        var fileStorage = fileStorageFactory.createFromPath(path);
        var content = new byte[0];

        try {
            content = fileStorage.retrieve(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new ProfessionalFileDto(file.name(), content);
    }
}
