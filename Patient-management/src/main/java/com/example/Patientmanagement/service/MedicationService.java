package com.example.Patientmanagement.service;

import com.example.Patientmanagement.dto.MedicationDto;

import java.util.List;

public interface MedicationService {
    MedicationDto save(MedicationDto medicationDto);
    List<MedicationDto> getAll();
    MedicationDto get(Long id);
    MedicationDto update(MedicationDto medicationDto);
    void delete(Long id);
}
