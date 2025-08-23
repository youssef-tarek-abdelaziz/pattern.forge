package com.pattern.forge.appointmentManagement.shell;

import com.pattern.forge.appointmentManagement.core.AppointmentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "doctor")
@Getter
@Setter
public class DoctorModel {
    @Id
    private UUID id;
    private String name;
    private String email;
    private String specialty;
}
