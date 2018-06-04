package com.example.placebo.controllers.doctors;

import com.example.placebo.entities.Trial;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CreateDoctorRequest {

    private String title;
    private String name;
    private String surname;
    private int ssn;
    private String specialisation;
    private int trialId;

}
