package com.nutri_track.application.dtos.professionals;

import com.nutri_track.application.dtos.PaginatedDto;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class GetProfessionalsDto extends PaginatedDto {
    private List<Long> ids;
    private Set<Long> specialtyIds;
    private String search;

    public GetProfessionalsDto(
            List<Long> ids,
            Set<Long> specialtyIds,
            String search,
            Integer page,
            Integer pageSize) {
        super(page, pageSize);
        this.ids = ids;
        this.specialtyIds = specialtyIds;
        this.search = search;
    }

    public Optional<List<Long>> ids() {
        return Optional.ofNullable(this.ids);
    }

    public Optional<Set<Long>> specialtyIds() {
        return Optional.ofNullable(specialtyIds);
    }

    public Optional<String> search() {
        return Optional.ofNullable(this.search);
    }
}
