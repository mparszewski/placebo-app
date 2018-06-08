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
    public List<ShortPatientResponse> getPatientByTrialId(@RequestParam(name = "trialId", required = true) int trialId,
                                                          @RequestParam(name = "isPlacebo", required = false) Integer isPlacebo,
                                                          @RequestParam(name = "phase", required = false) Integer phase)
            throws ObjectNotFoundException {
        if (isPlacebo == null && phase == null) {
            return service.getAllByTrialId(trialId);
        } else if (isPlacebo == null) {
            return service.getByTrialIdAndPhase(trialId, phase);
        } else if (phase == null) {
            return service.getByTrialIAndIsPlacebo(trialId, isPlacebo);
        } else
            return service.getByTrialIdAndIsPlaceboAndPhase(trialId, isPlacebo, phase);
    }


    @PostMapping("/patients")
    public PatientResponse create(@RequestBody CreatePatientRequest request) throws ObjectNotFoundException {
        return service.add(request);
    }

    @GetMapping("/patients/{patientId}")
    public PatientResponse getByPatientId (@PathVariable("patientId") int id) throws ObjectNotFoundException {
        return service.getByPatientId(id);
    }

}
