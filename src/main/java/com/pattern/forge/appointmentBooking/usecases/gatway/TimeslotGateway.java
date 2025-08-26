package com.pattern.forge.appointmentBooking.usecases.gatway;

import java.util.UUID;

public interface TimeslotGateway {
    boolean isTimeslotAvailable(UUID slotId);
    void deleteTimeslot(UUID slotId);
}
