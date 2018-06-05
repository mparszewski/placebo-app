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
public class TrialMaskingResponse {

    private int masking;

    public TrialMaskingResponse(Trial trial) {
        this.masking = trial.getMasking();
    }
}
