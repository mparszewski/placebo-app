package com.example.placebo.service.doctors;

import com.example.placebo.controllers.doctors.DoctorResponse;
import com.example.placebo.entities.Doctor;
import com.example.placebo.exceptions.ObjectNotFoundException;
import com.example.placebo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepository doctorsRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorsRepository) {
        this.doctorsRepository = doctorsRepository;
    }


    @Override
    public DoctorResponse findById(int id) throws com.example.placebo.exceptions.ObjectNotFoundException {
        Doctor doctor = doctorsRepository.findById(id).orElseThrow(com.example.placebo.exceptions.ObjectNotFoundException::new);
        return new DoctorResponse(doctor);
    }

    @Override
    public List<DoctorResponse> findByTrialId(int trialId) throws ObjectNotFoundException {
        return doctorsRepository.findByTrial_Id(trialId)
                .stream()
                .map(DoctorResponse::new)
                .collect(Collectors.toList());
    }
}
