package com.pattern.forge.timeslotManagement.service;

import com.pattern.forge.doctorManagement.domain.DoctorModel;
import com.pattern.forge.doctorManagement.repository.DoctorRepository;
import com.pattern.forge.timeslotManagement.persistence.domain.TimeslotModel;
import com.pattern.forge.timeslotManagement.persistence.repository.TimeslotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TimeslotServiceImpl implements TimeslotService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private TimeslotRepository timeslotRepository;

    @Transactional
    @Override
    public void assignTimeslotsToDoctor(UUID doctorId, List<TimeslotModel> timeslotModels) {
        Optional<DoctorModel> doctorModel = doctorRepository.findById(doctorId);
        if(doctorModel.isEmpty()) {
            throw new RuntimeException("doctor is not exist");
        }
        timeslotModels.forEach(slot -> {
            slot.setDoctor(doctorModel.get());
            slot.setId(UUID.randomUUID());
            slot.setStatus(TimeslotModel.Status.OPEN);
        });
        timeslotRepository.saveAll(timeslotModels);
    }

    @Override
    public boolean existsById(UUID timeslotId) {
        return timeslotRepository.existsById(timeslotId);
    }

    @Transactional
    @Override
    public void deleteTimeslot(UUID timeslotId) {
        Optional<TimeslotModel> timeslotModel = timeslotRepository.findById(timeslotId);
        if(timeslotModel.isEmpty()) {
            throw new RuntimeException("Timeslot is not exist");
        }
        timeslotModel.get().setStatus(TimeslotModel.Status.DELETED);
        timeslotRepository.save(timeslotModel.get());
    }


}
