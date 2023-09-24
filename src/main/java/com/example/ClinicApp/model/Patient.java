package com.example.ClinicApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient")
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "Please Enter the Patient's age")
    private int age;
    @NotBlank(message = "Please Enter a Patient's Name")
    @NotNull(message = "Please Enter a Patient's Name")
    private String name;
    @NotBlank(message = "Please Enter the Patient's Phone Number")
    @NotNull(message = "Please Enter the Patient's Phone Number")
    private String phoneNumber;

}
