package com.pattern.forge.appointment_booking.usecases.gatway;

import java.util.UUID;

public interface PatientGateway {
    boolean isPatientExist(UUID patient);
}
