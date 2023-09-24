package com.example.ClinicApp.Controller;

import com.example.ClinicApp.Service.DoctorService;
import com.example.ClinicApp.model.Doctor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/doctor")
@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/findalldoctors")
    public ResponseEntity<List<Doctor>> getAllDoctors(){
        List<Doctor> doctorList=doctorService.findAll();
        return ResponseEntity.ok(doctorList);
    }
    @GetMapping("/findall")
    public ResponseEntity<Page<Doctor>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ){
        Pageable pageable= PageRequest.of(page, size);
        Page<Doctor> doctorPage=doctorService.findAllbypage(pageable);
        return ResponseEntity.ok(doctorPage);
    }
    @GetMapping("/findbyid")
    public ResponseEntity<Doctor> getbyid( @RequestParam Long id){
         Doctor doctor= doctorService.getById(id);
         return ResponseEntity.ok(doctor);

    }

    @PostMapping("/createnewdoctor")
    public ResponseEntity<String> createDoctor(@Valid @RequestParam String doctorName) {
        Doctor existingDoctor = doctorService.findByName(doctorName);
        if (existingDoctor == null) {
            Doctor newDoctor = doctorService.createDoctor(doctorName);
            if (newDoctor != null) {
                return ResponseEntity.ok("New Doctor Added Successfully with doctor_id "+newDoctor.getId());
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create New Doctor");
            }

        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Name of this Doctor Already exists");
        }
    }


}
