package com.example.Patientmanagement.mapper;

import com.example.Patientmanagement.dto.DoctorDto;
import com.example.Patientmanagement.entity.Doctor;


public class DoctorMapper {
    public static DoctorDto mapToDoctorDto(Doctor doctor){
        DoctorDto doctorDto = new DoctorDto(doctor.getId(), doctor.getName(), doctor.getEmail(),
                doctor.getSpecialization(), doctor.getVisitingHours());
        return doctorDto;
    }

    public static Doctor mapToDoctor(DoctorDto doctorDto){
        Doctor doctor = new Doctor(doctorDto.getId(), doctorDto.getName(), doctorDto.getEmail(),
                doctorDto.getSpecialization(), doctorDto.getVisitingHours());
        return doctor;
    }
}
