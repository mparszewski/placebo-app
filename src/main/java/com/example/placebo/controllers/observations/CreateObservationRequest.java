package com.example.placebo.controllers.observations;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CreateObservationRequest {

    private int id;
    private int patientId;
    private String text;
    private String doctorInfo;
}
