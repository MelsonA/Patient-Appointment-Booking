package com.example.Patientmanagement.mapper;

import com.example.Patientmanagement.dto.MedicationDto;
import com.example.Patientmanagement.entity.Medication;

public class MedicationMapper {
    public static MedicationDto mapTomMedicationDto(Medication medication){
        MedicationDto medicationDto=new MedicationDto(medication.getId(),
                medication.getPatientName(), medication.getDoctorName(),
                medication.getMedicationNames());
        return medicationDto;
    }

    public static Medication mapTomMedication(MedicationDto medicationDto){
        Medication medication=new Medication(medicationDto.getId(),
                medicationDto.getPatientName(), medicationDto.getDoctorName(),
                medicationDto.getMedicationNames());
        return medication;
    }
}
