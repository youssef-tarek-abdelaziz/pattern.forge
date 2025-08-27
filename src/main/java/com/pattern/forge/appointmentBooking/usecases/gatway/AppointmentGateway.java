package com.pattern.forge.appointmentBooking.usecases.gatway;

import com.pattern.forge.appointmentBooking.entities.Appointment;

import java.util.UUID;

public interface AppointmentGateway {
    UUID save(Appointment appointment);
}
