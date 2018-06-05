package com.example.placebo.controllers.patient;

import com.example.placebo.exceptions.ObjectNotFoundException;
import com.example.placebo.service.patients.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    private PatientService service;

    @Autowired
    public PatientController(PatientService service) {
        this.service = service;
    }


    @GetMapping(name = "/patients")
    public List<ShortPatientResponse> getPatientByTrialId(@RequestParam("trialId") int trialId,
                                                          @RequestParam("isPlacebo") int isPlacebo,
                                                          @RequestParam("phase") int phase) {
        /*if(isPlacebo != 0 || isPlacebo != 1)
            return service.getAllByTrialId(trialId);
        else{*/
            return service.getByTrialIdAndIsPlaceboAndPhase(trialId, isPlacebo, phase);
        //}
    }




    @PostMapping("/patients")
    public PatientResponse create(@RequestBody CreatePatientRequest request) throws ObjectNotFoundException {
        return service.add(request);
    }

}
