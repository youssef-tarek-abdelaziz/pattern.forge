package com.pattern.forge.patientManagement.port;

import com.pattern.forge.patientManagement.domain.Patient;

import java.util.Optional;
import java.util.UUID;

public interface PatientRepository {

    void save(Patient patient);
    Optional<Patient> findByEmail(String email);
    Optional<Patient> findById(UUID id);
}
