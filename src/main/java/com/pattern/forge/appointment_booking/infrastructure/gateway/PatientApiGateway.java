package com.pattern.forge.appointment_booking.infrastructure.gateway;

import com.pattern.forge.appointment_booking.usecases.gatway.PatientGateway;
import com.pattern.forge.patient_management.contract.PatientAPI;

import java.util.UUID;

public class PatientApiGateway implements PatientGateway {

    private final PatientAPI patientAPI;
    public PatientApiGateway(PatientAPI patientAPI) {
        this.patientAPI = patientAPI;
    }

    @Override
    public boolean isPatientExist(UUID patientId) {
        return patientAPI.isPatientExist(patientId);
    }
}
