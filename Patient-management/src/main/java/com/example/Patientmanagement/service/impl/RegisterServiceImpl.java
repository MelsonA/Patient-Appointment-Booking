package com.example.Patientmanagement.service.impl;

import com.example.Patientmanagement.dto.AppointmentDto;
import com.example.Patientmanagement.dto.RegisterDto;
import com.example.Patientmanagement.entity.Appointment;
import com.example.Patientmanagement.entity.Doctor;
import com.example.Patientmanagement.entity.Register;
import com.example.Patientmanagement.exception.PasswordMismatchException;
import com.example.Patientmanagement.exception.ResourceNotFoundException;
import com.example.Patientmanagement.mapper.AppointmentMapper;
import com.example.Patientmanagement.mapper.RegisterMapper;
import com.example.Patientmanagement.repositories.RegisterRepository;
import com.example.Patientmanagement.service.RegisterService;
import lombok.AllArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private RegisterRepository registerRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterDto save(RegisterDto registerDto) {
        Register register= RegisterMapper.mapToRegister(registerDto);
        Register create=registerRepository.save(register);
        RegisterDto createdRegister=RegisterMapper.mapToRegisterDto(create);
        return createdRegister;
    }

    @Override
    public List<RegisterDto> getAll() {
        List<Register> registers=registerRepository.findAll();
        List<RegisterDto> registerDtos=registers.stream().map(register ->
                RegisterMapper.mapToRegisterDto(register)
        ).collect(Collectors.toList());
        return registerDtos;
    }

    @Override
    public RegisterDto get(Long id) {
        Register register=registerRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Register","id",id));
        RegisterDto registerDtos=RegisterMapper.mapToRegisterDto(register);
        return registerDtos;
    }

//    @Override
//    public RegisterDto update(RegisterDto registerDto) {
//        Register register=RegisterMapper.mapToRegister(registerDto);
//        Register existingRegister=registerRepository.findById(register.getId()).orElseThrow(()->
//                new ResourceNotFoundException("Register","id", register.getId()));
//
//        existingRegister.setUsername(register.getUsername());
//        existingRegister.setUserEmail(register.getUserEmail());
//        existingRegister.setPassword(register.getPassword());
//        existingRegister.setConfirmPassword(register.getConfirmPassword());
//        Register updateRegister=registerRepository.save(existingRegister);
//        RegisterDto updatedRegister=RegisterMapper.mapToRegisterDto(updateRegister);
//        return updatedRegister;
//    }

    @Override
    public void delete(Long id) {
        Register register=registerRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Register","id",id));
        registerRepository.deleteById(register.getId());
    }

    public Register registerUser(String username, String email, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        Register newUser = new Register();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(encodedPassword);
        return registerRepository.save(newUser);
    }

    public Optional<Register> findByUsernameOrEmail(String usernameOrEmail) {
        return registerRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
    }
}
