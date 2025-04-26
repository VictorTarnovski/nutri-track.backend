package com.nutri_track.application.dtos.appointments;

import com.nutri_track.application.dtos.PaginatedDto;

public class GetAppointmentsDto extends PaginatedDto {
    public GetAppointmentsDto(Integer page, Integer pageSize) {
        super(page, pageSize);
    }
}
