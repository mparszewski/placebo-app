package com.example.placebo.controllers.patient;
import com.example.placebo.entities.Patient;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponse {

    private int id;
    private String name;
    private String surname;
    private long ssn;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private String currentDosage;
    private int phase;
    private int group;
    private int trialId;

    public PatientResponse(Patient patient) {
        this.id = patient.getId();
        this.name = patient.getName();
        this.surname = patient.getSurname();
        this.ssn = patient.getSsn();
        this.birthDate = patient.getBirthDate();
        this.currentDosage = patient.getCurrentDosage();
        this.phase = patient.getPhase();
        this.group = patient.getPlaceboGroup();
        this.trialId = patient.getTrial().getId();
    }
}
