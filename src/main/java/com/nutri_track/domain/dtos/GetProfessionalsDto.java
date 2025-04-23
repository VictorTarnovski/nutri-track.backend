package com.nutri_track.domain.dtos;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class GetProfessionalsDto extends PaginatedDto {
    private Optional<List<Long>> ids;
    private Set<Long> specialtyIds;
    private Optional<String> search;

    public GetProfessionalsDto(
            Optional<List<Long>> ids,
            Set<Long> specialtyIds,
            Optional<String> search,
            Integer page,
            Integer pageSize) {
        super(page, pageSize);
        this.ids = ids;
        this.specialtyIds = specialtyIds;
        this.search = search;
    }

    public Optional<List<Long>> ids() {
        return this.ids;
    }

    public Optional<Set<Long>> specialtyIds() {
        return Optional.ofNullable(specialtyIds);
    }

    public Optional<String> search() {
        return this.search;
    }
}
