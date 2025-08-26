package com.pattern.forge.appointmentBooking.usecases;

import com.pattern.forge.appointmentBooking.entities.Appointment;
import com.pattern.forge.appointmentBooking.entities.AppointmentType;
import com.pattern.forge.appointmentBooking.usecases.gatway.AppointmentGateway;
import com.pattern.forge.appointmentBooking.usecases.gatway.PatientGateway;
import com.pattern.forge.appointmentBooking.usecases.gatway.TimeslotGateway;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class BookAppointmentUseCaseImpl implements BookAppointmentUseCase {

    private PatientGateway patientGateway;
    private TimeslotGateway timeslotGateway;
    private AppointmentGateway appointmentGateway;

    public BookAppointmentUseCaseImpl(PatientGateway patientGateway, TimeslotGateway timeslotGateway, AppointmentGateway appointmentGateway) {
        this.patientGateway = patientGateway;
        this.timeslotGateway = timeslotGateway;
        this.appointmentGateway = appointmentGateway;
    }

    @Transactional
    @Override
    public void execute(UUID timeslotId, UUID patientId, String appointmentType) {
        boolean isPatientExist = patientGateway.isPatientExist(patientId);
        if(!isPatientExist) {
            throw new IllegalArgumentException("No Patient exists with id: " + patientId);
        }
        boolean isTimeslotAvailable = timeslotGateway.isTimeslotAvailable(timeslotId);
        if(!isTimeslotAvailable) {
            throw new IllegalArgumentException("No timeslot available");
        }
        Appointment appointment = new Appointment(timeslotId, patientId, AppointmentType.valueOf(appointmentType));
        timeslotGateway.deleteTimeslot(timeslotId);
        appointmentGateway.save(appointment);
    }
}
