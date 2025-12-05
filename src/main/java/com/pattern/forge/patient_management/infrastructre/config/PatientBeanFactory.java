package com.pattern.forge.patient_management.infrastructre.config;

import com.pattern.forge.patient_management.application.PatientApplicationService;
import com.pattern.forge.patient_management.infrastructre.adapter.PatientPostgresRepository;
import com.pattern.forge.patient_management.port.PatientRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatientBeanFactory {

    @Bean
    public PatientRepository patientRepository() {
        return new PatientPostgresRepository();
    }

    @Bean
    public PatientApplicationService patientApplicationService(PatientRepository patientRepository) {
        return new PatientApplicationService(patientRepository);
    }
}
