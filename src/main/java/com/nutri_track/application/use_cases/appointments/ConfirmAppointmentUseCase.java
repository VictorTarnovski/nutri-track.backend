package com.nutri_track.application.use_cases.appointments;

import com.nutri_track.domain.exceptions.appointments.AppointmentNotFoundException;
import com.nutri_track.domain.repositories.AppointmentRepository;
import com.nutri_track.domain.specifications.AppointmentHasIdSpecification;
import org.springframework.stereotype.Service;

@Service
public class ConfirmAppointmentUseCase {
    private final AppointmentRepository appointmentRepository;

    public ConfirmAppointmentUseCase(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void execute(long appointmentId) {
        var spec = new AppointmentHasIdSpecification(appointmentId);
        var appointment = appointmentRepository
                .findOne(spec)
                .orElseThrow(() -> new AppointmentNotFoundException(appointmentId));

        appointment.confirm();

        appointmentRepository.save(appointment);
    }
}