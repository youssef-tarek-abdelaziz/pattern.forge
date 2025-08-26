package com.pattern.forge.appointmentBooking.config;

import com.pattern.forge.appointmentBooking.adapter.gateway.AppointmentPostgresGateway;
import com.pattern.forge.appointmentBooking.adapter.gateway.PatientApiGateway;
import com.pattern.forge.appointmentBooking.adapter.gateway.TimeslotApiGateway;
import com.pattern.forge.appointmentBooking.usecases.BookAppointmentUseCaseImpl;
import com.pattern.forge.appointmentBooking.usecases.gatway.AppointmentGateway;
import com.pattern.forge.appointmentBooking.usecases.gatway.PatientGateway;
import com.pattern.forge.appointmentBooking.usecases.gatway.TimeslotGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class  AppointmentBookingBeanFactory {

    @Bean
    public PatientGateway patientGateway() {
        return new PatientApiGateway();
    }
    @Bean
    public AppointmentGateway appointmentGateway() {
        return new AppointmentPostgresGateway();
    }
    @Bean
    public TimeslotGateway timeslotGateway() {
        return new TimeslotApiGateway();
    }
    @Bean
    public BookAppointmentUseCaseImpl bookAppointmentUseCase(PatientGateway patientGateway, TimeslotGateway timeslotGateway, AppointmentGateway appointmentGateway) {
        return new BookAppointmentUseCaseImpl(patientGateway, timeslotGateway, appointmentGateway);
    }
}
