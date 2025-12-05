package com.pattern.forge.timeslot_management.contract;

import java.util.UUID;

public interface TimeslotApi {
    boolean isTimeslotAvailable(UUID slotId);
    void deleteTimeslot(UUID slotId);
}
