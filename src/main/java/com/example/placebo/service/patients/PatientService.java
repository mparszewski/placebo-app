package com.example.placebo.service.patients;

import com.example.placebo.controllers.patient.CreatePatientRequest;
import com.example.placebo.controllers.patient.PatientResponse;
import com.example.placebo.controllers.patient.ShortPatientResponse;
import com.example.placebo.exceptions.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    List<ShortPatientResponse> getAllByTrialId(int id);

    List<ShortPatientResponse> getByTrialIdAndPhase(int id, Optional<Integer> phase);

    List<ShortPatientResponse> getByTrialIdAndIsPlaceboAndPhase(int id, int isPlacebo, int phase);

    PatientResponse add(CreatePatientRequest request) throws ObjectNotFoundException;
}
