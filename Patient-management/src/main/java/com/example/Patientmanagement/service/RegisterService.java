package com.example.Patientmanagement.service;

import com.example.Patientmanagement.dto.DoctorDto;
import com.example.Patientmanagement.dto.RegisterDto;

import java.util.List;

public interface RegisterService {
    RegisterDto save(RegisterDto registerDto);
    List<RegisterDto> getAll();
    RegisterDto get(Long id);
    //RegisterDto update(RegisterDto registerDto);
    void delete(Long id);


}
