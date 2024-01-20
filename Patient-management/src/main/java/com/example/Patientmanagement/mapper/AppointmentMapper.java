package com.example.Patientmanagement.mapper;

import com.example.Patientmanagement.dto.AppointmentDto;
import com.example.Patientmanagement.entity.Appointment;
import com.example.Patientmanagement.entity.Doctor;
import com.example.Patientmanagement.entity.Patient;

import java.util.List;

public class AppointmentMapper {
    public static AppointmentDto mapToAppointmentDto(Appointment appointment) {
        AppointmentDto appointmentDto = new AppointmentDto(
                appointment.getId(),
                appointment.getPatient().getPatientName(),
                appointment.getDoctor().getName(),
                appointment.getMobile()
        );
        return appointmentDto;
    }

    public static Appointment mapToAppointment(AppointmentDto appointmentDto) {
        Patient patient = new Patient();
        patient.setPatientName(appointmentDto.getPatient());

        Doctor doctor = new Doctor();
        doctor.setName(appointmentDto.getDoctor());

        Appointment appointment = new Appointment(
                appointmentDto.getId(),
                patient,
                doctor,
                appointmentDto.getMobile()
        );
        return appointment;
    }
}
