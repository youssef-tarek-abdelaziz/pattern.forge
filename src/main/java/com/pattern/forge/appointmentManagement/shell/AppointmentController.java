package com.pattern.forge.appointmentManagement.shell;


import com.pattern.forge.appointmentManagement.core.Appointment;
import com.pattern.forge.appointmentManagement.core.AppointmentService;
import com.pattern.forge.appointmentManagement.core.AppointmentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<List<Appointment>> getAllAppointment(@PathVariable("doctorId") UUID doctorId, @Param("to") LocalDateTime to) {
        return ResponseEntity.ok().body(appointmentService.viewAllAppointments(doctorId, to));
    }

    @PostMapping("/{id}/{doctorId}/status/{status}")
    public ResponseEntity<?> changeAppointmentStatus(@PathVariable("id") UUID id, @PathVariable("doctorId") UUID doctorId, @PathVariable("status") AppointmentStatus status) {
        appointmentService.changeAppointmentStatus(doctorId, id, status);
        return ResponseEntity.ok().build();
    }
}
