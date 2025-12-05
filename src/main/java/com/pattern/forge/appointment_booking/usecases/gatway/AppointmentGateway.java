package com.pattern.forge.appointment_booking.usecases.gatway;

import com.pattern.forge.appointment_booking.entities.Appointment;

import java.util.UUID;

public interface AppointmentGateway {
    UUID save(Appointment appointment);
}
