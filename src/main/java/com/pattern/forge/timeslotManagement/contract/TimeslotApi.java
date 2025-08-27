package com.pattern.forge.timeslotManagement.contract;

import java.util.UUID;

public interface TimeslotApi {
    boolean isTimeslotAvailable(UUID slotId);
    void deleteTimeslot(UUID slotId);
}
