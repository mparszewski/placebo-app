package com.example.placebo.controllers.trials;


import com.example.placebo.entities.Trial;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ExtendedTrialResponse {


    private int id;
    private String studyTitle;
    private int phase;
    private int isArchived;
    private LocalDate startDate;
    private int masking;
    private String responsibleParty;
    private String studyDescription;
    private String treatmentDescription;
    private String eligibilityCriterias;
    private LocalDate estimatedEndDate;
    private String contactsAndLocations;
    private int numberOfDoctors;
    private int numberOfPatients;

    public ExtendedTrialResponse(Trial trial) {
        this.id = trial.getId();
        this.studyTitle = trial.getStudyTitle();
        this.phase = trial.getPhase();
        this.isArchived = trial.getIsArchived();
        this.startDate = trial.getStartDate();
        this.masking = trial.getMasking();
        this.responsibleParty = trial.getResponsibleParty();
        this.studyDescription = trial.getStudyDescription();
        this.treatmentDescription = trial.getTreatmentDescription();
        this.eligibilityCriterias = trial.getEligibiltyCriterias();
        this.estimatedEndDate = trial.getEstimatedEndDate();
        this.contactsAndLocations = trial.getContactsAndLocations();
        this.numberOfPatients = trial.getPatients().size();
        this.numberOfDoctors = trial.getDoctors().size();
    }
}
