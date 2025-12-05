package com.pattern.forge.appointment_booking.infrastructure.gateway;


import com.pattern.forge.appointment_booking.usecases.gatway.TimeslotGateway;
import com.pattern.forge.timeslot_management.contract.TimeslotApi;

import java.util.UUID;

public class TimeslotApiGateway implements TimeslotGateway {

    private TimeslotApi timeslotApi;

    public TimeslotApiGateway(TimeslotApi timeslotApi) {
        this.timeslotApi = timeslotApi;
    }

    @Override
    public boolean isTimeslotAvailable(UUID slotId) {
        return timeslotApi.isTimeslotAvailable(slotId);
    }

    @Override
    public void deleteTimeslot(UUID slotId) {
        timeslotApi.deleteTimeslot(slotId);
    }
}
