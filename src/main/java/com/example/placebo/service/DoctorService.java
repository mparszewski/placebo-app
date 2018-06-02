package com.example.placebo.service;

import com.example.placebo.controllers.DoctorResponse;

import java.util.List;

public interface DoctorService {

    List<DoctorResponse> findAll();
}
