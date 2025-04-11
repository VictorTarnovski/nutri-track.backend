package com.nutri_track.domain.value_objects;

import com.nutri_track.domain.exceptions.OffsetDateTimeRangeEndBeforeStartException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;

class OffsetDateTimeRangeTest {

    @Test
    void should_create_a_offset_date_time_range() {
        // Arrange
        var start = Instant.now().atOffset(ZoneOffset.UTC);
        var end = Instant.now().atOffset(ZoneOffset.UTC).plusHours(1);

        // Act
        var offsetDateTimeRange = new OffsetDateTimeRange(start, end);

        // Assert
        assertEquals(offsetDateTimeRange.start(), start);
        assertEquals(offsetDateTimeRange.end(), end);
    }

    @Test
    void should_not_create_a_offset_date_time_range() {
        // Arrange
        var start = Instant.now().atOffset(ZoneOffset.UTC);
        var end = Instant.now().atOffset(ZoneOffset.UTC).minusHours(1);

        // Assert
        assertThrows(OffsetDateTimeRangeEndBeforeStartException.class, () -> {
            new OffsetDateTimeRange(start, end);
        });
    }

    OffsetDateTimeRange given_a_offset_datetime_range() {
        var start = Instant.now().atOffset(ZoneOffset.UTC);
        var end = Instant.now().atOffset(ZoneOffset.UTC).plusHours(1);
        return new OffsetDateTimeRange(start, end);
    }

    @Nested
    class is_within {

        @Test
        void should_return_true() {
            // Arrange
            var left = given_a_offset_datetime_range();
            var right = new OffsetDateTimeRange(
                    left.start().plusMinutes(15),
                    left.end().minusMinutes(15)
            );

            // Act
            var result = right.isWithin(left);

            // Assert
            assertTrue(result);
        }

        @Test
        void should_return_false_when_start_is_before() {
            // Arrange
            var left = given_a_offset_datetime_range();
            var right = new OffsetDateTimeRange(
                    left.start().minusMinutes(15),
                    left.end().minusMinutes(15)
            );

            // Act
            var result = right.isWithin(left);

            // Assert
            assertFalse(result);
        }

        @Test
        void should_return_false_when_end_is_after() {

            // Arrange
            var left = given_a_offset_datetime_range();
            var right = new OffsetDateTimeRange(
                    left.start().plusMinutes(15),
                    left.end().plusMinutes(15)
            );

            // Act
            var result = right.isWithin(left);

            // Assert
            assertFalse(result);
        }
    }
}