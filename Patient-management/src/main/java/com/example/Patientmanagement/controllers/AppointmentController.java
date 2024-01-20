package com.example.Patientmanagement.controllers;

import com.example.Patientmanagement.dto.AppointmentDto;
import com.example.Patientmanagement.dto.DoctorDto;
import com.example.Patientmanagement.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/appointment")
public class AppointmentController {
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentDto> createAppointment(@RequestBody AppointmentDto appointmentDto){
        AppointmentDto created=appointmentService.save(appointmentDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<AppointmentDto> getAppointment(@PathVariable("id") Long id){
        AppointmentDto get=appointmentService.get(id);
        return new ResponseEntity<>(get,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<AppointmentDto>> getAllAppointment(){
        List<AppointmentDto> getAll=appointmentService.getAll();
        return new ResponseEntity<>(getAll,HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<AppointmentDto> updateAppointment(@RequestBody AppointmentDto appointmentDto,@PathVariable("id") Long id){
        appointmentDto.setId(id);
        AppointmentDto updated=appointmentService.update(appointmentDto);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> DeleteAppointment(@PathVariable("id") Long id){
        appointmentService.delete(id);
        return new ResponseEntity<>("User deleted",HttpStatus.NO_CONTENT);
    }
}
