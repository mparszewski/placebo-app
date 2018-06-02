package com.example.placebo.service;

import com.example.placebo.controllers.DoctorResponse;
import com.example.placebo.entities.Doctor;
import com.example.placebo.repository.DoctorsRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService{

    private DoctorsRepository doctorsRepository;

    @Override
    public List<DoctorResponse> findAll() {
        return doctorsRepository.findAll()
                .stream()
                .map(DoctorResponse::new)
                .collect(Collectors.toList());
    }
}
