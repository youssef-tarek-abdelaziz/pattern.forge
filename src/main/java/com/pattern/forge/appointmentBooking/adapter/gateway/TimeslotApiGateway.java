package com.pattern.forge.appointmentBooking.adapter.gateway;


import com.pattern.forge.appointmentBooking.usecases.gatway.TimeslotGateway;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

public class TimeslotApiGateway implements TimeslotGateway {
    String url = "http://localhost:8080/api/timeslot";

    @Override
    public boolean isTimeslotAvailable(UUID slotId) {
        RestTemplate restTemplate = new RestTemplate();
        return Boolean.TRUE.equals(restTemplate.getForObject(url + "/" + slotId, Boolean.class));
    }

    @Override
    public void deleteTimeslot(UUID slotId) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url + "/" + slotId);
    }
}
