package com.example.Patientmanagement.dto;

import com.example.Patientmanagement.entity.Doctor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

    private Long id;
    private String PatientName;
    private String address;
    private String mobile;
    private String PatientEmail;
    private String emergencyContact;
}
