package com.pattern.forge.appointmentManagement.core;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AppointmentRepository {
    List<Appointment> viewAllAppointment(UUID doctorId);
    List<Appointment> viewAllAppointment(UUID doctorId, LocalDateTime to);
    Optional<Appointment> viewAppointment(UUID id);
    void updateAppointmentStatus(Appointment appointment);
}
