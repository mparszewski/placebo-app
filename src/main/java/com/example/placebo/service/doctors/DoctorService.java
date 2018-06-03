package com.example.placebo.service.doctors;

import com.example.placebo.controllers.doctors.DoctorResponse;
import com.example.placebo.exceptions.ObjectNotFoundException;

import java.util.List;

public interface DoctorService {

    List<DoctorResponse> findAll();

    DoctorResponse findById(int id) throws ObjectNotFoundException;
}
