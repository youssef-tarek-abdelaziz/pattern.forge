package com.pattern.forge.appointmentBooking.config;

import com.pattern.forge.appointmentBooking.adapter.gatewayAdapters.AppointmentPostgresGateway;
import com.pattern.forge.appointmentBooking.adapter.gatewayAdapters.PatientApiGateway;
import com.pattern.forge.appointmentBooking.adapter.gatewayAdapters.TimeslotApiGateway;
import com.pattern.forge.appointmentBooking.usecases.BookAppointmentUseCaseImpl;
import com.pattern.forge.appointmentBooking.usecases.gatway.AppointmentGateway;
import com.pattern.forge.appointmentBooking.usecases.gatway.PatientGateway;
import com.pattern.forge.appointmentBooking.usecases.gatway.TimeslotGateway;
import com.pattern.forge.patientManagement.contract.PatientAPI;
import com.pattern.forge.timeslotManagement.contract.TimeslotApi;
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
