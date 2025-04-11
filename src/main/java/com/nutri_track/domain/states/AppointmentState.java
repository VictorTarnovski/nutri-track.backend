package com.nutri_track.domain.states;

public abstract class AppointmentState {
    public static IAppointmentState of(String name) {
        return switch (name) {
            case "CONFIRMATION_PENDING" -> new ConfirmationPendingAppointmentState();
            case "SCHEDULED" -> new ScheduledAppointmentState();
            case "CANCELLED" -> new CancelledAppointmentState();
            default -> throw new IllegalArgumentException("No AppointmentState for name: " + name);
        };
    }
}
