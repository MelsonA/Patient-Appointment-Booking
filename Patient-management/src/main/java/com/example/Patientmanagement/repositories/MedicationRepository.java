package com.example.Patientmanagement.repositories;

import com.example.Patientmanagement.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication,Long> {
}
