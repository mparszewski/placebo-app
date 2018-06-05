package com.example.placebo.controllers.trials;

import com.example.placebo.exceptions.ObjectNotFoundException;
import com.example.placebo.service.trials.TrialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public TrialResponse getTrialById(@PathVariable(value = "trialId") int trialId) throws ObjectNotFoundException{
        return service.getTrialById(trialId);
    }

    @PostMapping(value = "/trials")
    public TrialResponse add(@RequestBody CreateTrialRequest request) {
        return service.save(request);
    }

    @GetMapping(value = "/phase/{trialId}")
    public TrialPhaseResponse getTrialPhase(@PathVariable(name = "trialId") int trialId) throws ObjectNotFoundException {
        return service.getTrialPhaseById(trialId);
    }

    @GetMapping(value = "/masking/{trialId}")
    public TrialMaskingResponse getTrialMasking(@PathVariable(name = "trialId") int trialId) throws ObjectNotFoundException {
        return service.getTrialMaskingById(trialId);
    }

    @PatchMapping(value = "/trials/{trialId}/archive")
    public void setIsArchivedById(@PathVariable(name = "trialId") int trialId) throws ObjectNotFoundException {
        service.setArchivisationById(trialId);
    }

    @PatchMapping(value = "/trials/{trialId}/phase")
    public void setPhaseById(@PathVariable(name = "trialId") int trialId) throws ObjectNotFoundException {
        service.setPhaseById(trialId);
    }

}
