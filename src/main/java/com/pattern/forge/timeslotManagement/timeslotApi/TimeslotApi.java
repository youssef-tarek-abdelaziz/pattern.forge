package com.pattern.forge.timeslotManagement.timeslotApi;

import org.springframework.stereotype.Component;

import java.util.UUID;

public interface TimeslotApi {
    boolean isTimeslotAvailable(UUID slotId);
    void deleteTimeslot(UUID slotId);
}
