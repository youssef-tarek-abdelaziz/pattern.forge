package com.pattern.forge.timeslotManagement.controller;

import com.pattern.forge.timeslotManagement.domain.TimeslotModel;
import com.pattern.forge.timeslotManagement.service.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/timeslot")
public class TimeslotController {

    @Autowired
    private TimeslotService timeslotService;

    @PostMapping("/{doctorId}")
    public void assignTimeSlotsToDoctor(@PathVariable("doctorId") UUID doctorId, @RequestBody List<TimeslotApiDto> timeslotApiDtos) {
        List<TimeslotModel> timeslotModels = timeslotApiDtos.stream().map(TimeslotApiDto::toTimeslotModel).toList();
        timeslotService.assignTimeslotsToDoctor(doctorId, timeslotModels);
    }

    @DeleteMapping("/{timeslotId}")
    public void deleteTimeslot(@PathVariable("timeslotId") UUID timeslotId) {
        timeslotService.deleteTimeslot(timeslotId);
    }
}
