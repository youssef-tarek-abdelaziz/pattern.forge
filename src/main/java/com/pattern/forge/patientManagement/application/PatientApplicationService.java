package com.pattern.forge.patientManagement.application;

import com.pattern.forge.patientManagement.domain.Patient;
import com.pattern.forge.patientManagement.port.PatientRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public class PatientApplicationService {

    private final PatientRepository patientRepository;

    public PatientApplicationService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void registerPatient(String name, String email, LocalDateTime dateOfBirth, String phone) {
        Patient patient = new Patient(name, email, phone, dateOfBirth);
        Optional<Patient> patientOptional = patientRepository.findByEmail(email);
        if(patientOptional.isPresent()) {
            throw new RuntimeException("emails is already used");
        }
        patientRepository.save(patient);
    }

    public boolean isPatientExist(UUID patientId) {
        return patientRepository.findById(patientId).isPresent();
    }
}
