package com.example.placebo.controllers.trials;


import com.example.placebo.entities.Trial;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrialPhaseResponse {

    private int phase;

    public TrialPhaseResponse(Trial trial) {
        this.phase = trial.getPhase();
    }
}
