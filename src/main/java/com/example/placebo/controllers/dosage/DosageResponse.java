package com.example.placebo.controllers.dosage;


import com.example.placebo.entities.Dosage;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class DosageResponse {

    private int id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    private String dosage;
    private int patientId;

    public DosageResponse(Dosage dosage) {
        this.id = dosage.getId();
        this.date = dosage.getDate();
        this.dosage = dosage.getDosage();
        this.patientId = dosage.getPatient().getId();
    }
}
