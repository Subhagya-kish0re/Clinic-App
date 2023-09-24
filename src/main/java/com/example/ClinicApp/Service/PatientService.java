package com.example.ClinicApp.Service;

import com.example.ClinicApp.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PatientService {
    Patient findById(Long patientid);

    List<Patient> getAllVisitor();

    Page<Patient> findAll(Pageable pageable);

    Patient findByName(String name);

    Patient createPatient(int age, String name, String phoneNumber);
}
