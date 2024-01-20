package com.example.Patientmanagement.repositories;

import com.example.Patientmanagement.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegisterRepository extends JpaRepository<Register,Long> {

    Optional<Register> findByUsernameOrEmail(String username, String email);
}
