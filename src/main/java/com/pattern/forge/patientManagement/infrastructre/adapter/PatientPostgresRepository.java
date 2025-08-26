package com.pattern.forge.patientManagement.infrastructre.adapter;

import com.pattern.forge.patientManagement.domain.Patient;
import com.pattern.forge.patientManagement.infrastructre.persistence.PatientJpaRepository;
import com.pattern.forge.patientManagement.infrastructre.persistence.PatientModel;
import com.pattern.forge.patientManagement.port.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class PatientPostgresRepository implements PatientRepository {

    @Autowired
    private PatientJpaRepository patientJpaRepository;

    @Override
    public void save(Patient patient) {
        PatientModel patientModel = new PatientModel(
                UUID.randomUUID(),
                patient.getName().getName(),
                patient.getEmail().getEmail(),
                patient.getPhone().getPhone(),
                patient.getDateOfBirth()
        );
        patientJpaRepository.save(patientModel);
    }

    @Override
    public Optional<Patient> findByEmail(String email) {
        return patientJpaRepository.findByEmail(email)
                .map((patientModel) -> new Patient(patientModel.getName(),
                        patientModel.getEmail(),
                        patientModel.getPhone(),
                        patientModel.getDateOfBirth()
        ));
    }

    @Override
    public Optional<Patient> findById(UUID id) {
        return patientJpaRepository.findById(id)
                .map((patientModel) -> new Patient(patientModel.getName(),
                        patientModel.getEmail(),
                        patientModel.getPhone(),
                        patientModel.getDateOfBirth()
                ));
    }
}
