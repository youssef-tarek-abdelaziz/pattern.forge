package com.pattern.forge.timeslotManagement.controller;

import com.pattern.forge.timeslotManagement.domain.TimeslotModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TimeslotApiDto {
    private LocalDateTime slotDatetime;
    private int duration;

    public TimeslotModel toTimeslotModel() {
        return new TimeslotModel(slotDatetime, duration);
    }
}
