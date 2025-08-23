package com.pattern.forge.appointmentManagement.shell;

import com.pattern.forge.appointmentManagement.core.AppointmentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "time_slot")
@Getter
@Setter
public class TimeSlotModel {
    @Id
    private UUID id;
    @OneToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private DoctorModel doctorModel;
    private LocalDateTime slotDatetime;
    private int duration;
}
