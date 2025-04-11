package com.nutri_track.domain.dtos;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
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