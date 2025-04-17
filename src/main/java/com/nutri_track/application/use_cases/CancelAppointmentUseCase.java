package com.nutri_track.application.use_cases;

import com.nutri_track.domain.exceptions.AppointmentNotFoundException;
import com.nutri_track.domain.repositories.AppointmentRepository;
import com.nutri_track.domain.specifications.AppointmentHasIdSpecification;
import org.springframework.stereotype.Service;

@Service
public class CancelAppointmentUseCase {
    private final AppointmentRepository appointmentRepository;

    public CancelAppointmentUseCase(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void execute(long appointmentId) {
        var spec = new AppointmentHasIdSpecification(appointmentId);
        var appointment = appointmentRepository
                .findOne(spec)
                .orElseThrow(() -> new AppointmentNotFoundException(appointmentId));

        appointment.cancel();

        appointmentRepository.save(appointment);
    }
}