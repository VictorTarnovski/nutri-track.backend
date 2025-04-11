package com.nutri_track.presentation.controllers;

import com.nutri_track.domain.dtos.GetShiftsDto;
import com.nutri_track.application.use_cases.GetShiftsUseCase;
import com.nutri_track.domain.dtos.ShiftDto;
import com.nutri_track.domain.dtos.PaginationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shifts")
public class ShiftsController {
    private final GetShiftsUseCase getShiftsUseCase;

    public ShiftsController(GetShiftsUseCase getShiftsUseCase) {
        this.getShiftsUseCase = getShiftsUseCase;
    }

    @GetMapping
    public ResponseEntity<PaginationDto<ShiftDto>> FindAll(GetShiftsDto query) {
        var page = getShiftsUseCase.execute(query).map(ShiftDto::new);
        return ResponseEntity.ok(new PaginationDto<>(page));
    } 
}
