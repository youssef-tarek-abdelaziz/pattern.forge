package com.pattern.forge.appointmentManagement.core;

import lombok.Getter;

@Getter
public enum AppointmentStatus {
    RESERVED(1),
    IN_PROGRESS(2),
    CANCELLED(2),
    COMPLETED(3);

    private final int order;

    AppointmentStatus(int order) {
        this.order = order;
    }
}

