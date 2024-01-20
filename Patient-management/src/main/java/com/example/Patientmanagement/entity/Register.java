package com.example.Patientmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Register")
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "register_id")
    private Long id;
    @Column(nullable = false,unique = true)
    private String username;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false,unique = true)
    private String password;
}
