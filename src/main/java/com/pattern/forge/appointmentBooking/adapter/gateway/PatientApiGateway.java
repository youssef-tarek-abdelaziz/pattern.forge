package com.pattern.forge.appointmentBooking.adapter.gateway;

import com.pattern.forge.appointmentBooking.usecases.gatway.PatientGateway;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

public class PatientApiGateway implements PatientGateway {
    String url = "http://localhost:8080/api/patient";
    @Override
    public boolean isPatientExist(UUID patientId) {
        RestTemplate restTemplate = new RestTemplate();

        return Boolean.TRUE.equals(restTemplate.getForObject(url + "/" + patientId, Boolean.class));
    }
}
