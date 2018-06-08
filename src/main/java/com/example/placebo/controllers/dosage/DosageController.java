package com.example.placebo.controllers.dosage;

import com.example.placebo.exceptions.ObjectNotFoundException;
import com.example.placebo.service.dosages.DosageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DosageController {

    private DosageService service;

    @Autowired
    public DosageController(DosageService service){
        this.service = service;
    }

    @PostMapping(value = "/dosages")
    public DosageResponse add(@RequestBody CreateDosageRequest request) throws ObjectNotFoundException {
        return service.add(request);
    }

    @GetMapping("/dosages")
    public List<DosageResponse> getDosageByPatientId(@RequestParam("patientId") int patientId) throws ObjectNotFoundException {
        return service.getByPatientId(patientId);
    }
}
