package com.nutri_track.domain.value_objects;

import com.nutri_track.domain.exceptions.OffsetDateTimeRangeEndBeforeStartException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.OffsetDateTime;
import java.util.Objects;

@Embeddable
public class OffsetDateTimeRange implements Comparable<OffsetDateTimeRange> {
    @Column(name = "start", nullable = false)
    private OffsetDateTime start;
    @Column(name = "end", nullable = false)
    private OffsetDateTime end;

    protected OffsetDateTimeRange() { }

    public OffsetDateTimeRange(OffsetDateTime start, OffsetDateTime end) {
        if (start == null) throw new IllegalArgumentException("start must not be null");
        if (end == null) throw new IllegalArgumentException("end must not be null");

        if (end.isBefore(start)) {
            throw new OffsetDateTimeRangeEndBeforeStartException(start, end);
        }
        this.start = start;
        this.end = end;
    }

    public OffsetDateTime start() {
        return start;
    }

    public OffsetDateTime end() {
        return end;
    }

    public boolean isWithin(OffsetDateTimeRange other) {
        if (this.start.isBefore(other.start())) {
            return false;
        }

        if (this.end.isAfter(other.end())) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(OffsetDateTimeRange o) {
        return this.start().compareTo(o.start()) + this.end().compareTo(o.end());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OffsetDateTimeRange period = (OffsetDateTimeRange) o;
        return this.start.equals(period.start()) && this.end.equals(period.end());
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return "OffsetDateTimeRange{ start: " + this.start + ", end: " + this.end + " }";
    }
}
