package com.nutri_track.domain.entities;

import com.nutri_track.domain.exceptions.AppointmentScheduleInPastException;
import com.nutri_track.domain.states.AppointmentState;
import com.nutri_track.domain.states.ConfirmationPendingAppointmentState;
import com.nutri_track.domain.value_objects.OffsetDateTimeRange;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.ZoneOffset;

@Entity
@Table(name = "appointments")
@SequenceGenerator(name = "appointments_seq", sequenceName = "appointments_sequence", allocationSize = 1)
public class Appointment extends AbstractAggregateRoot {
    //region attributes
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professional_id", referencedColumnName = "id")
    private Professional professional;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "start", column = @Column(name = "scheduled_to_start")),
            @AttributeOverride(name = "end", column = @Column(name = "scheduled_to_end")),
    })
    private OffsetDateTimeRange scheduledTo;

    private String state;

    @Version
    private Integer version;

    //endregion

    //region constructors
    public Appointment() { }

    public Appointment(
            OffsetDateTimeRange scheduledTo,
            Patient patient,
            Professional professional) {
        if (scheduledTo == null) throw new IllegalArgumentException("scheduledTo must not be null");
        schedule(scheduledTo);

        if (patient == null) throw new IllegalArgumentException("patient must not be null");
        this.patient =  patient;

        if (professional == null) throw new IllegalArgumentException("professional must not be null");
        this.professional = professional;

        this.state = new ConfirmationPendingAppointmentState().name();
    }

    //endregion

    //region getters
    public OffsetDateTimeRange scheduledTo() {
        return this.scheduledTo;
    }

    public Long patientId() {
        return this.patient.id();
    }

    public Long professionalId() {
        return this.professional.id();
    }

    public String state() {
        return this.state;
    }
    //endregion

    //region setters
    public void schedule(OffsetDateTimeRange schedule) {
        validateScheduledTo(schedule);
        this.scheduledTo = schedule;
    }

    /**
     * Sets the current state of the Appointment
     * Should only be called from AppointmentState instances
     *
     * @param state The result of AppointmentState.name()
     */
    public void setState(String state) {
        this.state = state;
    }

    public void changePatient (Patient patient) {
        this.patient =  patient;
    }

    public void changeProfessional(Professional professional) {
        this.professional = professional;
    }

    //endregion

    //region methods
    private void validateScheduledTo(OffsetDateTimeRange scheduledTo) {
        var now = Instant.now().atOffset(ZoneOffset.UTC);
        if (scheduledTo.start().isBefore(now)) {
            throw new AppointmentScheduleInPastException();
        }
    }

    public void confirm() {
        AppointmentState.of(this.state).confirm(this);
    }

    public void cancel() {
        AppointmentState.of(this.state).cancel(this);
    }

    //endregion
}
