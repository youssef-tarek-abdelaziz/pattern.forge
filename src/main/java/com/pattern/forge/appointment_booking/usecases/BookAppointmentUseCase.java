package com.pattern.forge.appointment_booking.usecases;

import java.util.UUID;

public interface BookAppointmentUseCase {
    UUID execute(UUID slotId, UUID patientId, String appointmentType);
}
