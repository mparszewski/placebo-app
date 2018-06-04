package com.example.placebo.controllers.trials;

import com.example.placebo.entities.Trial;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class TrialResponse {

    private int id;
    private String studyTitle;
    private int phase;
    private int isArchived;
    private LocalDate startDate;
    private String masking;
    private String responsibleParty;
    private String studyDescription;
    private String treatmentDescription;
    private String eligibilityCriterias;
    private LocalDate estimatedEndDate;
    private String contactAndLocations;

    public TrialResponse(Trial trial) {
        this.id = trial.getId();
        this.studyTitle = trial.getStudyTitle();
        this.phase = trial.getPhase();
        this.isArchived = trial.getIsArchived();
        this.startDate = trial.getStartDate();
        this.masking = trial.getMasking();
        this.responsibleParty = trial.getResponsibleParty();
        this.studyDescription = trial.getStudyDescription();
        this.treatmentDescription = trial.getTreatmentDescription();
        this.eligibilityCriterias = trial.getEligibilityCriterias();
        this.estimatedEndDate = trial.getEstimatedEndDate();
        this.contactAndLocations = trial.getContactsAndLocations();

    }

}
