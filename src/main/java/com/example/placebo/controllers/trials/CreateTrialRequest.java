package com.example.placebo.controllers.trials;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CreateTrialRequest {

    private String contactsAndLocations;
    private String eligibiltyCriterias;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate estimatedEndDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    private int masking;
    private String responsibleParty;
    private String studyDescription;
    private String studyTitle;
    private String treatmentDescription;
    private String password;
}
