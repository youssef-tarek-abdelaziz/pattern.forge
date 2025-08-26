package com.pattern.forge.appointmentBooking.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Getter
@AllArgsConstructor
public class Appointment {
    private UUID id;
    private UUID slotId;
    private UUID patientId;
    private LocalDateTime reservedAt;
    private AppointmentStatus status;
    private AppointmentType type;

    public Appointment(UUID slotId, UUID patientId, AppointmentType type) {
        this.id = UUID.randomUUID();
        this.slotId = slotId;
        this.patientId = patientId;
        this.reservedAt = LocalDateTime.now();
        this.status = AppointmentStatus.RESERVED;
        this.type = type;
    }
}
