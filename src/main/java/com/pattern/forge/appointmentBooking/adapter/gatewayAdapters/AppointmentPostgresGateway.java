package com.pattern.forge.appointmentBooking.adapter.gatewayAdapters;

import com.pattern.forge.appointmentBooking.infrastructure.persistence.AppointmentBookingModel;
import com.pattern.forge.appointmentBooking.infrastructure.persistence.AppointmentBookingRepository;
import com.pattern.forge.appointmentBooking.entities.Appointment;
import com.pattern.forge.appointmentBooking.usecases.gatway.AppointmentGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AppointmentPostgresGateway implements AppointmentGateway {

    @Autowired
    private AppointmentBookingRepository appointmentRepository;

    @Override
    public UUID save(Appointment appointment) {
        AppointmentBookingModel appointmentModel = new AppointmentBookingModel();
        appointmentModel.setId(appointment.getId());
        appointmentModel.setAppointmentType(appointment.getType().name());
        appointmentModel.setReservedAt(appointment.getReservedAt());
        appointmentModel.setPatientId(appointment.getPatientId());
        appointmentModel.setSlotId(appointment.getSlotId());
        appointmentModel.setStatus(appointment.getStatus().name());
        appointmentRepository.save(appointmentModel);
        return appointment.getId();
    }
}
