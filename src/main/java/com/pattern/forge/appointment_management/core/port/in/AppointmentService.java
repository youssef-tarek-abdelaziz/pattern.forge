package com.pattern.forge.appointment_management.core.port.in;

import com.pattern.forge.appointment_management.core.domain.model.Appointment;
import com.pattern.forge.appointment_management.core.domain.AppointmentStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface AppointmentService {
    List<Appointment> viewAllAppointments(UUID doctorId, LocalDateTime to);

    void changeAppointmentStatus(UUID appointmentId, AppointmentStatus status);
}
