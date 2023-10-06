package com.example.ClinicApp.Service;

import com.example.ClinicApp.model.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DoctorService {
    Doctor getById(Long doctorid);

    List<Doctor> findAll();

    Page<Doctor> findAllbypage(Pageable pageable);

    Doctor findByName(String doctorName);

    Doctor createDoctor(String doctorName);

}
