package com.example.placebo.service.doctors;

import com.example.placebo.controllers.doctors.DoctorResponse;
import com.example.placebo.entities.Doctor;
import com.example.placebo.repository.DoctorsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorsRepository doctorsRepository;

    public DoctorServiceImpl(DoctorsRepository doctorsRepository) {
        this.doctorsRepository = doctorsRepository;
    }

    @Override
    public List<DoctorResponse> findAll() {
        return doctorsRepository.findAll()
                .stream()
                .map(DoctorResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public DoctorResponse findById(int id) throws com.example.placebo.exceptions.ObjectNotFoundException {
        Doctor doctor = doctorsRepository.findById(id).orElseThrow(com.example.placebo.exceptions.ObjectNotFoundException::new);
        return new DoctorResponse(doctor);
    }
}
