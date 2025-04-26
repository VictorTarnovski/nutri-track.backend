package com.nutri_track.application.dtos;

import com.nutri_track.domain.entities.Appointment;

import java.time.OffsetDateTime;

public class AppointmentDto extends EntityDto {
    public Long patientId;
    public Long professionalId;
    public String state;
    public OffsetDateTime scheduledToStart;
    public OffsetDateTime scheduledToEnd;

    public AppointmentDto(Appointment appointment) {
        super(appointment.id());
        this.patientId = appointment.patientId();
        this.professionalId = appointment.professionalId();
        this.state = appointment.state();
        this.scheduledToStart = appointment.scheduledTo().start();
        this.scheduledToEnd = appointment.scheduledTo().end();
    }

}