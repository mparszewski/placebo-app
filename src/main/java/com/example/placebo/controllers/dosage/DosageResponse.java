package com.example.placebo.controllers.dosage;


import com.example.placebo.entities.Dosage;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DosageResponse {


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;
    private int id;
    private String dosage;
    private int patientId;

    public DosageResponse(Dosage dosage) {
        this.id = dosage.getId();
        this.date = dosage.getDate();
        this.dosage = dosage.getDosage();
        this.patientId = dosage.getPatient().getId();
    }
}
