package com.example.placebo.service.doctors;

import com.example.placebo.controllers.doctors.CreateDoctorRequest;
import com.example.placebo.controllers.doctors.DoctorResponse;
import com.example.placebo.controllers.doctors.ShortDoctorResponse;
import com.example.placebo.entities.Doctor;
import com.example.placebo.exceptions.ObjectNotFoundException;
import com.example.placebo.repository.DoctorRepository;
import com.example.placebo.repository.TrialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepository doctorsRepository;
    private TrialRepository trialRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorsRepository, TrialRepository trialRepository) {
        this.doctorsRepository = doctorsRepository;
        this.trialRepository = trialRepository;
    }


    @Override
    public DoctorResponse findById(int id) throws com.example.placebo.exceptions.ObjectNotFoundException {
        Doctor doctor = doctorsRepository.findById(id).orElseThrow(com.example.placebo.exceptions.ObjectNotFoundException::new);
        return new DoctorResponse(doctor);
    }

    @Override
    public List<ShortDoctorResponse> findByTrialId(int trialId) {
        return doctorsRepository.findByTrial_Id(trialId)
                .stream()
                .map(ShortDoctorResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public DoctorResponse add(CreateDoctorRequest request) throws ObjectNotFoundException {
        Doctor doctor = createDoctorFromRequest(request);
        doctorsRepository.save(doctor);
        return new DoctorResponse(doctor);
    }

    public Doctor createDoctorFromRequest(CreateDoctorRequest request) throws ObjectNotFoundException{
        Doctor doctor = new Doctor();
        doctor.setName(request.getName());
        doctor.setTitle(request.getTitle());
        doctor.setSurname(request.getSurname());
        doctor.setSsn(request.getSsn());
        doctor.setSpecialisation(request.getSpecialisation());
        doctor.setTrial(trialRepository.findById(request.getTrialId()).orElseThrow(ObjectNotFoundException::new));
        return doctor;
    }
}
