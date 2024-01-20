package com.example.Patientmanagement.mapper;

import com.example.Patientmanagement.dto.RegisterDto;
import com.example.Patientmanagement.entity.Register;

public class RegisterMapper {

    public static RegisterDto mapToRegisterDto(Register register){
        RegisterDto registerDto=new RegisterDto(register.getId(), register.getUsername(),
                register.getEmail(), register.getPassword());
        return registerDto;
    }

    public static Register mapToRegister(RegisterDto registerDto){
        Register register=new Register(registerDto.getId(), registerDto.getUsername(),
                registerDto.getEmail(), registerDto.getPassword());
        return register;
    }
}
