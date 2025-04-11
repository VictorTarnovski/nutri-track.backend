package com.nutri_track.domain.entities;

import com.nutri_track.domain.exceptions.ShiftBreakDurationNotWithinShiftDurationException;
import com.nutri_track.domain.value_objects.OffsetDateTimeRange;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "shifts")
@SequenceGenerator(name = "shifts_seq", sequenceName = "shifts_sequence", allocationSize = 1)
public class Shift extends AbstractAggregateRoot {
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "start", column = @Column(name = "duration_start")),
            @AttributeOverride(name = "end", column = @Column(name = "duration_end")),
    })
    private OffsetDateTimeRange duration;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professional_id", referencedColumnName = "id")
    private Professional professional;

    @OneToMany(mappedBy = "shift", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShiftBreak> breaks = new ArrayList<>();

    protected Shift() {
        super();
    }

    public Shift(OffsetDateTimeRange duration, Professional professional) {
        this.duration = duration;
        this.professional = professional;
    }

    public OffsetDateTimeRange duration() {
        return this.duration;
    }

    public Long professionalId() {
        return this.professional.id();
    }

    public List<ShiftBreak> breaks() {
        return Collections.unmodifiableList(this.breaks);
    }

    public void addBreak(OffsetDateTimeRange duration)
    {
        if (!duration.isWithin(this.duration)) {
            throw new ShiftBreakDurationNotWithinShiftDurationException(duration, this.duration);
        };

        var shiftBreak = new ShiftBreak(duration, this);
        this.breaks.add(shiftBreak);
    }
}
