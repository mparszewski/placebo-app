package com.example.placebo.controllers.patient;

import com.example.placebo.entities.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShortPatientResponse {

    private int id;
    private String name;
    private String surname;
    private int group;

    public ShortPatientResponse(Patient patient) {
        this.id = patient.getId();
        this.name = patient.getName();
        this.surname = patient.getSurname();
        this.group = patient.getPlaceboGroup();
    }
}
