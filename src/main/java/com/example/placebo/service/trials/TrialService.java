package com.example.placebo.service.trials;

import com.example.placebo.controllers.trials.TrialResponse;
import com.example.placebo.entities.Trial;
import com.example.placebo.exceptions.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TrialService {

    List<TrialResponse> findByIsArchived(int isArchived) throws ObjectNotFoundException;

    TrialResponse getTrialById(int id) throws ObjectNotFoundException;
}
