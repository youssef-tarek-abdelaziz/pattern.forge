package com.pattern.forge.doctor_management.domain;

import com.pattern.forge.doctor_management.enums.DoctorSpecialty;
import com.pattern.forge.timeslot_management.persistence.domain.TimeslotModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity(name = "doctor")
@Table
@Getter
@Setter
@NoArgsConstructor
public class DoctorModel {
    @Id
    private UUID id;
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private DoctorSpecialty specialty;

    @OneToMany(mappedBy = "doctor")
    private List<TimeslotModel> slots;
    public DoctorModel(UUID id, String name, String email, DoctorSpecialty specialty) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.specialty = specialty;
    }
}
