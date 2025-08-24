package com.pattern.forge.patientManagement.infrastructre.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PatientJpaRepository extends JpaRepository<PatientModel, UUID> {
    Optional<PatientModel> findByEmail(String email);
}
