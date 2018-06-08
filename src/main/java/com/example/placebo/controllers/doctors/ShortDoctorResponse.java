package com.example.placebo.controllers.doctors;

import com.example.placebo.entities.Doctor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShortDoctorResponse implements Serializable {

    private int id;
    private String title;
    private String name;
    private String surname;

    public ShortDoctorResponse(Doctor doctor) {
        this.id = doctor.getId();
        this.title = doctor.getTitle();
        this.name = doctor.getName();
        this.surname = doctor.getSurname();
    }
}
