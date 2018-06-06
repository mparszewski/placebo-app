package com.example.placebo.controllers.dosage;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CreateDosageRequest {

    private String dosage;
    private int patientId;
}
