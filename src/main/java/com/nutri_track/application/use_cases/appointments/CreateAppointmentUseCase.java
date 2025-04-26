package com.nutri_track.application.use_cases.appointments;

import com.nutri_track.application.use_cases.patients.GetPatientUseCase;
import com.nutri_track.application.use_cases.professionals.GetProfessionalUseCase;
import com.nutri_track.domain.entities.Appointment;
import com.nutri_track.domain.exceptions.appointments.AppointmentOverlapException;
import com.nutri_track.domain.repositories.AppointmentRepository;
import com.nutri_track.domain.specifications.appointments.AppointmentHasIdSpecification;
import com.nutri_track.domain.specifications.appointments.AppointmentHasPatientSpecification;
import com.nutri_track.domain.specifications.appointments.AppointmentHasProfessionalSpecification;
import com.nutri_track.domain.specifications.appointments.AppointmentIsScheduledBetweenSpecification;
import com.nutri_track.domain.value_objects.OffsetDateTimeRange;
import com.nutri_track.application.dtos.appointments.CreateAppointmentDto;
import org.springframework.stereotype.Service;

@Service
public class CreateAppointmentUseCase {
    private final GetPatientUseCase getPatientUseCase;
    private final GetProfessionalUseCase getProfessionalUseCase;
    private final AppointmentRepository appointmentRepository;

    public CreateAppointmentUseCase(
            GetPatientUseCase getPatientUseCase,
            GetProfessionalUseCase getProfessionalUseCase,
            AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
        this.getPatientUseCase = getPatientUseCase;
        this.getProfessionalUseCase = getProfessionalUseCase;
    }

    public Appointment execute(CreateAppointmentDto dto) {
        var patient = getPatientUseCase.execute(dto.patientId());

        var professional = getProfessionalUseCase.execute(dto.professionalId());

        var schedule = new OffsetDateTimeRange(dto.scheduledToStart(), dto.scheduledToEnd());

        var overlappedAppointments = appointmentRepository.findAll(
                new AppointmentIsScheduledBetweenSpecification(schedule)
                        .and(new AppointmentHasPatientSpecification(patient))
                        .and(new AppointmentHasProfessionalSpecification(professional))
        );

        if (!overlappedAppointments.isEmpty()) {
            throw new AppointmentOverlapException();
        }

        var appointment = new Appointment(
                schedule,
                patient,
                professional);
        /*
        TODO: If user is the professional that is creating the appointment
         confirm appointment right away
         CODE => appointment.confirm();
        */

        appointmentRepository.save(appointment);
        var spec = new AppointmentHasIdSpecification(appointment.id());
        return appointmentRepository.findOne(spec).get();
    }
}