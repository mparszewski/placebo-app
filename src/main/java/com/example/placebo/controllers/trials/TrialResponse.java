package com.example.placebo.controllers.trials;

import com.example.placebo.entities.Trial;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TrialResponse {

    private int id;
    private String abbreviation;
    private String description;
    private int isArchived;

    public TrialResponse(Trial trial) {
        this.id = trial.getId();
        this.abbreviation = trial.getAbbreviation();
        this.description = trial.getDescription();
        this.isArchived = trial.getIsArchived();
    }
}
