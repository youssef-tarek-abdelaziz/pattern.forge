package com.pattern.forge.appointmentManagement.shell.model;

import com.pattern.forge.appointmentManagement.core.domain.AppointmentStatus;
import com.pattern.forge.appointmentManagement.core.domain.AppointmentType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "appointment")
@Getter
@Setter
public class AppointmentModel {
    @Id
    private UUID id;

    @OneToOne
    @JoinColumn(name = "slot_id", referencedColumnName = "id")
    private TimeSlotModel timeSlotModel;

    @OneToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private PatientModel patientModel;

    @OneToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private DoctorModel doctorModel;

    @Enumerated(EnumType.STRING)
    private AppointmentType appointmentType;
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;
    private LocalDateTime reservedAt;
}
