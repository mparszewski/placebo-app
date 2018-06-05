package com.example.placebo.service.trials;

import com.example.placebo.controllers.trials.CreateTrialRequest;
import com.example.placebo.controllers.trials.TrialMaskingResponse;
import com.example.placebo.controllers.trials.TrialPhaseResponse;
import com.example.placebo.controllers.trials.TrialResponse;
import com.example.placebo.exceptions.ObjectNotFoundException;

import java.util.List;

public interface TrialService {

    List<TrialResponse> findByIsArchived(int isArchived) throws ObjectNotFoundException;

    TrialResponse getTrialById(int id) throws ObjectNotFoundException;

    TrialPhaseResponse getTrialPhaseById(int id) throws ObjectNotFoundException;

    TrialMaskingResponse getTrialMaskingById(int id) throws ObjectNotFoundException;

    TrialResponse save(CreateTrialRequest request);

    void setArchivisationById(int trialId) throws ObjectNotFoundException;

    void setPhaseById(int trialId) throws ObjectNotFoundException;
}
