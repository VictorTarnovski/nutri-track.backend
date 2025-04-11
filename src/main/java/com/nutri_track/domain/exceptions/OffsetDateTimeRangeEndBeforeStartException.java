package com.nutri_track.domain.exceptions;

import java.time.OffsetDateTime;

public class OffsetDateTimeRangeEndBeforeStartException extends NutriTrackRuntimeException {
    public OffsetDateTimeRangeEndBeforeStartException(OffsetDateTime start, OffsetDateTime end) {
        super("Invalid date time range: " + end + " is before " + start);
    }
}
