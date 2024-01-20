package com.example.Patientmanagement.mapper;

import com.example.Patientmanagement.dto.PatientDto;
import com.example.Patientmanagement.entity.Patient;

public class PatientMapper {

    public static PatientDto mapToPatientDto(Patient patient){
        PatientDto patientDto=new PatientDto(patient.getId(), patient.getPatientName(),
                patient.getAddress(), patient.getMobile(), patient.getPatientEmail(),
                patient.getEmergencyContact());
        return patientDto;
    }

    public static Patient mapToPatient(PatientDto patientDto){
        Patient patient=new Patient(patientDto.getId(), patientDto.getPatientName(),
                patientDto.getAddress(), patientDto.getMobile(), patientDto.getPatientEmail(),
                patientDto.getEmergencyContact());
        return patient;
    }
}
