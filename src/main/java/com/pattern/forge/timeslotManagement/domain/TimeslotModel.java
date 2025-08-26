package com.pattern.forge.timeslotManagement.domain;

import com.pattern.forge.doctorManagement.domain.DoctorModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "time_slot")
@Table
@Getter
@Setter
@NoArgsConstructor
public class TimeslotModel {
    @Id
    private UUID id;
    private LocalDateTime slotDatetime;
    private int duration;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorModel doctor;

    @Enumerated(EnumType.STRING)
    private Status status;

    public TimeslotModel(LocalDateTime slotDatetime, int duration) {
        this.slotDatetime = slotDatetime;
        this.duration = duration;
    }
    public enum Status {
        OPEN,
        DELETED
    }
}
