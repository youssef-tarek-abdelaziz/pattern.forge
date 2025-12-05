package com.pattern.forge.patient_management.port;

import com.pattern.forge.patient_management.domain.Patient;

import java.util.Optional;
import java.util.UUID;

public interface PatientRepository {

    void save(Patient patient);
    Optional<Patient> findByEmail(String email);
    Optional<Patient> findById(UUID id);
}
