package com.pattern.forge.appointmentBooking.usecases.gatway;

import com.pattern.forge.appointmentBooking.entities.Appointment;

public interface AppointmentGateway {
    void save(Appointment appointment);
}
