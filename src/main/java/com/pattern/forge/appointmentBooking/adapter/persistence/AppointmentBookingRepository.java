package com.pattern.forge.appointmentBooking.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AppointmentBookingRepository extends JpaRepository<AppointmentBookingModel, UUID> {

}
