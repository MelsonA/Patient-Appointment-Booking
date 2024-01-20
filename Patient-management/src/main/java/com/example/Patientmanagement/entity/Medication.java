package com.example.Patientmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Medication")
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Long id;
    @Column(nullable = false)
    private String patientName;
    @Column(nullable = false)
    private String doctorName;
    @Column(nullable = false)
    private String medicationNames;
}
