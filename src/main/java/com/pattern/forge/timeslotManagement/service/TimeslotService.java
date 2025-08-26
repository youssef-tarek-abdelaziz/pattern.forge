package com.pattern.forge.timeslotManagement.service;

import com.pattern.forge.timeslotManagement.domain.TimeslotModel;

import java.util.List;
import java.util.UUID;

public interface TimeslotService {
    void assignTimeslotsToDoctor(UUID doctorId, List<TimeslotModel> timeslotModels);
    void deleteTimeslot(UUID timeslotId);

    boolean existsById(UUID timeslotId);
}
