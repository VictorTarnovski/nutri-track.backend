package com.nutri_track.domain.states;

import com.nutri_track.domain.entities.Appointment;

public interface IAppointmentState {
    String name();
    void confirm(Appointment appointment);
    void cancel(Appointment appointment);
}
