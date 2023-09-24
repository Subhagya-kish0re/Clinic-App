package com.example.ClinicApp.Service;

import com.example.ClinicApp.model.Appointment;
import com.example.ClinicApp.model.Doctor;
import com.example.ClinicApp.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    Appointment createAppointment(Doctor doctor, Patient patient, LocalDate appointmentDate, LocalTime appointmentTime);

    Optional<Appointment> getAppointmentById(Long id);

    Page<Appointment> findAll(Pageable pageable);

    List<Appointment> findAllAppointment();

    List<Appointment> findByDoctorName(String doctorName);

    List<Appointment> findByVisitorName(String visitorName);

    void updateAppoinmentStatus(Long appointmentId,String newStatus);
}
