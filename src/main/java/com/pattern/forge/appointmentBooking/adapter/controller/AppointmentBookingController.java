package com.pattern.forge.appointmentBooking.adapter.controller;

import com.pattern.forge.appointmentBooking.usecases.BookAppointmentUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appointment/booking")
public class AppointmentBookingController {

    @Autowired
    private BookAppointmentUseCaseImpl bookAppointmentUseCaseImpl;

    @PostMapping
    public void bookAppointment(@RequestBody BookAppointmentApiDto bookAppointmentApiDto) {
        bookAppointmentUseCaseImpl.execute(
                bookAppointmentApiDto.getSlotId(),
                bookAppointmentApiDto.getPatientId(),
                bookAppointmentApiDto.getAppointmentType()
        );
    }
}
