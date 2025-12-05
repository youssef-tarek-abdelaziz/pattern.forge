package com.pattern.forge.appointment_booking.usecases.gatway;

import java.util.UUID;

public interface TimeslotGateway {
    boolean isTimeslotAvailable(UUID slotId);
    void deleteTimeslot(UUID slotId);
}
