package com.nutri_track.application.dtos;

public class GetAppointmentsDto extends PaginatedDto {
    public GetAppointmentsDto(Integer page, Integer pageSize) {
        super(page, pageSize);
    }
}
