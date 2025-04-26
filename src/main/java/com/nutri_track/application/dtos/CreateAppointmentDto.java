package com.nutri_track.application.dtos;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.OffsetDateTime;

public record CreateAppointmentDto(
        @NotNull
        @Positive
        long patientId,
        @NotNull
        @Positive
        long professionalId,
        @NotNull
        @Future
        OffsetDateTime scheduledToStart,
        @NotNull
        @Future
        OffsetDateTime scheduledToEnd
) {}