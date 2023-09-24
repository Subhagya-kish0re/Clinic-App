package com.example.ClinicApp.Controller;

import com.example.ClinicApp.Service.AppointmentService;
import com.example.ClinicApp.Service.DoctorService;
import com.example.ClinicApp.Service.PatientService;
import com.example.ClinicApp.model.Appointment;
import com.example.ClinicApp.model.Doctor;
import com.example.ClinicApp.model.Patient;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/create")
    public ResponseEntity<String> createAppointment(
            @Valid
            @RequestParam Long doctorid,
            @RequestParam Long patientid,
            @RequestParam String appntDate,
            @RequestParam String appntTime
    ){
        Patient patient= patientService.findById(patientid);
        Doctor doctor=doctorService.getById(doctorid);
//        LocalDateTime appointmentTime=LocalDateTime.parse(appointmentDatetime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        LocalDate appointmentDate=LocalDate.parse(appntDate);
        LocalTime appointmentTime=LocalTime.parse(appntTime);


        if (patient ==null || doctor==null){
            return ResponseEntity.badRequest().body("Invalid patient or Doctor");
        }
//        Appointment createAppointment=appointmentService.createAppointment(doctor,patient,appointmentTime);
        Appointment createAppointment=appointmentService.createAppointment(doctor,patient,appointmentDate,appointmentTime);

        if (createAppointment != null){
            return ResponseEntity.ok("Appointment created Successfully with Appointment Id "+createAppointment.getId());
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create appointment");
        }

    }

    //Search by Appointment
    @GetMapping("/getappntmntdtls")
    public ResponseEntity<Optional<Appointment>> getAppointmentDetails(@Valid @RequestParam Long id){
        Optional<Appointment> appointment=appointmentService.getAppointmentById(id);
        if(!appointment.isPresent()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(appointment);
        }
    }
    @GetMapping("/findAll")
    public ResponseEntity<Page<Appointment>>getAllAppointment(
            @RequestParam(defaultValue = "0")int page,
            @RequestParam(defaultValue = "2")int size
    ){
        Pageable pageable= PageRequest.of(page,size);
        Page<Appointment>appointmentPage=appointmentService.findAll(pageable);
        return ResponseEntity.ok(appointmentPage);
    }


    @GetMapping("/currdateappointment")
    public ResponseEntity<List<Appointment>> getCurrDateAppointment(){
        List<Appointment> appointmentList=appointmentService.findAllAppointment();
        return ResponseEntity.ok(appointmentList);
    }

    @GetMapping("/finddoctor")
    public ResponseEntity<List<Appointment>> getByDoctorName(@RequestParam String doctorName){
        List<Appointment> appointmentList=appointmentService.findByDoctorName(doctorName);
        return ResponseEntity.ok(appointmentList);
    }

    @GetMapping("/findbyvisitor")
    public ResponseEntity<List<Appointment>> getByVisitorName(@RequestParam String visitorName){
        List<Appointment> appointmentList=appointmentService.findByVisitorName(visitorName);
        return ResponseEntity.ok(appointmentList);
    }
    @PostMapping("/update-status")
    public ResponseEntity<String> changeStatus(@RequestParam Long appointmentId,@RequestParam String newStatus){
        appointmentService.updateAppoinmentStatus(appointmentId,newStatus);
        return ResponseEntity.ok("Appointment status updated successfully, For Appointment Id "+appointmentId+" to "+newStatus);
    }

}
