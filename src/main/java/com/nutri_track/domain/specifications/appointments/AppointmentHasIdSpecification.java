package com.nutri_track.domain.specifications.appointments;

import com.nutri_track.domain.entities.Appointment;
import com.nutri_track.domain.specifications.HasIdSpecification;

public class AppointmentHasIdSpecification extends HasIdSpecification<Appointment> {
    public AppointmentHasIdSpecification(long appointmentId) {
        super(appointmentId);
    }
}
