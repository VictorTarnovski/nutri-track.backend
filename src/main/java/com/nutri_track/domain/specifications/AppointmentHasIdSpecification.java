package com.nutri_track.domain.specifications;

import com.nutri_track.domain.entities.Appointment;

public class AppointmentHasIdSpecification extends HasIdSpecification<Appointment> {
    public AppointmentHasIdSpecification(long appointmentId) {
        super(appointmentId);
    }
}
