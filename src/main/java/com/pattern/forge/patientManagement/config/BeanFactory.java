package com.pattern.forge.patientManagement.config;

import com.pattern.forge.patientManagement.application.PatientApplicationService;
import com.pattern.forge.patientManagement.infrastructre.adapter.PatientPostgresRepository;
import com.pattern.forge.patientManagement.port.PatientRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanFactory {

    @Bean
    public PatientRepository patientRepository() {
        return new PatientPostgresRepository();
    }

    @Bean
    public PatientApplicationService patientApplicationService(PatientRepository patientRepository) {
        return new PatientApplicationService(patientRepository);
    }
}
