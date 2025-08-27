package com.pattern.forge.appointmentBooking.usecases;

import java.util.UUID;

public interface BookAppointmentUseCase {
    UUID execute(UUID slotId, UUID patientId, String appointmentType);
}
