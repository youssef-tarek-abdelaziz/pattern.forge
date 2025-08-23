package com.pattern.forge.appointmentManagement.shell.adapter.out.persistence;

import com.pattern.forge.appointmentManagement.core.domain.Appointment;
import com.pattern.forge.appointmentManagement.core.port.out.AppointmentRepository;
import com.pattern.forge.appointmentManagement.shell.repository.AppointmentJpaRepo;
import com.pattern.forge.appointmentManagement.shell.model.AppointmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class AppointmentPostgresRepo implements AppointmentRepository {

    @Autowired
    private AppointmentJpaRepo appointmentJpaRepo;

    @Override
    public List<Appointment> viewAllAppointment(UUID doctorId) {
        List<AppointmentModel> appointmentModels = appointmentJpaRepo.findAllByDoctorModelId(doctorId);
        return appointmentModels.stream()
                .map(appointmentModel -> new Appointment(appointmentModel.getId(),
                        appointmentModel.getTimeSlotModel().getId(),
                        appointmentModel.getPatientModel().getId(),
                        appointmentModel.getReservedAt(),
                        appointmentModel.getStatus(),
                        appointmentModel.getAppointmentType()))
                .toList();    }

    @Override
    public List<Appointment> viewAllAppointment(UUID doctorId, LocalDateTime to) {
        List<AppointmentModel> appointmentModels = appointmentJpaRepo.findAllByDoctorModelIdAndReservedAtBefore(doctorId, to);
        return appointmentModels.stream()
                .map(appointmentModel -> new Appointment(appointmentModel.getId(),
                        appointmentModel.getTimeSlotModel().getId(),
                        appointmentModel.getPatientModel().getId(),
                        appointmentModel.getReservedAt(),
                        appointmentModel.getStatus(),
                        appointmentModel.getAppointmentType()))
                .toList();
    }

    @Override
    public Optional<Appointment> viewAppointment(UUID id) {
        return appointmentJpaRepo.findById(id)
                .stream()
                .map(appointmentModel -> new Appointment(appointmentModel.getId(),
                        appointmentModel.getTimeSlotModel().getId(),
                        appointmentModel.getPatientModel().getId(),
                        appointmentModel.getReservedAt(),
                        appointmentModel.getStatus(),
                        appointmentModel.getAppointmentType())
                ).findFirst();
    }

    @Override
    public void updateAppointmentStatus(Appointment appointment) {
        appointmentJpaRepo.updateAppointmentStatus(appointment.getId(), appointment.getStatus());
    }
}
