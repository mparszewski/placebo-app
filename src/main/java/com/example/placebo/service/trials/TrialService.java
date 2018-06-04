package com.example.placebo.service.trials;

import com.example.placebo.controllers.trials.TrialResponse;
import com.example.placebo.exceptions.ObjectNotFoundException;

import java.util.List;

public interface TrialService {

    List<TrialResponse> findByIsArchived(int isArchived) throws ObjectNotFoundException;

    List<TrialResponse> findAllTrials();
}
