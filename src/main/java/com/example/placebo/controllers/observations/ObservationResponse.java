package com.example.placebo.controllers.observations;

import com.example.placebo.entities.Observation;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ObservationResponse {

    private int id;
    private int patientId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    private String doctorInfo;
    private String text;

    public ObservationResponse(Observation observation) {
        this.id = observation.getId();
        this.patientId = observation.getPatient().getId();
        this.date = observation.getDate();
        this.doctorInfo = observation.getDoctorInfo();
        this.text = observation.getText();
    }
}
