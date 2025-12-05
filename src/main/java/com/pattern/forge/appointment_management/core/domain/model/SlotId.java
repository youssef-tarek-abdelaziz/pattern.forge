package com.pattern.forge.appointment_management.core.domain.model;

import com.pattern.forge.shared.domain.ValueObject;

import java.util.UUID;

public class SlotId implements ValueObject {

    private UUID slotId;

    private SlotId(UUID slotId) {
        this.slotId = slotId;
    }
    public static SlotId of(UUID slotId) {
        return new SlotId(slotId);
    }
}
