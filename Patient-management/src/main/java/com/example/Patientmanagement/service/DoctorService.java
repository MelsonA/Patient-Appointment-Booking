package com.example.Patientmanagement.service;

import com.example.Patientmanagement.dto.DoctorDto;

import java.util.List;

public interface DoctorService {
    DoctorDto save(DoctorDto doctorDto);
    List<DoctorDto> getAll();
    DoctorDto get(Long id);
    DoctorDto update(DoctorDto doctorDto);
    void delete(Long id);
}
