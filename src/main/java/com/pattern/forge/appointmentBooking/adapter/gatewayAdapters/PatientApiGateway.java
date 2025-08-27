package com.pattern.forge.appointmentBooking.adapter.gatewayAdapters;

import com.pattern.forge.appointmentBooking.usecases.gatway.PatientGateway;
import com.pattern.forge.patientManagement.contract.PatientAPI;

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
