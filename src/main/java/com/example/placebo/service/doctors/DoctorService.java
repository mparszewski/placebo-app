package com.example.placebo.service.doctors;

import com.example.placebo.controllers.doctors.CreateDoctorRequest;
import com.example.placebo.controllers.doctors.DoctorResponse;
import com.example.placebo.controllers.doctors.ShortDoctorResponse;
import com.example.placebo.exceptions.ObjectNotFoundException;

import java.util.List;

public interface DoctorService {

    DoctorResponse findById(int id) throws ObjectNotFoundException;

    List<DoctorResponse> findByTrialId(int trialId) throws ObjectNotFoundException;

    DoctorResponse add(CreateDoctorRequest request) throws ObjectNotFoundException;
}
