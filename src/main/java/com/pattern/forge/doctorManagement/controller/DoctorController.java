package com.pattern.forge.doctorManagement.controller;

import com.pattern.forge.doctorManagement.domain.DoctorModel;
import com.pattern.forge.doctorManagement.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public void addDoctor(@RequestBody DoctorApiDto doctorApiDto) {
        doctorService.addDoctor(doctorApiDto.toDoctorModel());
    }
    @PutMapping
    public void updateDoctor(@RequestBody DoctorApiDto doctorApiDto) {
        doctorService.updateDoctor(doctorApiDto.toDoctorModel());
    }
    @GetMapping("/all")
    public ResponseEntity<List<DoctorApiDto>> getAllDoctors() {
        List<DoctorModel> doctorModels = doctorService.getAllDoctors();
        List<DoctorApiDto> doctorApiDtos = doctorModels
                .stream()
                .map(doctorModel -> new DoctorApiDto(doctorModel.getId(), doctorModel.getName(), doctorModel.getEmail(), doctorModel.getSpecialty()))
                .toList();
        return ResponseEntity.ok().body(doctorApiDtos);
    }
}
