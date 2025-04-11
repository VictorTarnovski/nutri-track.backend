package com.nutri_track.domain.exceptions;

import com.nutri_track.domain.value_objects.OffsetDateTimeRange;

public class ShiftBreakDurationNotWithinShiftDurationException extends NutriTrackRuntimeException {
    public ShiftBreakDurationNotWithinShiftDurationException(
            OffsetDateTimeRange shiftBreakDuration,
            OffsetDateTimeRange shiftDuration) {
        super("Break duration: " + shiftBreakDuration + "is not within the shift duration: " + shiftDuration);
    }
}
