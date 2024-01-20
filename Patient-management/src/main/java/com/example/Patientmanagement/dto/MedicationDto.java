package com.example.Patientmanagement.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicationDto {
    private Long id;
    private String patientName;
    private String doctorName;
    private String medicationNames;
}
