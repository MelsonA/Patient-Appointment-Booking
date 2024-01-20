package com.example.Patientmanagement.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Arrays;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {
    private Long id;
    private String patient;
    private String doctor;
    private String mobile;


}
