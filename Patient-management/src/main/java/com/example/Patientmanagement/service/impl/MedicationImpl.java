package com.example.Patientmanagement.service.impl;

import com.example.Patientmanagement.dto.AppointmentDto;
import com.example.Patientmanagement.dto.MedicationDto;
import com.example.Patientmanagement.entity.Appointment;
import com.example.Patientmanagement.entity.Medication;
import com.example.Patientmanagement.exception.ResourceNotFoundException;
import com.example.Patientmanagement.mapper.AppointmentMapper;
import com.example.Patientmanagement.mapper.MedicationMapper;
import com.example.Patientmanagement.repositories.MedicationRepository;
import com.example.Patientmanagement.service.MedicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MedicationImpl implements MedicationService {
    private MedicationRepository medicationRepository;
    @Override
    public MedicationDto save(MedicationDto medicationDto) {
        Medication medication= MedicationMapper.mapTomMedication(medicationDto);
        Medication create=medicationRepository.save(medication);
        MedicationDto created=MedicationMapper.mapTomMedicationDto(create);
        return created;
    }

    @Override
    public List<MedicationDto> getAll() {
        List<Medication> medications=medicationRepository.findAll();
        List<MedicationDto> medicationDtos=medications.stream().map(medication ->
                MedicationMapper.mapTomMedicationDto(medication)
        ).collect(Collectors.toList());
        return medicationDtos;
    }

    @Override
    public MedicationDto get(Long id) {
        Medication medication=medicationRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Medication","id",id));
        MedicationDto medicationDtos=MedicationMapper.mapTomMedicationDto(medication);
        return medicationDtos;
    }

    @Override
    public MedicationDto update(MedicationDto medicationDto) {
        Medication medication=MedicationMapper.mapTomMedication(medicationDto);
        Medication existingMedication=medicationRepository.findById(medication.getId()).orElseThrow(()->
                new ResourceNotFoundException("Medication","id", medication.getId()));
        existingMedication.setDoctorName(medication.getDoctorName());
        existingMedication.setPatientName(medication.getPatientName());
        existingMedication.setMedicationNames(medication.getMedicationNames());
        Medication updateMedication=medicationRepository.save(existingMedication);
        MedicationDto updatedMedication=MedicationMapper.mapTomMedicationDto(updateMedication);
        return updatedMedication;
    }

    @Override
    public void delete(Long id) {
        Medication medication=medicationRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Medication","id",id));
        medicationRepository.deleteById(medication.getId());
    }
}
