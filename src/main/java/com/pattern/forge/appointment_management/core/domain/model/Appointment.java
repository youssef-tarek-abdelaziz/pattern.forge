package com.pattern.forge.appointment_management.core.domain.model;

import com.pattern.forge.appointment_management.core.domain.AppointmentStatus;
import com.pattern.forge.appointment_management.core.domain.AppointmentType;
import com.pattern.forge.shared.domain.AggregateRoot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Getter
public class Appointment extends AggregateRoot<AppointmentId> {
    private SlotId slotId;
    private PatientId patientId;
    private ReservedAt reservedAt;
    private AppointmentStatus status;
    private AppointmentType type;


    private Appointment(UUID slotId, UUID patientId, AppointmentType type) {
        super(AppointmentId.of(UUID.randomUUID()));
        this.slotId = SlotId.of(slotId);
        this.patientId = PatientId.of(patientId);
        this.reservedAt = ReservedAt.of(LocalDateTime.now());
        this.status = AppointmentStatus.RESERVED;
        this.type = type;
    }

    private Appointment(UUID id, UUID slotId, UUID patientId, LocalDateTime reservedAt, AppointmentStatus status, AppointmentType type) {
        super(AppointmentId.of(id));
        this.slotId = SlotId.of(slotId);
        this.patientId = PatientId.of(patientId);
        this.reservedAt = ReservedAt.of(reservedAt);
        this.status = status;
        this.type = type;
    }

    public static Appointment of(UUID slotId, UUID patientId, AppointmentType type) {
        return new Appointment(slotId, patientId, type);
    }
    public static Appointment of(UUID id, UUID slotId, UUID patientId, LocalDateTime reservedAt, AppointmentStatus status, AppointmentType type) {
        return new Appointment(id, slotId, patientId, reservedAt, status, type);
    }

    public void changeAppointmentStatus(AppointmentStatus targetStatus) {
        if(Math.abs(targetStatus.getOrder() - this.status.getOrder()) != 1 || this.status.equals(AppointmentStatus.CANCELLED)) {
            log.error("Not Allowed to change the status");
            return;
        }
        this.status = targetStatus;
    }
}
