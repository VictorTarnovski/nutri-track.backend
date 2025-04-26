package com.nutri_track.application.dtos.patients;

import com.nutri_track.application.dtos.PaginatedDto;

import java.util.List;
import java.util.Optional;

public class GetPatientsDto extends PaginatedDto {
    private Optional<List<Long>> ids;
    private Optional<String> search;

    public GetPatientsDto(Optional<List<Long>> ids, Optional<String> search, Integer page, Integer pageSize) {
        super(page, pageSize);
        this.ids = ids;
        this.search = search;
    }

    public Optional<List<Long>> ids() {
        return this.ids;
    }

    public Optional<String> search() {
        return this.search;
    }
}
