package com.pattern.forge.appointmentManagement.shell.repository;

import com.pattern.forge.appointmentManagement.core.domain.AppointmentStatus;
import com.pattern.forge.appointmentManagement.shell.model.AppointmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface AppointmentJpaRepo extends JpaRepository<AppointmentModel, UUID> {

    List<AppointmentModel> findAllByDoctorModelIdAndReservedAtBefore(UUID doctorId, LocalDateTime reservedAt);
    List<AppointmentModel> findAllByDoctorModelId(UUID doctorId);

    @Modifying
    @Query("UPDATE AppointmentModel SET status = :status where id = :id")
    void updateAppointmentStatus(@Param("id") UUID id, @Param("status") AppointmentStatus status);
}
