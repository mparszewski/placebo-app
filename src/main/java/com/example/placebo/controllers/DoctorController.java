package com.example.placebo.controllers;

import com.example.placebo.entities.Doctor;
import com.example.placebo.repository.DoctorsRepository;
import com.example.placebo.service.DoctorService;
import org.omg.PortableServer.POAPackage.ObjectAlreadyActive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/com")
public class DoctorController {

    //private DoctorService service;

    /*@Autowired
    public DoctorController(DoctorService service) {
        this.service = service;
    }*/

    @Autowired
    DoctorsRepository repo;

    @RequestMapping(value = "/alldoctors")
    @ResponseBody
    public List<Doctor> getAllDoctors() {
        return repo.findAll();
    }
    


}
