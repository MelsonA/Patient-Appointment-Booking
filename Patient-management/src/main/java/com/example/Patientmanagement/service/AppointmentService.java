package com.example.Patientmanagement.service;

import com.example.Patientmanagement.dto.AppointmentDto;
import com.example.Patientmanagement.dto.PatientDto;

import java.util.List;

public interface AppointmentService {
    AppointmentDto save(AppointmentDto appointmentDto);
    List<AppointmentDto> getAll();
    AppointmentDto get(Long id);
    AppointmentDto update(AppointmentDto appointmentDto);
    void delete(Long id);
}
