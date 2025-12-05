package com.pattern.forge.doctor_management.controller;

import com.pattern.forge.doctor_management.domain.DoctorModel;
import com.pattern.forge.doctor_management.enums.DoctorSpecialty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorApiDto {
    private UUID id;
    private String name;
    private String email;
    private DoctorSpecialty specialty;
    public DoctorModel toDoctorModel() {
        return new DoctorModel(id, name, email, specialty);
    }
}
