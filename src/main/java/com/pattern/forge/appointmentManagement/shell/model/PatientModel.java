package com.pattern.forge.appointmentManagement.shell.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "patient")
@Getter
@Setter
public class PatientModel {
    @Id
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private LocalDateTime dateOfBirth;
}
