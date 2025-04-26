package com.nutri_track.application.dtos;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Positive;

import java.time.OffsetDateTime;

public record UpdateAppointmentDto(
        @Positive
        Long patientId,
        @Positive
        Long professionalId,
        @Future
        OffsetDateTime scheduledToStart,
        @Future
        OffsetDateTime scheduledToEnd
) {}