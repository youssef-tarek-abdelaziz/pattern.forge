package com.pattern.forge.appointment_booking.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AppointmentBookingRepository extends JpaRepository<AppointmentBookingModel, UUID> {

}
