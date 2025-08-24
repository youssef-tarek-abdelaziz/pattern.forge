package com.pattern.forge.patientManagement.presentation;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class PatientApiDto {
    private String name;
    private String email;
    private String phone;
    private LocalDateTime dateOfBirth;
}
