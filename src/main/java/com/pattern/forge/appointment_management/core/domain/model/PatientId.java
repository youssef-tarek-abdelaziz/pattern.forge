package com.pattern.forge.appointment_management.core.domain.model;

import com.pattern.forge.shared.domain.ValueObject;

import java.util.UUID;

public class PatientId implements ValueObject {

    private final UUID patientId;

    private PatientId(UUID patientId) {
        this.patientId = patientId;
    }
    public static PatientId of(UUID id) {
        return new PatientId(id);
    }
}
