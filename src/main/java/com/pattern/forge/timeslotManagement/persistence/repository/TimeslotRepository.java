package com.pattern.forge.timeslotManagement.persistence.repository;

import com.pattern.forge.timeslotManagement.persistence.domain.TimeslotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TimeslotRepository extends JpaRepository<TimeslotModel, UUID> {
}
