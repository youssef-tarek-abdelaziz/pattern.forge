package com.pattern.forge.timeslot_management.service;

import com.pattern.forge.timeslot_management.persistence.domain.TimeslotModel;

import java.util.List;
import java.util.UUID;

public interface TimeslotService {
    void assignTimeslotsToDoctor(UUID doctorId, List<TimeslotModel> timeslotModels);
    void deleteTimeslot(UUID timeslotId);

    boolean existsById(UUID timeslotId);
}
