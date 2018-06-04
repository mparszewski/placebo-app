package com.example.placebo.service.trials;

import com.example.placebo.controllers.trials.TrialResponse;
import com.example.placebo.exceptions.ObjectNotFoundException;
import com.example.placebo.repository.TrialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrialServiceImpl implements TrialService{

    private TrialRepository trialRepository;

    @Autowired
    public TrialServiceImpl(TrialRepository trialRespository) {
        this.trialRepository = trialRespository;
    }

    @Override
    public List<TrialResponse> findByIsArchived(int isArchived) throws ObjectNotFoundException {
        return trialRepository.findByIsArchived(isArchived)
                .stream()
                .map(TrialResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrialResponse> findAllTrials() {
        return trialRepository.findAll()
                .stream()
                .map(TrialResponse::new)
                .collect(Collectors.toList());
    }
}
