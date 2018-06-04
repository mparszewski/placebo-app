package com.example.placebo.controllers.trials;

import com.example.placebo.exceptions.ObjectNotFoundException;
import com.example.placebo.service.trials.TrialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrialController {

    private TrialService service;

    @Autowired
    public TrialController(TrialService service) {
        this.service = service;
    }

    @GetMapping(value = "/trials")
    public List<TrialResponse> getTrialByArchivisation(@RequestParam(value = "isArchived") int isArchived) throws ObjectNotFoundException {
        return service.findByIsArchived(isArchived);
    }

    @GetMapping(value = "/trials/{trialId}")
    public List<TrialResponse> getAllTrials(@PathVariable(value = "trialId") int trialId) {
        return service.findAllTrials();
    }


}
