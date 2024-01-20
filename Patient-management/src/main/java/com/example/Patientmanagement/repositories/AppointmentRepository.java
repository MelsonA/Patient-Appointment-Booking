package com.example.Patientmanagement.repositories;

import com.example.Patientmanagement.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
