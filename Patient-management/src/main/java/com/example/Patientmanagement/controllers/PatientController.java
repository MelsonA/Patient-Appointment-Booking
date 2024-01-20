package com.example.Patientmanagement.controllers;

import com.example.Patientmanagement.dto.PatientDto;
import com.example.Patientmanagement.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/patient")
public class PatientController {
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto patientDto){
        PatientDto created=patientService.save(patientDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<PatientDto> getPatient(@PathVariable("id") Long id){
        PatientDto get=patientService.get(id);
        return new ResponseEntity<>(get,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<PatientDto>> getAllPatient(){
        List<PatientDto> getAll=patientService.getAll();
        return new ResponseEntity<>(getAll,HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<PatientDto> updatePatient(@RequestBody PatientDto patientDto,@PathVariable("id") Long id){
        patientDto.setId(id);
        PatientDto updated=patientService.update(patientDto);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> DeletePatient(@PathVariable("id") Long id){
        patientService.delete(id);
        return new ResponseEntity<>("User deleted",HttpStatus.NO_CONTENT);
    }

}
