package com.pattern.forge.appointmentBooking.adapter.gatewayAdapters;


import com.pattern.forge.appointmentBooking.usecases.gatway.TimeslotGateway;
import com.pattern.forge.timeslotManagement.timeslotApi.TimeslotApi;

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
