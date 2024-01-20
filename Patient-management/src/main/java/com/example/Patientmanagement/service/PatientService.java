package com.example.Patientmanagement.service;

import com.example.Patientmanagement.dto.PatientDto;

import java.util.List;

public interface PatientService {

    PatientDto save(PatientDto patientDto);
    List<PatientDto> getAll();
    PatientDto get(Long id);
    PatientDto update(PatientDto patientDto);
    void delete(Long id);


}
