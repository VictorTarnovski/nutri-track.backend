package com.nutri_track.presentation.controllers;

import com.nutri_track.application.dtos.DriveDtoFactory;
import com.nutri_track.application.dtos.professionals.CreateProfessionalFolderDto;
import com.nutri_track.application.use_cases.professionals.*;
import com.nutri_track.application.dtos.professionals.GetProfessionalsDto;
import com.nutri_track.application.dtos.professionals.ProfessionalDto;
import com.nutri_track.application.dtos.professionals.CreateProfessionalDto;
import com.nutri_track.application.dtos.PaginationDto;
import jakarta.validation.Valid;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.attribute.standard.Media;
import java.util.UUID;

@RestController
@RequestMapping("/professionals")
public class ProfessionalsController {
    private final CreateProfessionalUseCase createProfessionalUseCase;
    private final GetProfessionalUseCase getProfessionalUseCase;
    private final GetProfessionalsUseCase getProfessionalsUseCase;
    private final CreateProfessionalFileUseCase createProfessionalFileUseCase;
    private final CreateProfessionalFolderUseCase createProfessionalFolderUseCase;
    private final GetProfessionalDriveUseCase getProfessionalDriveUseCase;
    private final GetProfessionalFileUseCase getProfessionalFileUseCase;

    public ProfessionalsController(
            CreateProfessionalUseCase createProfessionalUseCase,
            GetProfessionalUseCase getProfessionalUseCase,
            GetProfessionalsUseCase getProfessionalsUseCase,
            CreateProfessionalFileUseCase createProfessionalFileUseCase,
            CreateProfessionalFolderUseCase createProfessionalFolderUseCase,
            GetProfessionalDriveUseCase getProfessionalDriveUseCase,
            GetProfessionalFileUseCase getProfessionalFileUseCase) {
        this.createProfessionalUseCase = createProfessionalUseCase;
        this.getProfessionalUseCase = getProfessionalUseCase;
        this.getProfessionalsUseCase = getProfessionalsUseCase;
        this.createProfessionalFileUseCase = createProfessionalFileUseCase;
        this.createProfessionalFolderUseCase = createProfessionalFolderUseCase;
        this.getProfessionalDriveUseCase = getProfessionalDriveUseCase;
        this.getProfessionalFileUseCase = getProfessionalFileUseCase;
    }

    @PostMapping
    public ResponseEntity<ProfessionalDto> CreateProfessional(
            @Valid
            @RequestBody
            CreateProfessionalDto dto) {
        var professional = createProfessionalUseCase.execute(dto);
        return ResponseEntity.ok(new ProfessionalDto(professional));
    }

    @GetMapping("/{professionalId}")
    public ResponseEntity<ProfessionalDto> FindOne(@PathVariable long professionalId) {
        var professional = getProfessionalUseCase.execute(professionalId);
        return ResponseEntity.ok(new ProfessionalDto(professional));
    }

    @GetMapping
    public ResponseEntity<PaginationDto<ProfessionalDto>> FindAll(GetProfessionalsDto query) {
        var page = getProfessionalsUseCase.execute(query).map(ProfessionalDto::new);
        return ResponseEntity.ok(new PaginationDto<>(page));
    }

    @PostMapping("{professionalId}/files")
    public ResponseEntity<?> CreateFile(
            @PathVariable long professionalId,
            @RequestParam("name") String name,
            @RequestParam("file") MultipartFile file,
            @RequestParam(name = "parent_id", required = false) UUID parentId) {
        createProfessionalFileUseCase.execute(
                professionalId,
                name,
                file,
                parentId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("{professionalId}/folders")
    public ResponseEntity<?> CreateFolder(
            @PathVariable
            long professionalId,
            @Valid
            @RequestBody
            CreateProfessionalFolderDto dto) {
        createProfessionalFolderUseCase.execute(
                professionalId,
                dto.name(),
                dto.parentId());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{professionalId}/drive")
    public ResponseEntity<?> FindDrive(@PathVariable long professionalId) {
        var drive = getProfessionalDriveUseCase.execute(professionalId)
                .stream()
                .map(DriveDtoFactory::create)
                .toList();
        return ResponseEntity.ok(drive);
    }

    @GetMapping(
            value = "{professionalId}/files/{fileId}",
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<?> FindFile(@PathVariable UUID fileId) {
        var dto = getProfessionalFileUseCase.execute(fileId);
        var headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + dto.fileName());
        var resource = new ByteArrayResource(dto.content());

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}