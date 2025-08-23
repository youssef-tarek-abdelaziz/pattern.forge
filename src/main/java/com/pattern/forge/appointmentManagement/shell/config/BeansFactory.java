package com.pattern.forge.appointmentManagement.shell.config;

import com.pattern.forge.appointmentManagement.core.port.out.AppointmentRepository;
import com.pattern.forge.appointmentManagement.core.port.in.AppointmentService;
import com.pattern.forge.appointmentManagement.core.domain.AppointmentServiceImpl;
import com.pattern.forge.appointmentManagement.shell.adapter.out.persistence.AppointmentPostgresRepo;
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
