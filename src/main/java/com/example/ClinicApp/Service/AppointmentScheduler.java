package com.example.ClinicApp.Service;

import com.example.ClinicApp.Repository.AppointmentRepository;
import com.example.ClinicApp.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class AppointmentScheduler {

    @Autowired
    private KafkaProducerService kafkaService;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Scheduled(fixedRate = 6000)
    public void sendAppointmentReminders(){
        LocalDate localDate=LocalDate.now();
        LocalTime localTime=LocalTime.now();

//        List<Appointment> appointmentList=appointmentRepository.findByAppointmentDate(localDate);
        List<Appointment> appointmentList=appointmentRepository.findByAppointmentDateAndAppointmentTime(localDate,localTime);

        for (Appointment appointment: appointmentList){
                String message="Appointment Completed: "+appointment.getId()+" by "+appointment.getDoctor().getName()+" with "+appointment.getPatient().getName()+" at "+appointment.getAppointmentDate() +appointment.getAppointmentTime();
                kafkaService.sendMessage(message);
        }
    }
}
