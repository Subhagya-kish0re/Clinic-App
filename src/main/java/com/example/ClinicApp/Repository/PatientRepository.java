package com.example.ClinicApp.Repository;

import com.example.ClinicApp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PatientRepository extends JpaRepository<Patient,Long>{
    Patient findByName(String name);


}
