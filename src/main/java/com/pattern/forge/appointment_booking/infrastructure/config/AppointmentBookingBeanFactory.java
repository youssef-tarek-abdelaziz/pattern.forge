package com.pattern.forge.appointment_booking.infrastructure.config;

import com.pattern.forge.appointment_booking.infrastructure.gateway.AppointmentPostgresGateway;
import com.pattern.forge.appointment_booking.infrastructure.gateway.PatientApiGateway;
import com.pattern.forge.appointment_booking.infrastructure.gateway.TimeslotApiGateway;
import com.pattern.forge.appointment_booking.usecases.BookAppointmentUseCaseImpl;
import com.pattern.forge.appointment_booking.usecases.gatway.AppointmentGateway;
import com.pattern.forge.appointment_booking.usecases.gatway.PatientGateway;
import com.pattern.forge.appointment_booking.usecases.gatway.TimeslotGateway;
import com.pattern.forge.patient_management.contract.PatientAPI;
import com.pattern.forge.timeslot_management.contract.TimeslotApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class  AppointmentBookingBeanFactory {

    @Bean
    public PatientGateway patientGateway(PatientAPI patientAPI) {
        return new PatientApiGateway(patientAPI);
    }

    @Bean
    public AppointmentGateway appointmentGateway() {
        return new AppointmentPostgresGateway();
    }

    @Bean
    public TimeslotGateway timeslotGateway(TimeslotApi timeslotApi) {
        return new TimeslotApiGateway(timeslotApi);
    }
    @Bean
    public BookAppointmentUseCaseImpl bookAppointmentUseCase(PatientGateway patientGateway, TimeslotGateway timeslotGateway, AppointmentGateway appointmentGateway) {
        return new BookAppointmentUseCaseImpl(patientGateway, timeslotGateway, appointmentGateway);
    }
}
