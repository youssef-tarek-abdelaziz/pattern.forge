package com.pattern.forge.appointment_management.core.domain.model;

import com.pattern.forge.shared.domain.ValueObject;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public class ReservedAt implements ValueObject {

    private LocalDateTime reservedAt;

    private ReservedAt(LocalDateTime reservedAt) {
        this.reservedAt = reservedAt;
    }
    public static ReservedAt of(LocalDateTime reservedAt) {
        if(reservedAt.isBefore(LocalDateTime.now())) {
            log.error("Can't reserve a slot in Past");
            return null;
        }
        return new ReservedAt(reservedAt);
    }
}
