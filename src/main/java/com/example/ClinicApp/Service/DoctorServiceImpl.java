package com.example.ClinicApp.Service;

import com.example.ClinicApp.Repository.DoctorRepository;
import com.example.ClinicApp.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor getById(Long id){
        Optional<Doctor> doctor=doctorRepository.findById(id);
        if(!doctor.isPresent()){
            return null;
        }else {
            return doctor.get();
        }
    }
    public Doctor findByName(String name){
        return doctorRepository.findByName(name);
    }

    public List<Doctor> findAll(){
        return doctorRepository.findAll();
    }
    public Doctor createDoctor(String doctorName){
        Doctor doctor=new Doctor();
        doctor.setName(doctorName);
        return doctorRepository.save(doctor);
    }

    public Page<Doctor> findAllbypage(Pageable pageable) {
        return doctorRepository.findAll(pageable);
    }
}
