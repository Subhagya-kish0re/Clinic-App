package com.example.ClinicApp.Controller;

import com.example.ClinicApp.Service.PatientService;
import com.example.ClinicApp.model.Patient;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @RequestMapping("/test")
    public ResponseEntity<String> getTest(){
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Patient>> getAllVisitors(){
        List<Patient> visitorList= patientService.getAllVisitor();
        return ResponseEntity.ok(visitorList);
    }
    @GetMapping("/findall")
    public ResponseEntity<Page<Patient>> getAllPatients(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5")int size
    ){
        Pageable pageable= PageRequest.of(page,size);
        Page<Patient>patients= patientService.findAll(pageable);
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/findbyid")
    public ResponseEntity<Patient> getById(@RequestParam Long id){
        Patient patient= patientService.findById(id);
        if(patient==null){
            return null;
        }else {
            return ResponseEntity.ok(patient);
        }
    }

//    Avoid creating same user(TBD)
    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@Valid @RequestParam int age, @RequestParam String name, @RequestParam String phoneNumber){


//        Check for already existing user
        Patient existingPatient= patientService.findByName(name);
        if(existingPatient!=null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Name already exists use full patient name");
        }else {
            Patient patient = patientService.createPatient(age, name, phoneNumber);
            if (patient == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to Create a Patient");
            } else {
                return ResponseEntity.ok("Patient created successfully where id is " + patient.getId());
            }
        }
    }

}
