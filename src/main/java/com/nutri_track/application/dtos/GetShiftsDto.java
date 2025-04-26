package com.nutri_track.application.dtos;

public class GetShiftsDto extends PaginatedDto {
    public GetShiftsDto(Integer page, Integer pageSize) {
        super(page, pageSize);
    }
}
