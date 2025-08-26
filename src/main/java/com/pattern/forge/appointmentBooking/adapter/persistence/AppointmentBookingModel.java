package com.pattern.forge.appointmentBooking.adapter.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "appointment")
@Getter
@Setter
public class AppointmentBookingModel {
    @Id
    private UUID id;
    @Column(name = "slot_id", updatable = false)
    private UUID slotId;
    @Column(name = "patient_id", updatable = false)
    private UUID patientId;
    private String appointmentType;
    private String status;
    private LocalDateTime reservedAt;
}
