package com.pattern.forge.patientManagement.infrastructre.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "patient")
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientModel {
    @Id
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private LocalDateTime dateOfBirth;
}
