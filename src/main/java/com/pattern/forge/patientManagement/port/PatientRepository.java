package com.pattern.forge.patientManagement.port;

import com.pattern.forge.patientManagement.domain.Patient;

import java.util.Optional;

public interface PatientRepository {

    void save(Patient patient);
    Optional<Patient> findByEmail(String email);
}
