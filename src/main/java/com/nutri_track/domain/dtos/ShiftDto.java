package com.nutri_track.domain.dtos;

import com.nutri_track.domain.entities.Shift;

import java.time.OffsetDateTime;
import java.util.List;

public class ShiftDto extends EntityDto {
    public Long professionalId;

    public OffsetDateTime durationStart;
    public OffsetDateTime durationEnd;

    public List<ShiftBreakDto> breaks;

    public ShiftDto(Shift shift) {
        super(shift.id());
        this.professionalId = shift.professionalId();
        this.durationStart = shift.duration().start();
        this.durationEnd = shift.duration().end();
        this.breaks = shift.breaks().stream().map(ShiftBreakDto::new).toList();
    }
}
