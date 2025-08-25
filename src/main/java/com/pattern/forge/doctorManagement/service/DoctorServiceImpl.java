package com.pattern.forge.doctorManagement.service;

import com.pattern.forge.doctorManagement.domain.DoctorModel;
import com.pattern.forge.doctorManagement.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
public class DoctorServiceImpl implements DoctorService {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    @Autowired
    private DoctorRepository doctorRepository;

    @Transactional
    @Override
    public void addDoctor(DoctorModel doctorModel) {
        if(!EMAIL_PATTERN.matcher(doctorModel.getEmail()).matches()) {
            throw new RuntimeException("Invalid Email");
        }
        doctorModel.setId(UUID.randomUUID());
        doctorRepository.save(doctorModel);
    }

    @Transactional
    @Override
    public void updateDoctor(DoctorModel doctorModel) {
        if (!doctorRepository.existsById(doctorModel.getId())) {
            throw new RuntimeException("Doctor is not exist");
        }
        doctorRepository.save(doctorModel);
    }

    @Transactional(readOnly = true)
    @Override
    public List<DoctorModel> getAllDoctors() {
        return doctorRepository.findAll();
    }
}
