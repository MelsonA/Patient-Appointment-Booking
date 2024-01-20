package com.example.Patientmanagement.repositories;

import com.example.Patientmanagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
