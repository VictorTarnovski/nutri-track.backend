package com.nutri_track.presentation.controllers;

import com.nutri_track.application.use_cases.*;
import com.nutri_track.domain.dtos.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
public class AppointmentsController {
    private final CreateAppointmentUseCase createAppointmentUseCase;
    private final UpdateAppointmentUseCase updateAppointmentUseCase;
    private final GetAppointmentsUseCase getAppointmentsUseCase;
    private final ConfirmAppointmentUseCase confirmAppointmentUseCase;
    private final CancelAppointmentUseCase cancelAppointmentUseCase;

    public AppointmentsController(
            CreateAppointmentUseCase createAppointmentUseCase,
            UpdateAppointmentUseCase updateAppointmentUseCase,
            GetAppointmentsUseCase getAppointmentsUseCase,
            ConfirmAppointmentUseCase confirmAppointmentUseCase,
            CancelAppointmentUseCase cancelAppointmentUseCase) {
        this.createAppointmentUseCase = createAppointmentUseCase;
        this.updateAppointmentUseCase = updateAppointmentUseCase;
        this.getAppointmentsUseCase = getAppointmentsUseCase;
        this.confirmAppointmentUseCase = confirmAppointmentUseCase;
        this.cancelAppointmentUseCase = cancelAppointmentUseCase;
    }

    @PostMapping
    public ResponseEntity<AppointmentDto> CreateAppointment(
            @Valid
            @RequestBody
            CreateAppointmentDto dto) {
        var appointment = createAppointmentUseCase.execute(dto);
        return ResponseEntity.ok(new AppointmentDto(appointment));
    }

    @PatchMapping("/{appointmentId}")
    public ResponseEntity<AppointmentDto> UpdateAppointment(
            @PathVariable
            long appointmentId,
            @Valid
            @RequestBody
            UpdateAppointmentDto dto) {
        var appointment = updateAppointmentUseCase.execute(appointmentId, dto);
        return ResponseEntity.ok(new AppointmentDto(appointment));
    }

    @GetMapping
    public ResponseEntity<PaginationDto<AppointmentDto>> FindAll(GetAppointmentsDto query) {
        var page = getAppointmentsUseCase.execute(query).map(AppointmentDto::new);
        return ResponseEntity.ok(new PaginationDto<>(page));
    }

    @PostMapping("/{appointmentId}/confirm")
    public ResponseEntity<?> ConfirmAppointment(@PathVariable long appointmentId) {
        confirmAppointmentUseCase.execute(appointmentId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{appointmentId}/cancel")
    public ResponseEntity<?> CancelAppointment(@PathVariable long appointmentId) {
        cancelAppointmentUseCase.execute(appointmentId);
        return ResponseEntity.noContent().build();
    }
}
