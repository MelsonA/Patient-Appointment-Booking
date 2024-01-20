package com.example.Patientmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long id;
    @Column(nullable = false)
    private String patientName;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String mobile;
    @Column(nullable = false)
    private String patientEmail;
    @Column(nullable = false)
    private String emergencyContact;

}
