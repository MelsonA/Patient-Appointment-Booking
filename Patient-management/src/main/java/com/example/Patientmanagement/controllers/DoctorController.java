package com.example.Patientmanagement.controllers;

import com.example.Patientmanagement.dto.DoctorDto;
import com.example.Patientmanagement.dto.PatientDto;
import com.example.Patientmanagement.service.DoctorService;
import com.example.Patientmanagement.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/doctor")
public class DoctorController {
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody DoctorDto doctorDto){
        DoctorDto created=doctorService.save(doctorDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DoctorDto> getDoctor(@PathVariable("id") Long id){
        DoctorDto get=doctorService.get(id);
        return new ResponseEntity<>(get,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAllDoctor(){
        List<DoctorDto> getAll=doctorService.getAll();
        return new ResponseEntity<>(getAll,HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<DoctorDto> updateDoctor(@RequestBody DoctorDto doctorDto,@PathVariable("id") Long id){
        doctorDto.setId(id);
        DoctorDto updated=doctorService.update(doctorDto);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> DeleteDoctor(@PathVariable("id") Long id){
        doctorService.delete(id);
        return new ResponseEntity<>("User deleted",HttpStatus.NO_CONTENT);
    }
}
