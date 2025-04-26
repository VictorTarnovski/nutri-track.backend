package com.nutri_track.presentation.controllers;

import com.nutri_track.application.use_cases.GetProfessionalUseCase;
import com.nutri_track.domain.dtos.GetProfessionalsDto;
import com.nutri_track.application.use_cases.CreateProfessionalUseCase;
import com.nutri_track.application.use_cases.GetProfessionalsUseCase;
import com.nutri_track.domain.dtos.ProfessionalDto;
import com.nutri_track.domain.dtos.CreateProfessionalDto;
import com.nutri_track.domain.dtos.PaginationDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professionals")
public class ProfessionalsController {
    private final CreateProfessionalUseCase createProfessionalUseCase;
    private final GetProfessionalUseCase getProfessionalUseCase;
    private final GetProfessionalsUseCase getProfessionalsUseCase;

    public ProfessionalsController(
            CreateProfessionalUseCase createProfessionalUseCase,
            GetProfessionalUseCase getProfessionalUseCase,
            GetProfessionalsUseCase getProfessionalsUseCase) {
        this.createProfessionalUseCase = createProfessionalUseCase;
        this.getProfessionalUseCase = getProfessionalUseCase;
        this.getProfessionalsUseCase = getProfessionalsUseCase;
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
}