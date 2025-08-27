package com.pattern.forge.patientManagement.contract;

import java.util.UUID;

public interface PatientAPI {
    boolean isPatientExist(UUID patientId);
}
