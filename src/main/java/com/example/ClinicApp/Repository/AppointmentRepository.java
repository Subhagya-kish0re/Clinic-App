package com.example.ClinicApp.Repository;

import com.example.ClinicApp.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {


    List<Appointment>findAllByDoctorName(String docName);

    List<Appointment>findAllByPatientName(String visitorName);

//    @Query("SELECT a FROM Appointment a WHERE DATE(a.appointmentDateTime) = CURRENT_DATE")
//    List<Appointment> findAppointmentsforCurrDate();

}
