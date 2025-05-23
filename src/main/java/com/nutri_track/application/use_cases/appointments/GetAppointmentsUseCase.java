package com.nutri_track.application.use_cases.appointments;

import com.nutri_track.application.dtos.appointments.GetAppointmentsDto;
import com.nutri_track.domain.entities.Appointment;
import com.nutri_track.domain.repositories.AppointmentRepository;
import com.nutri_track.domain.specifications.appointments.AppointmentIsNotNullSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class GetAppointmentsUseCase {
    private final AppointmentRepository appointmentRepository;

    public GetAppointmentsUseCase(AppointmentRepository appointmentRepository) {
       this.appointmentRepository = appointmentRepository;
    }

    public Page<Appointment> execute(GetAppointmentsDto dto) {
        var spec = new AppointmentIsNotNullSpecification();
        var pageable = PageRequest.of(dto.page(), dto.pageSize());
        return appointmentRepository.findAll(spec, pageable);
    }
}
