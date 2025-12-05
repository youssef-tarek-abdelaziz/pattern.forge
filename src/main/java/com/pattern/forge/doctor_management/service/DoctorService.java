package com.pattern.forge.doctor_management.service;

import com.pattern.forge.doctor_management.domain.DoctorModel;

import java.util.List;

public interface DoctorService {
    void addDoctor(DoctorModel doctorModel);

    void updateDoctor(DoctorModel doctorModel);

    List<DoctorModel> getAllDoctors();
}
