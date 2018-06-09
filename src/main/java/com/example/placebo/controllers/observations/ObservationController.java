package com.example.placebo.controllers.observations;


import com.example.placebo.controllers.dosage.CreateDosageRequest;
import com.example.placebo.exceptions.ObjectNotFoundException;
import com.example.placebo.service.observations.ObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ObservationController {

    private ObservationService service;

    @Autowired
    public ObservationController(ObservationService service) {
        this.service = service;
    }

    @PostMapping("/observations")
    public ObservationResponse add(@RequestBody CreateObservationRequest request) throws ObjectNotFoundException {
        return service.add(request);
    }

    @GetMapping("/observations/{observationId}")
    public ObservationResponse getObservationById(@PathVariable("observationId") int observationId) throws ObjectNotFoundException {
        return service.getObservationById(observationId);
    }

    @GetMapping("/observations")
    public List<ObservationResponse> getObservationByPatientId(@RequestParam("patientId") int patientId) {
        return service.getObservationsByPatientId(patientId);
    }
}
