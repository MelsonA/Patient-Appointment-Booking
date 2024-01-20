package com.example.Patientmanagement.repositories;

import com.example.Patientmanagement.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
