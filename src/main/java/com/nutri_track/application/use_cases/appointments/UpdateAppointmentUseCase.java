package com.nutri_track.application.use_cases.appointments;

import com.nutri_track.application.dtos.appointments.UpdateAppointmentDto;
import com.nutri_track.domain.entities.Appointment;
import com.nutri_track.domain.exceptions.appointments.AppointmentNotFoundException;
import com.nutri_track.domain.exceptions.appointments.AppointmentOverlapException;
import com.nutri_track.domain.exceptions.professionals.PatientNotFoundException;
import com.nutri_track.domain.exceptions.professionals.ProfessionalNotFoundException;
import com.nutri_track.domain.repositories.AppointmentRepository;
import com.nutri_track.domain.repositories.PatientRepository;
import com.nutri_track.domain.repositories.ProfessionalRepository;
import com.nutri_track.domain.specifications.appointments.AppointmentHasIdSpecification;
import com.nutri_track.domain.specifications.appointments.AppointmentHasPatientSpecification;
import com.nutri_track.domain.specifications.appointments.AppointmentHasProfessionalSpecification;
import com.nutri_track.domain.specifications.appointments.AppointmentIsScheduledBetweenSpecification;
import com.nutri_track.domain.specifications.patients.PatientHasIdSpecification;
import com.nutri_track.domain.specifications.professionals.ProfessionalHasIdSpecification;
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
        var appointmentSpec = new AppointmentHasIdSpecification(appointmentId);
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

        var patientSpec = new PatientHasIdSpecification(appointment.patientId());
        var patient = patientRepository.findOne(patientSpec).get();

        var professionalSpec = new ProfessionalHasIdSpecification(appointment.professionalId());
        var professional = professionalRepository.findOne(professionalSpec).get();

        var overlappedAppointments = appointmentRepository.findAll(
                new AppointmentIsScheduledBetweenSpecification(newSchedule)
                        .and(new AppointmentHasPatientSpecification(patient))
                        .and(new AppointmentHasProfessionalSpecification(professional))
        );

        if (!overlappedAppointments.isEmpty()) {
            throw new AppointmentOverlapException();
        }

        appointment.schedule(newSchedule);

        appointment = appointmentRepository.save(appointment);
        return appointment;
    }
}