package com.pattern.forge.appointmentManagement.shell.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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
