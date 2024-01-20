package com.example.Patientmanagement.controllers;

import com.example.Patientmanagement.dto.AppointmentDto;
import com.example.Patientmanagement.dto.MedicationDto;
import com.example.Patientmanagement.service.MedicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/medication")
public class MedicationController {
    private MedicationService medicationService;
    @PostMapping
    public ResponseEntity<MedicationDto> createMedication(@RequestBody MedicationDto medicationDto){
        MedicationDto created=medicationService.save(medicationDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<MedicationDto> getMedication(@PathVariable("id") Long id){
        MedicationDto get=medicationService.get(id);
        return new ResponseEntity<>(get,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<MedicationDto>> getAllAppointment(){
        List<MedicationDto> getAll=medicationService.getAll();
        return new ResponseEntity<>(getAll,HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<MedicationDto> updateMedication(@RequestBody MedicationDto medicationDto,@PathVariable("id") Long id){
        medicationDto.setId(id);
        MedicationDto updated=medicationService.update(medicationDto);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> DeleteMedication(@PathVariable("id") Long id){
        medicationService.delete(id);
        return new ResponseEntity<>("User deleted",HttpStatus.NO_CONTENT);
    }
}
