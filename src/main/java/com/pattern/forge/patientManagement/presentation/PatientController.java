package com.pattern.forge.patientManagement.presentation;

import com.pattern.forge.patientManagement.application.PatientApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientApplicationService patientApplicationService;

    @PostMapping("/register")
    public void registerPatient(@RequestBody PatientApiDto patientApiDto) {
        patientApplicationService.registerPatient(
                patientApiDto.getName(),
                patientApiDto.getEmail(),
                patientApiDto.getDateOfBirth(),
                patientApiDto.getPhone()
        );
    }
}
