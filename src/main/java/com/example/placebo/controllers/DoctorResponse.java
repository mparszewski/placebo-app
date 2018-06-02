package com.example.placebo.controllers;

import com.example.placebo.entities.Doctor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DoctorResponse {

    private int id;
    private String firstName;
    private String lastName;
    private int ssn;
    private String specialization;


    public DoctorResponse(Doctor doctor) {
        this.id = doctor.getId();
        this.firstName = doctor.getFirstName();
        this.lastName = doctor.getLastName();
        this.ssn = doctor.getSsn();
        this.specialization = doctor.getSpecialization();
    }
}
