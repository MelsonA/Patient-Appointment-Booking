package com.example.Patientmanagement.service.impl;

import com.example.Patientmanagement.dto.PatientDto;
import com.example.Patientmanagement.entity.Patient;
import com.example.Patientmanagement.exception.ResourceNotFoundException;
import com.example.Patientmanagement.mapper.PatientMapper;
import com.example.Patientmanagement.repositories.PatientRepository;
import com.example.Patientmanagement.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;
    @Override
    public PatientDto save(PatientDto patientDto) {
        Patient patient=PatientMapper.mapToPatient(patientDto);
        Patient createPatient=patientRepository.save(patient);
        PatientDto createdPatient=PatientMapper.mapToPatientDto(createPatient);
        return createdPatient;
    }

    @Override
    public List<PatientDto> getAll() {
        List<Patient> patients=patientRepository.findAll();
        List<PatientDto> patientDtos=patients.stream().map(patient->
                PatientMapper.mapToPatientDto(patient)).collect(Collectors.toList());
        return patientDtos;
    }

    @Override
    public PatientDto get(Long id) {
        Patient patient=patientRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Patient","id",id));
        PatientDto getPatient=PatientMapper.mapToPatientDto(patient);
        return getPatient;
    }

    @Override
    public PatientDto update(PatientDto patientDto) {
        Patient patient=PatientMapper.mapToPatient(patientDto);
        Patient existingPatient=patientRepository.findById(patient.getId()).orElseThrow(()->
                new ResourceNotFoundException("Patient","id",patient.getId()));
        existingPatient.setPatientName(patient.getPatientName());
        existingPatient.setAddress(patient.getAddress());
        existingPatient.setMobile(patient.getMobile());
        existingPatient.setPatientEmail(patient.getPatientEmail());
        existingPatient.setEmergencyContact(patient.getEmergencyContact());
        Patient updatePatient=patientRepository.save(existingPatient);
        PatientDto upadtedPatient=PatientMapper.mapToPatientDto(updatePatient);
        return upadtedPatient;
    }

    @Override
    public void delete(Long id) {
        Patient patient=patientRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Patient","id",id));
        patientRepository.deleteById(patient.getId());
    }
}
