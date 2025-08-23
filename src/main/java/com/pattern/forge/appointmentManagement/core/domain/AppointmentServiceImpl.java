package com.pattern.forge.appointmentManagement.core.domain;

import com.pattern.forge.appointmentManagement.core.port.out.AppointmentRepository;
import com.pattern.forge.appointmentManagement.core.port.in.AppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Appointment> viewAllAppointments(UUID doctorId, LocalDateTime to) {
        if(to == null) {
            return appointmentRepository.viewAllAppointment(doctorId);
        } else {
            return appointmentRepository.viewAllAppointment(doctorId, to);
        }
    }

    @Transactional
    @Override
    public void changeAppointmentStatus(UUID doctorId, UUID appointmentId, AppointmentStatus status) {
        Optional<Appointment> appointmentOpt = appointmentRepository.viewAppointment(appointmentId);
        if(appointmentOpt.isEmpty()) {
            log.error("Cannot find appointment");
            return;
        }
        Appointment appointment = appointmentOpt.get();
        appointment.changeAppointmentStatus(status);
        appointmentRepository.updateAppointmentStatus(appointment);
    }
}




