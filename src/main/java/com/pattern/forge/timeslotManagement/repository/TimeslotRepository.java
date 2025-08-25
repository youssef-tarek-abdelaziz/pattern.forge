package com.pattern.forge.timeslotManagement.repository;

import com.pattern.forge.timeslotManagement.domain.TimeslotModel;
import org.apache.commons.text.translate.UnicodeUnescaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TimeslotRepository extends JpaRepository<TimeslotModel, UUID> {
}
