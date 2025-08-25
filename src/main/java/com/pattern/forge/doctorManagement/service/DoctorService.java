package com.pattern.forge.doctorManagement.service;

import com.pattern.forge.doctorManagement.domain.DoctorModel;

import java.util.List;

public interface DoctorService {
    void addDoctor(DoctorModel doctorModel);

    void updateDoctor(DoctorModel doctorModel);

    List<DoctorModel> getAllDoctors();
}
