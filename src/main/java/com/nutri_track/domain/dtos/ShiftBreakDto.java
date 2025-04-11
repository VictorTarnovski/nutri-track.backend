package com.nutri_track.domain.dtos;

import com.nutri_track.domain.entities.ShiftBreak;

import java.time.OffsetDateTime;

public class ShiftBreakDto {
    public OffsetDateTime start;
    public OffsetDateTime end;

    public ShiftBreakDto(ShiftBreak shiftBreak) {
        this.start = shiftBreak.duration().start();
        this.end = shiftBreak.duration().end();
    }
}
