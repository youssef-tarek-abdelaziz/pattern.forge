package com.pattern.forge.patient_management.presentation;

import com.pattern.forge.patient_management.application.PatientApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @GetMapping("/{patientId}")
    public boolean isPatientExists(@PathVariable UUID patientId) {
        return patientApplicationService.isPatientExist(patientId);
    }
}
