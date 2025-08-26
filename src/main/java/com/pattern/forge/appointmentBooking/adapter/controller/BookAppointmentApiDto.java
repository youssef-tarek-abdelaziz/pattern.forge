package com.pattern.forge.appointmentBooking.adapter.controller;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class BookAppointmentApiDto {
    private UUID slotId;
    private UUID patientId;
    private String appointmentType;
}
