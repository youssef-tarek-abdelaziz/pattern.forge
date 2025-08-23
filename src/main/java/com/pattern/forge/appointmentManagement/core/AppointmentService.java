package com.pattern.forge.appointmentManagement.core;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface AppointmentService {
    List<Appointment> viewAllAppointments(UUID doctorId, LocalDateTime to);

    void changeAppointmentStatus(UUID doctorId, UUID appointmentId, AppointmentStatus status);
}
