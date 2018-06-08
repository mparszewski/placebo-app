package com.example.placebo.controllers.observations;


import com.example.placebo.entities.Observation;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ShortObservationResponse {

    private int id;
    private LocalDateTime date;
    private String doctorInformation;

    public ShortObservationResponse(Observation observation) {
        this.id = observation.getId();
        this.date = observation.getDate();
        this.doctorInformation = observation.getDoctorInfo();
    }
}
