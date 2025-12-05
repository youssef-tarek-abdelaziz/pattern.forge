package com.pattern.forge.appointment_management.core.domain.model;

import com.pattern.forge.shared.domain.ValueObject;

import java.util.UUID;

public class AppointmentId implements ValueObject {
    private UUID id;

    private AppointmentId(UUID id) {
        this.id = id;
    }

    public static AppointmentId of(UUID id) {
        return new AppointmentId(id);
    }
}
