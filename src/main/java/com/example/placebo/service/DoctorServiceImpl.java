package com.example.placebo.service;

import com.example.placebo.controllers.DoctorResponse;
import com.example.placebo.entities.Doctor;
import com.example.placebo.repository.DoctorsRepository;
import org.hibernate.ObjectNotFoundException;
import org.omg.PortableServer.POAPackage.ObjectAlreadyActive;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService{

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
    public DoctorResponse findById(int id) throws ObjectNotFoundException, ObjectAlreadyActive {
        Doctor doctor = doctorsRepository.findById(id).orElseThrow(ObjectAlreadyActive::new);
        return new DoctorResponse(doctor);
    }
}
