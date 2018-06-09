package com.example.placebo.service.trials;

import com.example.placebo.controllers.trials.*;
import com.example.placebo.entities.Patient;
import com.example.placebo.entities.Trial;
import com.example.placebo.exceptions.ObjectNotFoundException;
import com.example.placebo.repository.PatientRepository;
import com.example.placebo.repository.TrialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.ManyToOne;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrialServiceImpl implements TrialService{

    private TrialRepository trialRepository;
    private PatientRepository patientRepository;

    @Autowired
    public TrialServiceImpl(TrialRepository trialRepository, PatientRepository patientRepository) {
        this.trialRepository = trialRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public List<TrialResponse> findByIsArchived(int isArchived) throws ObjectNotFoundException {
        return trialRepository.findByIsArchived(isArchived)
                .stream()
                .map(TrialResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public ExtendedTrialResponse getTrialById(int id) throws ObjectNotFoundException{
        Trial trial = trialRepository.findById(id).orElseThrow(ObjectNotFoundException::new);
        ExtendedTrialResponse trialResponse = new ExtendedTrialResponse(trial);
        List<Patient> patients = patientRepository.findByTrial_IdAndPhase(trial.getId(),trial.getPhase());
        trialResponse.setNumberOfPatients(patients.size());
        return trialResponse;
    }

    @Override
    public TrialPhaseResponse getTrialPhaseById(int id) throws ObjectNotFoundException {
        Trial trial = trialRepository.findById(id).orElseThrow(ObjectNotFoundException::new);
        return new TrialPhaseResponse(trial);
    }

    @Override
    public TrialMaskingResponse getTrialMaskingById(int id) throws ObjectNotFoundException {
        Trial trial = trialRepository.findById(id).orElseThrow(ObjectNotFoundException::new);
        return new TrialMaskingResponse(trial);
    }

    @Override
    public TrialResponse save(CreateTrialRequest request) {
        Trial trial = trialRepository.save(createTrialFromRequest(request));
        return new TrialResponse(trial);
    }

    @Override
    public void setArchivisationById(int trialId) throws ObjectNotFoundException{
        Trial trial = trialRepository.findById(trialId).orElseThrow(ObjectNotFoundException::new);
        trial.setIsArchived(1);
        trialRepository.save(trial);
    }

    @Override
    public void setPhaseById(int trialId) throws ObjectNotFoundException {
        Trial trial = trialRepository.findById(trialId).orElseThrow(ObjectNotFoundException::new);
        if(trial.getPhase() != 4)
            trial.setPhase(trial.getPhase()+1);
        trialRepository.save(trial);
    }

    @Override
    public PasswordResponse checkPassword(int trialId, PasswordRequest request) throws ObjectNotFoundException {
        Trial trial = trialRepository.findById(trialId).orElseThrow(ObjectNotFoundException::new);
        PasswordResponse response = new PasswordResponse();
        if (trial.getPassword().equals(request.getPassword())) {
            if(trial.getIsPlaceboReversed() == 1) {
                response.setResponse("Group B is Placebo, group A is not placebo");
            }
            else
                response.setResponse("Group A is Placebo, group B is not placebo");
        } else
            response.setResponse("Incorrect password");
        return response;
    }

    public Trial createTrialFromRequest(CreateTrialRequest request) {
        Trial trial = new Trial();
        trial.setContactsAndLocations(request.getContactsAndLocations());
        trial.setEligibiltyCriterias(request.getEligibiltyCriterias());
        trial.setEstimatedEndDate(request.getEstimatedEndDate());
        trial.setIsArchived(0);
        trial.setMasking(request.getMasking());
        trial.setPhase(1);
        trial.setResponsibleParty(request.getResponsibleParty());
        trial.setStartDate(request.getStartDate());
        trial.setStudyDescription(request.getStudyDescription());
        trial.setStudyTitle(request.getStudyTitle());
        trial.setTreatmentDescription(request.getTreatmentDescription());
        trial.setPassword(request.getPassword());
        trial.setIsPlaceboReversed((int) Math.round(Math.random()));
        return trial;
    }


}
