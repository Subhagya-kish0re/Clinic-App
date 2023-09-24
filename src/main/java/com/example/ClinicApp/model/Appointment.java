package com.example.ClinicApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointment")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    private long doctor_id;
//    private String doctor_name;
//    private long patient_id;
//    private String patient_name;
//    private LocalDate appointment_date;
//    private LocalTime appointment_time;


    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;


//    @NotBlank(message = "Please Enter Appointment's Date")
    private LocalDate appointmentDate;
//    @NotBlank(message = "Please Enter Appointment's Time")
    private LocalTime appointmentTime;

    @Column(nullable = false, columnDefinition = "VARCHAR(10) DEFAULT 'PENDING'")
    private String status;

}
