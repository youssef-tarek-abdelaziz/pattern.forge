package com.pattern.forge.patientManagement.contract;

import com.pattern.forge.patientManagement.application.PatientApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PatientApiImpl implements PatientAPI {

    @Autowired
    public PatientApplicationService patientApplicationService;

    @Override
    public boolean isPatientExist(UUID patientId) {
        return patientApplicationService.isPatientExist(patientId);
    }
}
