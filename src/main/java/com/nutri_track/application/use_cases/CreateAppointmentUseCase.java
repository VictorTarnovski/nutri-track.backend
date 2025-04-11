package com.nutri_track.application.use_cases;

import com.nutri_track.domain.entities.Appointment;
import com.nutri_track.domain.exceptions.PatientNotFoundException;
import com.nutri_track.domain.exceptions.ProfessionalNotFoundException;
import com.nutri_track.domain.repositories.AppointmentRepository;
import com.nutri_track.domain.repositories.PatientRepository;
import com.nutri_track.domain.repositories.ProfessionalRepository;
import com.nutri_track.domain.specifications.AppointmentHasIdSpecification;
import com.nutri_track.domain.specifications.PatientHasIdSpecification;
import com.nutri_track.domain.specifications.ProfessionalHasIdSpecification;
import com.nutri_track.domain.value_objects.OffsetDateTimeRange;
import com.nutri_track.domain.dtos.CreateAppointmentDto;
import org.springframework.stereotype.Component;

@Component
public class CreateAppointmentUseCase {
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final ProfessionalRepository professionalRepository;

    public CreateAppointmentUseCase(
            AppointmentRepository appointmentRepository,
            PatientRepository patientRepository,
            ProfessionalRepository professionalRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.professionalRepository = professionalRepository;
    }

    public Appointment execute(CreateAppointmentDto dto) {
        var patientSpec = new PatientHasIdSpecification(dto.patientId());
        var patient = patientRepository
                .findOne(patientSpec)
                .orElseThrow(() -> new PatientNotFoundException(dto.patientId()));

        var professionalSpec = new ProfessionalHasIdSpecification(dto.professionalId());
        var professional = professionalRepository
                .findOne(professionalSpec)
                .orElseThrow(() -> new ProfessionalNotFoundException(dto.professionalId()));

        var appointment = new Appointment(
                new OffsetDateTimeRange(dto.scheduledToStart(), dto.scheduledToEnd()),
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