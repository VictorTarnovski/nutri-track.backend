package com.nutri_track.application.use_cases.appointments;

import com.nutri_track.application.dtos.appointments.UpdateAppointmentDto;
import com.nutri_track.domain.entities.Appointment;
import com.nutri_track.domain.exceptions.appointments.AppointmentNotFoundException;
import com.nutri_track.domain.exceptions.professionals.PatientNotFoundException;
import com.nutri_track.domain.exceptions.professionals.ProfessionalNotFoundException;
import com.nutri_track.domain.repositories.AppointmentRepository;
import com.nutri_track.domain.repositories.PatientRepository;
import com.nutri_track.domain.repositories.ProfessionalRepository;
import com.nutri_track.domain.specifications.AppointmentHasIdSpecification;
import com.nutri_track.domain.specifications.PatientHasIdSpecification;
import com.nutri_track.domain.specifications.ProfessionalHasIdSpecification;
import com.nutri_track.domain.value_objects.OffsetDateTimeRange;
import org.springframework.stereotype.Service;

@Service
public class UpdateAppointmentUseCase {
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final ProfessionalRepository professionalRepository;

    public UpdateAppointmentUseCase(
            AppointmentRepository appointmentRepository,
            PatientRepository patientRepository,
            ProfessionalRepository professionalRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.professionalRepository = professionalRepository;
    }

    public Appointment execute(long appointmentId, UpdateAppointmentDto dto) {
        var appointmentSpec= new AppointmentHasIdSpecification(appointmentId);
        var appointment = appointmentRepository
                .findOne(appointmentSpec)
                .orElseThrow(() -> new AppointmentNotFoundException(appointmentId));

        if (dto.patientId() != null) {
            var patientSpec = new PatientHasIdSpecification(dto.patientId());
            var patient = patientRepository
                    .findOne(patientSpec)
                    .orElseThrow(() -> new PatientNotFoundException(dto.patientId()));
            appointment.changePatient(patient);
        }

        if (dto.professionalId() != null) {
            var professionalSpec = new ProfessionalHasIdSpecification(dto.professionalId());
            var professional = professionalRepository
                    .findOne(professionalSpec)
                    .orElseThrow(() -> new ProfessionalNotFoundException(dto.professionalId()));
            appointment.changeProfessional(professional);
        }

        var newSchedule = appointment.scheduledTo();

        if (dto.scheduledToStart() != null) {
            newSchedule = new OffsetDateTimeRange(dto.scheduledToStart(), appointment.scheduledTo().end());
        }

        if (dto.scheduledToEnd() != null) {
            newSchedule = new OffsetDateTimeRange(appointment.scheduledTo().start(), dto.scheduledToEnd());
        }

        appointment.schedule(newSchedule);

        appointment = appointmentRepository.save(appointment);
        return appointment;
    }
}