package com.nutri_track.domain.entities;

import com.nutri_track.domain.value_objects.OffsetDateTimeRange;
import jakarta.persistence.*;

@Entity
@Table(name = "shift_breaks")
@SequenceGenerator(name = "shift_breaks_seq", sequenceName = "shift_breaks_sequence", allocationSize = 1)
public class ShiftBreak extends AbstractEntity {
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "start", column = @Column(name = "duration_start")),
            @AttributeOverride(name = "end", column = @Column(name = "duration_end")),
    })
    private OffsetDateTimeRange duration;

    @ManyToOne
    @JoinColumn(name = "shift_id", nullable = false, updatable = false)
    protected Shift shift;

    protected ShiftBreak() {
        super();
    }

    public ShiftBreak(OffsetDateTimeRange duration, Shift shift) {
        this.duration = duration;
        this.shift = shift;
    }

    public OffsetDateTimeRange duration() {
        return this.duration;
    }
}
