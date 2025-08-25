package com.pattern.forge.doctorManagement.repository;

import com.pattern.forge.doctorManagement.domain.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorModel, UUID> {
}
