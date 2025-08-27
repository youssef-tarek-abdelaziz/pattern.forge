package com.pattern.forge.appointmentBooking.usecases;

import java.util.UUID;

public interface BookAppointmentUseCase {
    void execute(UUID slotId, UUID patientId, String appointmentType);
}
