package com.nutri_track.presentation.controllers;

import com.nutri_track.application.use_cases.patients.GetPatientUseCase;
import com.nutri_track.application.dtos.patients.GetPatientsDto;
import com.nutri_track.application.use_cases.patients.CreatePatientUseCase;
import com.nutri_track.application.use_cases.patients.GetPatientsUseCase;
import com.nutri_track.application.dtos.patients.PatientDto;
import com.nutri_track.application.dtos.patients.CreatePatientDto;
import com.nutri_track.application.dtos.PaginationDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientsController {

    private final CreatePatientUseCase createPatientUseCase;
    private final GetPatientUseCase getPatientUseCase;
    private final GetPatientsUseCase getPatientsUseCase;

    public PatientsController(
            CreatePatientUseCase createPatientUseCase,
            GetPatientUseCase getPatientUseCase,
            GetPatientsUseCase getPatientsUseCase) {
        this.createPatientUseCase = createPatientUseCase;
        this.getPatientUseCase = getPatientUseCase;
        this.getPatientsUseCase = getPatientsUseCase;
    }

    @PostMapping
    public ResponseEntity<PatientDto> CreatePatient(
            @Valid
            @RequestBody
            CreatePatientDto dto) {
        var patient = createPatientUseCase.execute(dto);
        return ResponseEntity.ok(new PatientDto(patient));
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<PatientDto> FindOne(@PathVariable long patientId) {
        var patient = getPatientUseCase.execute(patientId);
        return ResponseEntity.ok(new PatientDto(patient));
    }

    @GetMapping
    public ResponseEntity<PaginationDto<PatientDto>> FindAll(GetPatientsDto query) {
        var page = getPatientsUseCase.execute(query).map(PatientDto::new);
        return ResponseEntity.ok(new PaginationDto<>(page));
    }
}
