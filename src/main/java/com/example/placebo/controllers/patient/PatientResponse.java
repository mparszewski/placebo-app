package com.example.placebo.controllers.patient;
import com.example.placebo.entities.Patient;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class PatientResponse {

    private int id;
    private String name;
    private String surname;
    private int ssn;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private String currentDosage;
    private int phase;
    private int isPlacebo;

    public PatientResponse(Patient patient) {
        this.id = patient.getId();
        this.name = patient.getName();
        this.surname = patient.getSurname();
        this.ssn = patient.getSsn();
        this.birthDate = patient.getBirthDate();
        this.currentDosage = patient.getCurrentDosage();
        this.phase = patient.getPhase();
        this.isPlacebo = patient.getIsPlacebo();
    }
}
