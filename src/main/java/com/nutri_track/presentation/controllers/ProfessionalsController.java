package com.nutri_track.presentation.controllers;

import com.nutri_track.application.dtos.DriveDtoFactory;
import com.nutri_track.application.use_cases.professionals.*;
import com.nutri_track.application.dtos.professionals.GetProfessionalsDto;
import com.nutri_track.application.dtos.professionals.ProfessionalDto;
import com.nutri_track.application.dtos.professionals.CreateProfessionalDto;
import com.nutri_track.application.dtos.PaginationDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/professionals")
public class ProfessionalsController {
    private final CreateProfessionalUseCase createProfessionalUseCase;
    private final GetProfessionalUseCase getProfessionalUseCase;
    private final GetProfessionalsUseCase getProfessionalsUseCase;
    private final GetProfessionalDriveUseCase getProfessionalDriveUseCase;
    private final CreateProfessionalFileUseCase createProfessionalFileUseCase;

    public ProfessionalsController(
            CreateProfessionalUseCase createProfessionalUseCase,
            GetProfessionalUseCase getProfessionalUseCase,
            GetProfessionalsUseCase getProfessionalsUseCase,
            GetProfessionalDriveUseCase getProfessionalDriveUseCase,
            CreateProfessionalFileUseCase createProfessionalFileUseCase) {
        this.createProfessionalUseCase = createProfessionalUseCase;
        this.getProfessionalUseCase = getProfessionalUseCase;
        this.getProfessionalsUseCase = getProfessionalsUseCase;
        this.getProfessionalDriveUseCase = getProfessionalDriveUseCase;
        this.createProfessionalFileUseCase = createProfessionalFileUseCase;
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

    @PostMapping("{professionalId}/drive")
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

    @GetMapping("{professionalId}/drive")
    public ResponseEntity<?> FindDrive(@PathVariable long professionalId) {
        var drive = getProfessionalDriveUseCase.execute(professionalId)
                .stream()
                .map(DriveDtoFactory::create)
                .toList();
        return ResponseEntity.ok(drive);
    }
}