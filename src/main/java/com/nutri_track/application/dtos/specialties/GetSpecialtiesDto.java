package com.nutri_track.application.dtos.specialties;

import com.nutri_track.application.dtos.PaginatedDto;

import java.util.List;
import java.util.Optional;

public class GetSpecialtiesDto extends PaginatedDto {
    private final List<Long> ids;

    public GetSpecialtiesDto(List<Long> ids, Integer page, Integer pageSize) {
        super(page, pageSize);
        this.ids = ids;
    }

    public Optional<List<Long>> ids() {
        return Optional.ofNullable(ids);
    }
}
