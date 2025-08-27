package com.pattern.forge.timeslotManagement.contract;

import com.pattern.forge.timeslotManagement.service.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TimeslotApiImpl implements TimeslotApi {

    @Autowired
    private TimeslotService timeslotService;

    @Override
    public boolean isTimeslotAvailable(UUID slotId) {
        return timeslotService.existsById(slotId);
    }

    @Override
    public void deleteTimeslot(UUID slotId) {
        timeslotService.deleteTimeslot(slotId);
    }
}
