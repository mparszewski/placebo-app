package com.example.placebo.controllers.doctors;

import com.example.placebo.entities.Doctor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DoctorResponse {

    private int id;
    private String title;
    private String name;
    private String surname;
    private int ssn;
    private String specialisation;
    private int trialId;


    public DoctorResponse(Doctor doctor) {
        this.id = doctor.getId();
        this.title = doctor.getTitle();
        this.name= doctor.getName();
        this.surname = doctor.getSurname();
        this.ssn = doctor.getSsn();
        this.specialisation = doctor.getSpecialisation();
        this.trialId = doctor.getTrial().getId();
    }
}
