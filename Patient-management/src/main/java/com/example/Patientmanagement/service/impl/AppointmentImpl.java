package com.example.Patientmanagement.service.impl;

import com.example.Patientmanagement.dto.AppointmentDto;
import com.example.Patientmanagement.dto.DoctorDto;
import com.example.Patientmanagement.entity.Appointment;
import com.example.Patientmanagement.entity.Doctor;
import com.example.Patientmanagement.exception.ResourceNotFoundException;
import com.example.Patientmanagement.mapper.AppointmentMapper;
import com.example.Patientmanagement.mapper.DoctorMapper;
import com.example.Patientmanagement.repositories.AppointmentRepository;
import com.example.Patientmanagement.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppointmentImpl implements AppointmentService {
    private AppointmentRepository appointmentRepository;
    @Override
    public AppointmentDto save(AppointmentDto appointmentDto) {
        Appointment appointment= AppointmentMapper.mapToAppointment(appointmentDto);
        Appointment create=appointmentRepository.save(appointment);
        AppointmentDto createdDoctor=AppointmentMapper.mapToAppointmentDto(create);
        return createdDoctor;
    }

    @Override
    public List<AppointmentDto> getAll() {
        List<Appointment> appointments=appointmentRepository.findAll();
        List<AppointmentDto> appointmentDtos=appointments.stream().map(appointment ->
                AppointmentMapper.mapToAppointmentDto(appointment)
        ).collect(Collectors.toList());
        return appointmentDtos;
    }

    @Override
    public AppointmentDto get(Long id) {
        Appointment appointment=appointmentRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Appointment","id",id));
        AppointmentDto appointmentDtos=AppointmentMapper.mapToAppointmentDto(appointment);
        return appointmentDtos;
    }

    @Override
    public AppointmentDto update(AppointmentDto appointmentDto) {
        Appointment appointment=AppointmentMapper.mapToAppointment(appointmentDto);
        Appointment existingAppointment=appointmentRepository.findById(appointment.getId()).orElseThrow(()->
                new ResourceNotFoundException("Doctor","id", appointment.getId()));
        existingAppointment.setDoctor(appointment.getDoctor());
        existingAppointment.setPatient(appointment.getPatient());
        existingAppointment.setMobile(appointment.getMobile());
        Appointment updateAppointment=appointmentRepository.save(existingAppointment);
        AppointmentDto updatedAppointment=AppointmentMapper.mapToAppointmentDto(updateAppointment);
        return updatedAppointment;
    }

    @Override
    public void delete(Long id) {
        Appointment appointment=appointmentRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Doctor","id",id));
        appointmentRepository.deleteById(appointment.getId());
    }
}
