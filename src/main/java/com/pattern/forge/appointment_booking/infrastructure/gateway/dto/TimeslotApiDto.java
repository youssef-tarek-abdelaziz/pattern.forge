package com.pattern.forge.appointment_booking.infrastructure.gateway.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TimeslotApiDto {
    private LocalDateTime slotDatetime;
    private int duration;
}
