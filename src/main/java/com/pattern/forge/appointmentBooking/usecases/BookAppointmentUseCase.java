package com.pattern.forge.appointmentBooking.usecases;

import java.util.UUID;

public interface BookAppointmentUseCase {
    void execute(UUID patientId, UUID slotId, String appointmentType);
}
