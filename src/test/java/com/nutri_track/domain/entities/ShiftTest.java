package com.nutri_track.domain.entities;

import com.nutri_track.domain.exceptions.ShiftBreakDurationNotWithinShiftDurationException;
import com.nutri_track.domain.value_objects.OffsetDateTimeRange;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;

class ShiftTest {
    @Test
    void should_create_a_shift() {
        // Arrange
        var professional = new Professional();
        var start = Instant.now().atOffset(ZoneOffset.UTC);
        var end = Instant.now().atOffset(ZoneOffset.UTC).plusHours(6);
        var duration = new OffsetDateTimeRange(start, end);

        // Act
        var shift = new Shift(duration, professional);

        // Assert
        assertEquals(professional.id(), shift.professionalId());
        assertEquals(duration, shift.duration());
        assertEquals(0, shift.breaks().size());
    }

    Shift given_a_shift() {
        var professional = new Professional();
        var start = Instant.now().atOffset(ZoneOffset.UTC);
        var end = Instant.now().atOffset(ZoneOffset.UTC).plusHours(6);
        var duration = new OffsetDateTimeRange(start, end);
        return new Shift(duration, professional);
    }

    @Nested
    class add_break {
        @Test
        void should_add_a_break() {
            // Arrange
            var shift = given_a_shift();

            // Act
            var shiftBreak = new OffsetDateTimeRange(
                    shift.duration().start().plusHours(2),
                    shift.duration().start().plusHours(2).plusMinutes(5)
            );
            shift.addBreak(shiftBreak);

            // Assert
            assertEquals(1, shift.breaks().size());
        }

        @Test
        void should_not_add_a_break_when_break_start_is_before_shift_duration() {
            // Arrange
            var shift = given_a_shift();

            // Assert
            assertThrows(ShiftBreakDurationNotWithinShiftDurationException.class, () -> {
                var shiftBreak = new OffsetDateTimeRange(
                        shift.duration().start().minusHours(1),
                        shift.duration().end()
                );

                shift.addBreak(shiftBreak);
            });
        }

        @Test
        void should_not_add_a_break_when_break_end_is_after_shift_duration() {
            // Arrange
            var shift = given_a_shift();

            // Assert
            assertThrows(ShiftBreakDurationNotWithinShiftDurationException.class, () -> {
                var shiftBreak = new OffsetDateTimeRange(
                        shift.duration().start(),
                        shift.duration().end().plusHours(1)
                );

                shift.addBreak(shiftBreak);
            });
        }
    }

}