package com.nutri_track.application.dtos.professionals;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateProfessionalFolderDto(
        @NotNull
        @NotBlank
        String name,
        UUID parentId) {
}
