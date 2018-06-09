package com.example.placebo.service.observations;

import com.example.placebo.controllers.observations.CreateObservationRequest;
import com.example.placebo.controllers.observations.ObservationResponse;
import com.example.placebo.entities.Observation;
import com.example.placebo.entities.Patient;
import com.example.placebo.exceptions.ObjectNotFoundException;
import com.example.placebo.repository.DoctorRepository;
import com.example.placebo.repository.ObservationRepository;
import com.example.placebo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObservationServiceImpl implements ObservationService {

    private ObservationRepository observationRepository;
    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;

    @Autowired
    public ObservationServiceImpl(ObservationRepository observationRepository, PatientRepository patientRepository, DoctorRepository doctorRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.observationRepository = observationRepository;
    }


    @Override
    public ObservationResponse add(CreateObservationRequest request) throws ObjectNotFoundException {
        Observation observation = createObservationFromRequest(request);
        observationRepository.save(observation);
        return new ObservationResponse(observation);
    }

    @Override
    public ObservationResponse getObservationById(int observationId) throws ObjectNotFoundException{
        Observation observation = observationRepository.findById(observationId).orElseThrow(ObjectNotFoundException::new);
        return new ObservationResponse(observation);
    }

    @Override
    public List<ObservationResponse> getObservationsByPatientId(int patientId) {
        return observationRepository.findByPatient_Id(patientId)
                .stream()
                .map(ObservationResponse::new)
                .sorted(Comparator.comparingInt(ObservationResponse::getId).reversed())
                .collect(Collectors.toList());
    }


    public Observation createObservationFromRequest(CreateObservationRequest request) throws ObjectNotFoundException{
        Observation observation = new Observation();
        Patient patient = patientRepository.findById(request.getPatientId()).orElseThrow(ObjectNotFoundException::new);
        observation.setId(request.getId());
        observation.setDate(LocalDateTime.now());
        observation.setPatient(patient);
        observation.setDoctorInfo(request.getDoctorInfo());
        observation.setText(request.getText());
        return observation;
    }
}
