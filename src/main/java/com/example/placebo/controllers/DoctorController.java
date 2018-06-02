package com.example.placebo.controllers;

import com.example.placebo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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


}
