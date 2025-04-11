package com.nutri_track.domain.dtos;

public class GetAppointmentsDto extends PaginatedDto {
    public GetAppointmentsDto(Integer page, Integer pageSize) {
        super(page, pageSize);
    }
}
