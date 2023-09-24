package com.example.ClinicApp.Service;

import com.example.ClinicApp.Repository.AppointmentRepository;
import com.example.ClinicApp.model.Appointment;
import com.example.ClinicApp.model.Doctor;
import com.example.ClinicApp.model.Patient;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment createAppointment(Doctor doctor, Patient patient, LocalDate appointmentDate, LocalTime appintmentTime){
        Appointment appointment=new Appointment();
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setAppointmentDate(appointmentDate);
        appointment.setAppointmentTime(appintmentTime);
        appointment.setStatus("PENDING");
        return appointmentRepository.save(appointment);
    }
    public List<Appointment> findAllAppointment(){
        return appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> findByDoctorName(String doctorName) {
        return appointmentRepository.findAllByDoctorName(doctorName);
    }

    @Override
    public List<Appointment> findByVisitorName(String visitorName) {
        return appointmentRepository.findAllByPatientName(visitorName);
    }

    public Optional<Appointment> getAppointmentById(Long id){
        return  appointmentRepository.findById(id);
    }

    public Page<Appointment> findAll(Pageable pageable) {
        return appointmentRepository.findAll(pageable);
    }

    public void updateAppoinmentStatus(Long appointmentId,String newStatus){
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new EntityNotFoundException("Appointment not found with ID: " + appointmentId));

        if (!isValidStatus(newStatus)){
            throw new IllegalArgumentException("Invalid status: " + newStatus);
        }
        if("PENDING".equals(appointment.getStatus())){
            appointment.setStatus(newStatus);
            appointmentRepository.save(appointment);
        }else {
            throw new IllegalStateException("Appointment status is not 'PENDING', cannot be updated.");
        }
    }
    private boolean isValidStatus(String status) {
        return "APPROVED".equals(status) || "CANCELLED".equals(status);
    }
}
