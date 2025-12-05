package com.pattern.forge.patient_management.contract;

import java.util.UUID;

public interface PatientAPI {
    boolean isPatientExist(UUID patientId);
}
