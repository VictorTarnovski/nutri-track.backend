package com.nutri_track.application.dtos.patients;

import com.nutri_track.application.dtos.PaginatedDto;

import java.util.List;
import java.util.Optional;

public class GetPatientsDto extends PaginatedDto {
    private List<Long> ids;
    private final String search;

    public GetPatientsDto(List<Long> ids, String search, Integer page, Integer pageSize) {
        super(page, pageSize);
        this.ids = ids;
        this.search = search;
    }

    public Optional<List<Long>> ids() {
        return Optional.ofNullable(this.ids);
    }

    public Optional<String> search() {
        return Optional.ofNullable(this.search);
    }
}
