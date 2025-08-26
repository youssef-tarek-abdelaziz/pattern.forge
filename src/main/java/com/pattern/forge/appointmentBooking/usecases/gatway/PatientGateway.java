package com.pattern.forge.appointmentBooking.usecases.gatway;

import java.util.UUID;

public interface PatientGateway {
    boolean isPatientExist(UUID patient);
}
