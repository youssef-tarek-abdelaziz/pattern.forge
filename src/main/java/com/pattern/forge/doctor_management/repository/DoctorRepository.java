package com.pattern.forge.doctor_management.repository;

import com.pattern.forge.doctor_management.domain.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorModel, UUID> {
}
