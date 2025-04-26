package com.nutri_track.presentation.controllers;

import com.nutri_track.application.use_cases.GetSpecialtyUseCase;
import com.nutri_track.application.use_cases.GetSpecialtiesUseCase;
import com.nutri_track.application.dtos.specialties.GetSpecialtiesDto;
import com.nutri_track.application.dtos.PaginationDto;
import com.nutri_track.application.dtos.specialties.SpecialtyDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/specialties")
public class SpecialtiesController {
    private final GetSpecialtyUseCase getSpecialtyUseCase;
    private final GetSpecialtiesUseCase getSpecialtiesUseCase;

    public SpecialtiesController(
            GetSpecialtyUseCase getSpecialtyUseCase,
            GetSpecialtiesUseCase getSpecialtiesUseCase) {
        this.getSpecialtyUseCase = getSpecialtyUseCase;
        this.getSpecialtiesUseCase = getSpecialtiesUseCase;
    }

    @GetMapping("/{specialtyId}")
    public ResponseEntity<SpecialtyDto> FindOne(@PathVariable long specialtyId) {
        var specialty = getSpecialtyUseCase.execute(specialtyId);
        return ResponseEntity.ok(new SpecialtyDto(specialty));
    }

    @GetMapping
    public ResponseEntity<PaginationDto<SpecialtyDto>> FindAll(GetSpecialtiesDto query) {
        var page = getSpecialtiesUseCase.execute(query).map(SpecialtyDto::new);
        return ResponseEntity.ok(new PaginationDto<>(page));
    }
}