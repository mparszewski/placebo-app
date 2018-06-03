package com.example.placebo.controllers.doctors;

import com.example.placebo.service.doctors.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorController {

    private DoctorService service;

    @Autowired
    public DoctorController(DoctorService service) {
        this.service = service;
    }


    @GetMapping(value = "/doctors")
    public List<DoctorResponse> getAllDoctors() {
        return service.findAll();
    }

    @GetMapping(value = "/doctors/{doctorId}")
    public DoctorResponse getDoctorById(@PathVariable("doctorId") int doctorId) throws com.example.placebo.exceptions.ObjectNotFoundException {
        return service.findById(doctorId);
    }

}
