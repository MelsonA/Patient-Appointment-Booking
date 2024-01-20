package com.example.Patientmanagement.controllers;

import com.example.Patientmanagement.dto.PatientDto;
import com.example.Patientmanagement.dto.RegisterDto;
import com.example.Patientmanagement.entity.Register;
import com.example.Patientmanagement.service.RegisterService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/api/register")
public class RegisterController {
    private RegisterService registerService;

    @PostMapping
    public ResponseEntity<RegisterDto> createRegister(@RequestBody RegisterDto registerDto){
        RegisterDto created=registerService.save(registerDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<RegisterDto> getRegister(@PathVariable("id") Long id){
        RegisterDto get=registerService.get(id);
        return new ResponseEntity<>(get,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<RegisterDto>> getAllRegister(){
        List<RegisterDto> getAll=registerService.getAll();
        return new ResponseEntity<>(getAll,HttpStatus.OK);
    }
//    @PutMapping("{id}")
//    public ResponseEntity<RegisterDto> updateRegister(@RequestBody RegisterDto registerDto,@PathVariable("id") Long id){
//        registerDto.setId(id);
//        RegisterDto updated=registerService.update(registerDto);
//        return new ResponseEntity<>(updated,HttpStatus.OK);
//    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> DeleteRegister(@PathVariable("id") Long id){
        registerService.delete(id);
        return new ResponseEntity<>("User deleted",HttpStatus.NO_CONTENT);
    }


}
