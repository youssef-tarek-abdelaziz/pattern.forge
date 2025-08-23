package com.pattern.forge.appointmentManagement.shell;

import com.pattern.forge.appointmentManagement.core.AppointmentRepository;
import com.pattern.forge.appointmentManagement.core.AppointmentService;
import com.pattern.forge.appointmentManagement.core.AppointmentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansFactory {

    @Bean
    public AppointmentRepository appointmentRepository() {
        return new AppointmentPostgresRepo();
    }
    @Bean
    public AppointmentService appointmentService(AppointmentRepository appointmentRepository) {
        return new AppointmentServiceImpl(appointmentRepository);
    }
}
