package com.example.placebo.service.patients;

import com.example.placebo.controllers.patient.CreatePatientRequest;
import com.example.placebo.controllers.patient.PatientResponse;
import com.example.placebo.controllers.patient.ShortPatientResponse;
import com.example.placebo.entities.Patient;
import com.example.placebo.entities.Trial;
import com.example.placebo.exceptions.ObjectNotFoundException;
import com.example.placebo.repository.PatientRepository;
import com.example.placebo.repository.TrialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService{

    private PatientRepository patientRepository;
    private TrialRepository trialRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository repository, TrialRepository trialRepository) {
        this.patientRepository = repository;
        this.trialRepository = trialRepository;
    }

    public List<ShortPatientResponse> getAllByTrialId(int trialId) {
        return patientRepository.findByTrial_Id(trialId)
                .stream()
                .map(ShortPatientResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ShortPatientResponse> getByTrialIdAndPhase(int id, Optional<Integer> phase) {
        return null;
    }


    @Override
    public List<ShortPatientResponse> getByTrialIdAndIsPlaceboAndPhase(int id, int isPlacebo, int phase) {
        return patientRepository.findByTrial_IdAndIsPlaceboAndPhase(id, isPlacebo, phase)
                .stream()
                .map(ShortPatientResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public PatientResponse add(CreatePatientRequest request) throws ObjectNotFoundException{
        Patient patient = createPatientFromRequest(request);
        patientRepository.save(patient);
        return new PatientResponse(patient);
    }

    public Patient createPatientFromRequest(CreatePatientRequest request) throws ObjectNotFoundException{
        Trial trial = trialRepository.findById(request.getTrialId()).orElseThrow(ObjectNotFoundException::new);
        Patient patient = new Patient();
        patient.setName(request.getName());
        patient.setSurname(request.getSurname());
        patient.setSsn(request.getSsn());
        patient.setBirthDate(request.getBirthDate());
        patient.setTrial(trial);
        patient.setPhase(trial.getPhase());
        patient.setIsPlacebo((int)Math.round(Math.random()));
        return patient;
    }
}