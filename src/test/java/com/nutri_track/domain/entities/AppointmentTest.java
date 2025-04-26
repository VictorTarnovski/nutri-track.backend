package com.nutri_track.domain.entities;

import com.nutri_track.domain.exceptions.appointments.CancelledAppointmentConfirmationException;
import com.nutri_track.domain.states.CancelledAppointmentState;
import com.nutri_track.domain.states.ConfirmationPendingAppointmentState;
import com.nutri_track.domain.states.ScheduledAppointmentState;
import com.nutri_track.domain.value_objects.OffsetDateTimeRange;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {

    @Test
    void should_create_an_appointment() {
        // Arrange
        var patient = new Patient();
        var professional = new Professional();
        var scheduledToStart = Instant.now().atOffset(ZoneOffset.UTC).plusHours(1);
        var scheduledToEnd = Instant.now().atOffset(ZoneOffset.UTC).plusHours(2);
        var scheduledTo = new OffsetDateTimeRange(scheduledToStart, scheduledToEnd);

        // Act
        var appointment = new Appointment(scheduledTo, patient, professional);

        // Assert
        assertEquals(patient.id(), appointment.patientId());
        assertEquals(professional.id(), appointment.professionalId());
        assertEquals(scheduledTo, appointment.scheduledTo());
        assertEquals(appointment.state(), new ConfirmationPendingAppointmentState().name());
    }

    Appointment given_a_appointment() {
        var patient = new Patient();
        var professional = new Professional();
        var scheduledToStart = Instant.now().atOffset(ZoneOffset.UTC).plusHours(1);
        var scheduledToEnd = Instant.now().atOffset(ZoneOffset.UTC).plusHours(2);
        var scheduledTo = new OffsetDateTimeRange(scheduledToStart, scheduledToEnd);
        return new Appointment(scheduledTo, patient, professional);
    }

    @Nested
    class confirm {
        @Test
        void should_confirm_a_confirmation_pending_appointment() {
            // Arrange
            var appointment = given_a_appointment();
            appointment.setState(new ConfirmationPendingAppointmentState().name());

            // Assert
            assertDoesNotThrow(appointment::confirm);
        }

        @Test
        void should_confirm_a_scheduled_appointment() {
            // Arrange
            var appointment = given_a_appointment();
            appointment.setState(new ScheduledAppointmentState().name());

            // Assert
            assertDoesNotThrow(appointment::confirm);
        }

        @Test
        void should_not_confirm_a_cancelled_appointment() {
            // Arrange
            var appointment = given_a_appointment();
            appointment.setState(new CancelledAppointmentState().name());

            // Assert
            assertThrows(CancelledAppointmentConfirmationException.class, appointment::confirm);
        }
    }

    @Nested
    class cancel {
        @Test
        void should_cancel_a_confirmation_pending_appointment() {
            // Arrange
            var appointment = given_a_appointment();

            // Assert
            assertDoesNotThrow(appointment::cancel);
        }

        @Test
        void should_cancel_a_scheduled_appointment() {
            // Arrange
            var appointment = given_a_appointment();
            appointment.confirm();

            // Assert
            assertDoesNotThrow(appointment::cancel);
        }

        @Test
        void should_cancel_a_cancelled_appointment() {
            // Arrange
            var appointment = given_a_appointment();
            appointment.cancel();

            // Assert
            assertDoesNotThrow(appointment::cancel);
        }
    }
}
