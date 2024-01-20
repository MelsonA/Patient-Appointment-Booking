package com.example.Patientmanagement.service.impl;

import com.example.Patientmanagement.dto.DoctorDto;
import com.example.Patientmanagement.entity.Doctor;
import com.example.Patientmanagement.exception.ResourceNotFoundException;
import com.example.Patientmanagement.mapper.DoctorMapper;
import com.example.Patientmanagement.repositories.DoctorRepository;
import com.example.Patientmanagement.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private DoctorRepository doctorRepository;
    @Override
    public DoctorDto save(DoctorDto doctorDto) {
        Doctor doctor=DoctorMapper.mapToDoctor(doctorDto);
        Doctor createDoctor=doctorRepository.save(doctor);
        DoctorDto createdDoctor=DoctorMapper.mapToDoctorDto(createDoctor);
        return createdDoctor;
    }

    @Override
    public List<DoctorDto> getAll() {
        List<Doctor> doctors=doctorRepository.findAll();
        List<DoctorDto> doctorDtos=doctors.stream().map(doctor ->
            DoctorMapper.mapToDoctorDto(doctor)
        ).collect(Collectors.toList());
        return doctorDtos;
    }

    @Override
    public DoctorDto get(Long id) {
        Doctor doctor=doctorRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Doctor","id",id));
        DoctorDto doctorDtos=DoctorMapper.mapToDoctorDto(doctor);
        return doctorDtos;
    }

    @Override
    public DoctorDto update(DoctorDto doctorDto) {
        Doctor doctor=DoctorMapper.mapToDoctor(doctorDto);
        Doctor existingDoctor=doctorRepository.findById(doctor.getId()).orElseThrow(()->
                new ResourceNotFoundException("Doctor","id", doctor.getId()));
        existingDoctor.setName(doctor.getName());
        existingDoctor.setEmail(doctor.getEmail());
        existingDoctor.setSpecialization(doctor.getSpecialization());
        existingDoctor.setVisitingHours(doctor.getVisitingHours());
        Doctor updateDoctor=doctorRepository.save(existingDoctor);
        DoctorDto updatedDoctor=DoctorMapper.mapToDoctorDto(updateDoctor);
        return updatedDoctor;
    }

    @Override
    public void delete(Long id) {
        Doctor doctor=doctorRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Doctor","id",id));
        doctorRepository.deleteById(doctor.getId());
    }
}
