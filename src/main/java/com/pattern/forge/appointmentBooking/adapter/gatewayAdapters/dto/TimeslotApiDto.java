package com.pattern.forge.appointmentBooking.adapter.gatewayAdapters.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TimeslotApiDto {
    private LocalDateTime slotDatetime;
    private int duration;
}
