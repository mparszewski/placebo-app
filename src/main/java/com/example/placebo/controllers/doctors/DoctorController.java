package com.example.placebo.controllers.doctors;

import com.example.placebo.exceptions.ObjectNotFoundException;
import com.example.placebo.service.doctors.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {

    private DoctorService service;

    @Autowired
    public DoctorController(DoctorService service) {
        this.service = service;
    }


    @GetMapping(value = "/doctors/{doctorId}")
    public DoctorResponse getDoctorById(@PathVariable("doctorId") int doctorId) throws com.example.placebo.exceptions.ObjectNotFoundException {
        return service.findById(doctorId);
    }

    @GetMapping(value = "/doctors")
    public List<DoctorResponse> getDoctorsForTrial(@RequestParam("trialId") int trialId) throws ObjectNotFoundException {
        return service.findByTrialId(trialId);
    }

    @PostMapping(value = "/doctors")
    public DoctorResponse create(@RequestBody CreateDoctorRequest request) throws ObjectNotFoundException{
        return service.add(request);
    }

}
