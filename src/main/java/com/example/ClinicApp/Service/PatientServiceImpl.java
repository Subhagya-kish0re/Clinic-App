package com.example.ClinicApp.Service;

import com.example.ClinicApp.Repository.PatientRepository;
import com.example.ClinicApp.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllVisitor(){
        return patientRepository.findAll();
    }
    public Patient findById(Long Id){
       Optional<Patient> optionalPatient=patientRepository.findById(Id);
       if(optionalPatient.isPresent()){
           return optionalPatient.get();
       }else {
           return null;
       }

    }


    public Patient findByName(String name) {
        Patient patient= patientRepository.findByName(name);
        return patient;
    }

    public Patient createPatient(int age, String name,  String phoneNumber){
        Patient patient=new Patient();
        patient.setName(name);
        patient.setAge(age);
        patient.setPhoneNumber(phoneNumber);
        return patientRepository.save(patient);
    }

    public Page<Patient> findAll(Pageable pageable) {
        return patientRepository.findAll(pageable);
    }
}
