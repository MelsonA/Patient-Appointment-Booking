package com.example.Patientmanagement.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {

    private Long id;
    private String name;
    private String email;
    private String specialization;
    private String visitingHours;
}
